package com.github.computerhuis.dco.repository.model;

import com.github.computerhuis.dco.enumeration.TicketStatusType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket_status")
@IdClass(TicketStatusPrimaryKey.class)
public class TicketStatus {

    @Id
    private Long ticketId;
    @Id
    private LocalDateTime date;

    private Long volunteerId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatusType status;
}
