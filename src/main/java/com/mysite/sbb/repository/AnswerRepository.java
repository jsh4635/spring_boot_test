package com.mysite.sbb.repository;

import com.mysite.sbb.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shjung
 * @since 24. 12. 10.
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
