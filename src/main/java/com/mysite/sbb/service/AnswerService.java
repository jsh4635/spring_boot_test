package com.mysite.sbb.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.entity.Answer;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.entity.SiteUser;
import com.mysite.sbb.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author shjung
 * @since 24. 12. 10.
 */
@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setCreatedDate(LocalDateTime.now());
        answer.setAuthor(author);
        return this.answerRepository.save(answer);
    }

    public Answer getAnswer(Integer id) {
        Optional<Answer> optional = this.answerRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }else{
            throw new DataNotFoundException("answer not found");
        }
    }

    public void update(Answer answer, String content) {
        answer.setContent(content);
        answer.setUpdatedDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser user){
        answer.getVoter().add(user);
        this.answerRepository.save(answer);
    }
}
