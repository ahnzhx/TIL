package com.java.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PlatformTransactionManager transactionManager;
    private TransactionStatus status;

    public MemberService(MemberRepository memberRepository, PlatformTransactionManager transactionManager) {
        this.memberRepository = memberRepository;
        this.transactionManager = transactionManager;
    }

    public Member createMember(Member member){
        status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        Member persistedMember = memberRepository.save(member);
        System.out.println(status.toString());
        return persistedMember;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean findMember(Long memSeq){
        status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        boolean isNull = memberRepository.findById(memSeq).isPresent();
        System.out.println(status.toString());
        return isNull;
    }
}
