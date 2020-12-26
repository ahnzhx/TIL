package com.java.tddTheJava.member;


import com.java.tddTheJava.domain.Member;

import java.util.Optional;

public interface MemberService {
    Optional<Member> findById(Long id);
    void validate(Long memberId);
}
