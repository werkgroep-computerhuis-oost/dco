package com.github.computerhuis.dco.repository.view;

import com.github.computerhuis.dco.enumeration.EquipmentCategoryType;
import com.github.computerhuis.dco.enumeration.TicketStatusType;
import com.github.computerhuis.dco.enumeration.TicketType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Getter
@Setter
@Entity
@Table(name = "ticket_overview")
public class TicketOverview {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private TicketStatusType status;
    private Long equipmentId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    private String description;
    private String firstName;
    private String infix;
    private String lastName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentCategoryType category;
    private String manufacturer;
    private String model;

    public String getPractitioner() {
        val result = new StringBuilder();
        result.append(firstName);
        if (isNotBlank(infix)) {
            result.append(" ");
            result.append(infix);
        }
        result.append(" ");
        result.append(lastName);

        return result.toString().trim();
    }

    public String getTicketTypeName() {
        if (ticketType != null) {
            return ticketType.getLabel();
        }
        return null;
    }

    public String getStatusName() {
        if (status != null) {
            return status.getLabel();
        }
        return null;
    }

    public String getCategoryName() {
        if (category != null) {
            return category.getLabel();
        }
        return null;
    }
}
