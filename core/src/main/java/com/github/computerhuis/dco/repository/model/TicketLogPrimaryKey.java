package com.github.computerhuis.dco.repository.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TicketLogPrimaryKey implements Serializable {

    private static final long serialVersionUID = 8813358491304643702L;

    private Long ticketId;
    private LocalDateTime date;
}
