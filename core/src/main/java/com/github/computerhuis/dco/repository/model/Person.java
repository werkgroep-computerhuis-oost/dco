package com.github.computerhuis.dco.repository.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@DynamicUpdate
@DynamicInsert
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "individuals")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String initials;
    private String firstName;
    private String infix;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String mobile;
    private String telephone;
    private String postalCode;
    private String street;
    private Integer houseNumber;
    private String houseNumberAddition;
    private String city;
    private String comments;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    private String msaccess;

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

    public Long getAge() {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public String getDateOfBirthAsISO() {
        if (dateOfBirth != null) {
            return dateOfBirth.toString();
        }
        return null;
    }
}
