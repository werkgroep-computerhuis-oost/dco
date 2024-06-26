package com.github.computerhuis.dco.web.ticket;

import com.github.computerhuis.dco.repository.TicketOverviewRepository;
import com.github.computerhuis.dco.repository.view.TicketOverview;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/ticket")
@RestController
class TicketRestController {

    private final TicketOverviewRepository ticketOverviewRepository;

    @GetMapping
    Map<String, List<TicketOverview>> get() {
        val result = new HashMap<String, List<TicketOverview>>();
        val data = ticketOverviewRepository.findAll();
        result.put("data", data);

        return result;
    }
}
