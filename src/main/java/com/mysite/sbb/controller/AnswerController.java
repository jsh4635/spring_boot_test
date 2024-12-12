package com.mysite.sbb.controller;

import com.mysite.sbb.dto.AnswerForm;
import com.mysite.sbb.entity.Answer;
import com.mysite.sbb.entity.Question;
import com.mysite.sbb.entity.SiteUser;
import com.mysite.sbb.service.AnswerService;
import com.mysite.sbb.service.QuestionService;
import com.mysite.sbb.service.SiteUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

/**
 * @author shjung
 * @since 24. 12. 10.
 */
@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final SiteUserService siteUserService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteuser = this.siteUserService.getUser(principal.getName());
        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.create(question, answerForm.getContent(), siteuser);
        return String.format("redirect:/question/detail/%s",id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/update/{id}")
    public String updateAnswer(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
        Answer answer = this.answerService.getAnswer(id);
        if(!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        answerForm.setContent(answer.getContent());
        return "answer_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/update/{id}")
    public String updateAnswer(@Valid AnswerForm answerForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
        if(bindingResult.hasErrors()) {
            return "answer_form";
        }

        Answer answer = this.answerService.getAnswer(id);
        if(!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.answerService.update(answer, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String deleteAnswer(Principal principal, @PathVariable("id") Integer id) {
        Answer answer = this.answerService.getAnswer(id);
        if(!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        this.answerService.delete(answer);
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }
}
