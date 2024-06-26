package com.github.computerhuis.dco.web.workshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/werkplaats")
@Controller
class WorkshopController {

    @RequestMapping(method = GET)
    public String dashboard() {
        return "/workshop/index";
    }
}
