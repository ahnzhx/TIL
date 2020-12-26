package com.java.tddTheJava.study;

import com.java.tddTheJava.domain.Member;
import com.java.tddTheJava.domain.Study;
import com.java.tddTheJava.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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

    /**
     * test for stubbing mock object
     */
    @Test
    void stubbingTest(){
        //given
        Study study = new Study(10, "테스트");
        StudyService studyService = new StudyService(memberService, studyRepository);

        // memberService 객체에 findById 메소드를 1L 값으로 호출하면 Optional.of(member) 객체를 리턴하도록 Stubbing
        Member member = new Member();
        member.setId(10L);
        member.setEmail("sonnie@email.com");
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        assertEquals(member, memberService.findById(1L).get());

        // studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 Stubbing
        study.setOwner(member);
        when(studyRepository.save(any(Study.class))).thenReturn(study);
        studyService.createNewStudy(1L, study);


        // when -> given 으로 변경 (BDD)
        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // then
        then(memberService).should().notify(study);
        assertNotNull(study.getOwner());
        assertEquals(member, study.getOwner());

        // memberService 에서 notify 메서드가 몇번 호출되었는지 확인
        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);
        verify(memberService, never()).validate(1L);

        // 호출된 순서 테스트하기
        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);

        // memberService 가 호출된 이후 연결이 끊겼는지 확인
//        verifyNoInteractions(memberService);
      //then(memberService).shouldHaveNoMoreInteractions();
    }

    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    @Test
    void openStudy() {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");
        given(studyRepository.save(any())).willReturn(study);

        // When
        studyService.openStudy(study);

        // Then
        assertEquals(StudyStatus.OPENED, study.getStatus());
        assertNotNull(study.getOpenedDateTime());
        then(memberService).should().notify(study);
    }

}