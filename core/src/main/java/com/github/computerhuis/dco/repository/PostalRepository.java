package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Postal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostalRepository extends JpaRepository<Postal, String> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    List<Postal> findByPoboxFalse();
}
