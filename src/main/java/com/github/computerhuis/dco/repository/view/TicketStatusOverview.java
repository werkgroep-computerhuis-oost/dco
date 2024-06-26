package com.github.computerhuis.dco.repository.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.computerhuis.dco.enumeration.TicketStatusType;
import com.github.computerhuis.dco.repository.model.TicketStatusPrimaryKey;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@DynamicUpdate
@DynamicInsert
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket_status_overview")
@IdClass(TicketStatusPrimaryKey.class)
public class TicketStatusOverview {

    @Id
    private Long ticketId;
    @Id
    private LocalDateTime date;

    private Long volunteerId;
    private String firstName;
    private String infix;
    private String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatusType status;

    @JsonIgnore
    public String getFullname() {
        val value = new StringBuilder();
        value.append(firstName);
        if (isNotBlank(infix)) {
            value.append(" ");
            value.append(infix);
        }
        if (isNotBlank(lastName)) {
            value.append(" ");
            value.append(lastName);
        }
        return value.toString();
    }
}
