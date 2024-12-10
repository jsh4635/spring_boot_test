package com.mysite.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shjung
 * @since 2024. 12. 10.
 */
@Controller
public class MainController {

    /**
     *
     *
     * @author shjung
     * @since 24. 12. 10.
     */
    @GetMapping("/")
    public String home(){
        return "redirect:/question/list";
    }
}
