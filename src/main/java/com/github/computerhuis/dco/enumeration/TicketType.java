package com.github.computerhuis.dco.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TicketType {
    REPAIR("Reparatie"),
    ISSUE("Uitgifte");

    private final String label;
}
