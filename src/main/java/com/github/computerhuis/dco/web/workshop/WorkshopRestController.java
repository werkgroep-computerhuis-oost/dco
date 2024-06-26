package com.github.computerhuis.dco.web.workshop;

import com.github.computerhuis.dco.repository.PersonRepository;
import com.github.computerhuis.dco.repository.TicketOverviewRepository;
import com.github.computerhuis.dco.repository.model.Person;
import com.github.computerhuis.dco.repository.view.TicketOverview;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@RequestMapping("/api/werkplaats")
@RequiredArgsConstructor
@RestController
class WorkshopRestController {

    private final TicketOverviewRepository ticketOverviewRepository;
    private final PersonRepository personRepository;

    @GetMapping
    Map<String, List<TicketOverview>> get() {
        val result = new HashMap<String, List<TicketOverview>>();
        val data = ticketOverviewRepository.getActiveTickets();
        result.put("data", data);

        return result;
    }

    @GetMapping(value = "/personen")
    List<Person> searchPersoon(@RequestParam(name = "voornaam", required = false) final String firstName,
                               @RequestParam(name = "achternaam", required = false) final String lastName) {

        if (isNotBlank(firstName) && isNotBlank(lastName)) {
            return personRepository.findByFirstNameAndLastName(firstName, lastName);
        }

        if (isNotBlank(firstName)) {
            return personRepository.findByFirstName(firstName);
        }

        if (isNotBlank(lastName)) {
            return personRepository.findByLastName(lastName);
        }

        return Collections.emptyList();
    }

}
