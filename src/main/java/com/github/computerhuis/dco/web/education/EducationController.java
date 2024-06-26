package com.github.computerhuis.dco.web.education;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/educatie")
@Controller
class EducationController {
    @RequestMapping(method = GET)
    public String dashboard() {
        return "/education/index";
    }
}
