package com.github.computerhuis.dco.enumeration;

import com.github.computerhuis.dco.config.MessageSourceBundles;

public enum TicketType {
    REPAIR, ISSUE;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.ticket." + name().toLowerCase());
    }
}
