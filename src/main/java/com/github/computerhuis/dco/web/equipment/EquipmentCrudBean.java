package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.repository.EquipmentRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@RequiredArgsConstructor
@Data
@Component
public class EquipmentCrudBean {

    private final EquipmentRepository equipmentRepository;

    private Equipment equipment;
    private Long id;

    @PostConstruct
    public void init() {
        equipment = new Equipment();
    }

    public void fetch() {
        equipment = equipmentRepository.findById(id).orElse(new Equipment());
    }

    public String getCategory() {
        return equipment.getCategory().name();
    }

    public void setCategory(final String value) {

        if (isNotBlank(value)) {

        }
    }
}
