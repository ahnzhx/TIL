package com.java.tddTheJava.member;


import com.java.tddTheJava.domain.Member;
import com.java.tddTheJava.domain.Study;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long id);
    void validate(Long memberId);
    void notify(Study newStudy);
    void notify(Member member);
}
