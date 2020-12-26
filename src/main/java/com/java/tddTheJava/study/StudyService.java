package com.java.tddTheJava.study;

import com.java.tddTheJava.domain.Member;
import com.java.tddTheJava.domain.Study;
import com.java.tddTheJava.member.MemberService;

import java.util.Optional;

public class StudyService {
    private final MemberService memberService;

    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        // null 인 경우 assertException 을 던진다.
        assert memberService != null;
        assert repository != null;
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study){
        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(() ->
                new IllegalArgumentException("Member doesn't exist for id:" + memberId)));

        Study newStudy = repository.save(study);
        memberService.notify(newStudy);
        memberService.notify(member.get());

        return newStudy;
    }
}
