package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.view.TicketLogOverview;
import com.github.computerhuis.dco.repository.view.TicketLogOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketLogOverviewRepository extends JpaRepository<TicketLogOverview, TicketLogOverviewPrimaryKey> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<TicketLogOverview> findByTicketId(Long ticketId);
}
