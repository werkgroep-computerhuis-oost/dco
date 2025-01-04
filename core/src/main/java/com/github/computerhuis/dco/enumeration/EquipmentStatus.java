package com.github.computerhuis.dco.enumeration;

import com.github.computerhuis.dco.config.MessageSourceBundles;

public enum EquipmentStatus {
    CUSTOMER_OWNED, INCOMING_GIFT, SUITABLE_FOR_GIFT, RESERVED, GIFT_ISSUED, DEMOLITION;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.equipment.status." + name().toLowerCase());
    }

}
