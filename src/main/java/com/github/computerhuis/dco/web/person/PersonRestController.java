package com.github.computerhuis.dco.web.person;

import com.github.computerhuis.dco.repository.PersonRepository;
import com.github.computerhuis.dco.repository.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/persoon")
@RestController

public class PersonRestController {

    private final PersonRepository personRepository;

    @GetMapping
    Map<String, List<Person>> get() {
        val result = new HashMap<String, List<Person>>();
        val data = personRepository.findAll();
        result.put("data", data);

        return result;
    }
}
