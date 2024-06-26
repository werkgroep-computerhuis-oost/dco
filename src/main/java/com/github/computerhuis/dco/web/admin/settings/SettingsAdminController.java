package com.github.computerhuis.dco.web.admin.settings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/beheer/instellingen")
@Controller
class SettingsAdminController {

    @GetMapping
    public String dashboard() {
        return "/admin/settings/index";
    }
}
