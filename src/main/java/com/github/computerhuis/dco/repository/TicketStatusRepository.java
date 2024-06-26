package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.TicketStatus;
import com.github.computerhuis.dco.repository.model.TicketStatusPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, TicketStatusPrimaryKey> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<TicketStatus> findByTicketId(Long ticketId);
}
