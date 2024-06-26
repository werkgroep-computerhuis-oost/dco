package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
