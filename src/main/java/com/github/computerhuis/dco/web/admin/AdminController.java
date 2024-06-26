package com.github.computerhuis.dco.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/beheer")
@Controller
class AdminController {

    @GetMapping
    public String dashboard() {
        return "/admin/index";
    }


}
