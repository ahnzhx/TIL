package com.java.tddTheJava.study;

import com.java.tddTheJava.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
