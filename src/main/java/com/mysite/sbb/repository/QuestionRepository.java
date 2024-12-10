package com.mysite.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.entity.Question;

/**
 * @author shjung
 * @since 24. 12. 10.
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
