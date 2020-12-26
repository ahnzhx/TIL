package com.java.tddTheJava.study;

import com.java.tddTheJava.domain.Member;
import com.java.tddTheJava.domain.Study;
import com.java.tddTheJava.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

// @Mock 을 사용하여 mock 객체들을 만들어 줄 수 있다.
@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService(){
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createNewStudy(@Mock MemberService memberService,
                        @Mock StudyRepository studyRepository){
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("sonnie@email.com");

        // mock 객체를 가지고 stubbing 을 한 것임
        // anyLong(): argument Matcher 라고 부름
        when(memberService.findById(anyLong())).thenReturn(Optional.of(member));

        Study study = new Study(10, "java");
//        Study newStudy = studyService.createNewStudy(1L, study);

        assertEquals("sonnie@email.com", memberService.findById(1L).get().getEmail());
        assertEquals("sonnie@email.com", memberService.findById(2L).get().getEmail());

    }

    @Test
    void createNewStudyWithStubbing(@Mock MemberService memberService){

        when(memberService.findById(1L)).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () ->{
            memberService.findById(1L);
        });

        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);
        assertThrows(IllegalArgumentException.class, () ->{
            memberService.validate(1L);
        });
    }

    /**
     * 메소드가 동일한 매개변수로 여러번 호출될 때 각기 다르게 행동하도록 조작할 수 있다.
     */
    @Test
    void createNewStudyWithConscutiveCalls(@Mock MemberService memberService,
                        @Mock StudyRepository studyRepository){
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("sonnie@email.com");

        when(memberService.findById(anyLong()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        assertEquals("sonnie@email.com", memberService.findById(1L).get().getEmail());
        assertThrows(RuntimeException.class,  () ->{
            memberService.findById(2L);
        });
        assertTrue(memberService.findById(1L).isEmpty());

    }
}