package com.github.computerhuis.dco.web.admin.reporting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/beheer/rapportage")
@Controller
class ReportingAdminController {

    @GetMapping
    public String dashboard() {
        return "/admin/reporting/index";
    }
}
