package com.github.computerhuis.dco.web.ticket;

import com.github.computerhuis.dco.repository.TicketLogOverviewRepository;
import com.github.computerhuis.dco.repository.TicketRepository;
import com.github.computerhuis.dco.repository.TicketStatusOverviewRepository;
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
@RequestMapping("/ticket")
@Validated
@Controller
class TicketController {

    private final TicketRepository ticketRepository;
    private final TicketStatusOverviewRepository ticketStatusRepository;
    private final TicketLogOverviewRepository ticketLogRepository;

    @GetMapping
    public String all() {
        return "/ticket/all";
    }

    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final TicketView view) {
        val ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            view.setTicket(ticket.get());
            view.setStatusList(ticketStatusRepository.findByTicketId(id));
            view.setLogList(ticketLogRepository.findByTicketId(id));
        }
        return "/ticket/index";
    }
}
