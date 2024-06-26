package com.github.computerhuis.dco.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping
    public String redirect() {
        return "/home";
    }
}
