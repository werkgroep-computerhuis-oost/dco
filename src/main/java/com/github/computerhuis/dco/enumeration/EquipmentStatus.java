package com.github.computerhuis.dco.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EquipmentStatus {
    CUSTOMER_OWNED(""),
    INCOMING_GIFT(""),
    SUITABLE_FOR_GIFT(""),
    RESERVED(""),
    GIFT_ISSUED(""),
    DEMOLITION("");

    private final String label;
}
