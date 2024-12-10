package com.mysite.sbb;

import com.mysite.sbb.entity.Question;
import com.mysite.sbb.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa(){
		List<Question> all = this.questionRepository.findAll();
		assertEquals(4, all.size());

		Question question = all.get(0);
		assertEquals("sbb가 무엇인가요?", question.getSubject());
	}
}
