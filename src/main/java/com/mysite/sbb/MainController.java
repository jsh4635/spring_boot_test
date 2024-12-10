package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public int home(){
        System.out.println("home");
        return 22;
    }

    /**
     *
     *
     * @author shjung
     * @since 24. 12. 10.
     */
    @GetMapping("/about")
    @ResponseBody
    public String about(){
        System.out.println("about");
        return "안녕하세요";
    }
}
