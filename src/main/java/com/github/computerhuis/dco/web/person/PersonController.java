package com.github.computerhuis.dco.web.person;

import com.github.computerhuis.dco.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/persoon")
@Validated
@Controller
class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    public String all() {
        return "/person/all";
    }

    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final PersonView view) {
        val person = personRepository.findById(id);
        person.ifPresent(view::setPerson);
        return "/person/index";
    }
}
