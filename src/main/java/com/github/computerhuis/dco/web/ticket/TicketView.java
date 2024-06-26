package com.github.computerhuis.dco.web.ticket;

import com.github.computerhuis.dco.repository.model.Ticket;
import com.github.computerhuis.dco.repository.view.TicketLogOverview;
import com.github.computerhuis.dco.repository.view.TicketStatusOverview;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class TicketView {
    private Ticket ticket;
    private List<TicketStatusOverview> statusList;
    private List<TicketLogOverview> logList;
}
