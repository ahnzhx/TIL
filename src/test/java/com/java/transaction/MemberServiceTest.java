package com.java.transaction;

import com.google.j2objc.annotations.AutoreleasePool;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Optional;  

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest extends TestCase {

    @Mock
    private MemberService memberService;


    @Test
    void transactionTest(){
        Member member = new Member();
        member.setMemSeq(1L);
        member.setName("sonnie");
        member.setPassword("1234");
        member.setAddress("test");

        when(memberService.createMember(member)).thenReturn(member);
        Member persistedMember = memberService.createMember(member);

        boolean isNotNull = memberService.findMember(persistedMember.getMemSeq());
        assertTrue(isNotNull);
    }
}

