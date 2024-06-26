package com.github.computerhuis.dco.enumeration;

import com.github.computerhuis.dco.config.MessageSourceBundles;

public enum TicketStatusType {
    OPEN, IN_PROGRESS, READY, CUSTOMER_INFORMED, CLOSED;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.ticket.status." + name().toLowerCase());
    }
}
