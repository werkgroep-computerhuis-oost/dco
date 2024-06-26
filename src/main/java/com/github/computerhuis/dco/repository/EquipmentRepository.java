package com.github.computerhuis.dco.repository;

import com.github.computerhuis.dco.repository.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
}
