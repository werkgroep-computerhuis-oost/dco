package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
