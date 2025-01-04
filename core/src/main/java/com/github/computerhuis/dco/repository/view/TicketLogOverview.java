package com.github.computerhuis.dco.repository.view;

import com.github.computerhuis.dco.repository.model.TicketLogPrimaryKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
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
@Table(name = "ticket_log_overview")
@IdClass(TicketLogPrimaryKey.class)
public class TicketLogOverview {

    @Id
    private Long ticketId;
    @Id
    private LocalDateTime date;

    private Long volunteerId;
    private String firstName;
    private String infix;
    private String lastName;

    private String log;

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
