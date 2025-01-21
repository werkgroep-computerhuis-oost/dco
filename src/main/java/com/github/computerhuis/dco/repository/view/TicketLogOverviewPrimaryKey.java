package com.github.computerhuis.dco.repository.view;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TicketLogOverviewPrimaryKey implements Serializable {

    private static final long serialVersionUID = -277822852731463990L;

    private Long ticketId;
    private LocalDateTime date;
}
