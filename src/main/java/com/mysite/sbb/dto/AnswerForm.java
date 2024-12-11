package com.mysite.sbb.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 *
 * @author shjung
 * @since 24. 12. 11.
 */
@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String content;
}
