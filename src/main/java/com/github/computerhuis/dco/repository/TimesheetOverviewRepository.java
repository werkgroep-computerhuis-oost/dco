package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.view.TimesheetOverview;
import com.github.computerhuis.dco.repository.view.TimesheetOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TimesheetOverviewRepository extends JpaRepository<TimesheetOverview, TimesheetOverviewPrimaryKey> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<TimesheetOverview> findByPersonId(Long personId);

    List<TimesheetOverview> findByRegisteredBetween(LocalDateTime start, LocalDateTime end);
}
