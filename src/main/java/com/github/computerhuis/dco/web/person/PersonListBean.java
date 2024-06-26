package com.github.computerhuis.dco.web.person;

import com.github.computerhuis.dco.repository.PersonRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import com.github.computerhuis.dco.repository.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Data
@ViewScoped
@Component
public class PersonListBean {

    private final PersonRepository personRepository;

    private List<Person> list;
    private Equipment selected;

    @PostConstruct
    public void init() {
        list = personRepository.findAll();
    }

}
