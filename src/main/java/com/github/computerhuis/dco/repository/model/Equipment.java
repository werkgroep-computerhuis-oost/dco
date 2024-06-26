package com.github.computerhuis.dco.repository.model;

import com.github.computerhuis.dco.enumeration.EquipmentCategoryType;
import com.github.computerhuis.dco.enumeration.EquipmentStatus;
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
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentCategoryType category;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    private String manufacturer;
    private String model;

    private String specification;
    private Long customerId;

    public String getCategoryName() {
        if (category != null) {
            return category.getLabel();
        }
        return null;
    }
}
