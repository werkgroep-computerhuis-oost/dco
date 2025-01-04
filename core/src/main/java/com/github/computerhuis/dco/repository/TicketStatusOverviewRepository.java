package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.view.TicketStatusOverview;
import com.github.computerhuis.dco.repository.view.TicketStatusOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketStatusOverviewRepository extends JpaRepository<TicketStatusOverview, TicketStatusOverviewPrimaryKey> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<TicketStatusOverview> findByTicketId(Long ticketId);
}
