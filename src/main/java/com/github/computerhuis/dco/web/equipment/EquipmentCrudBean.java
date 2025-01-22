package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.enumeration.EquipmentCategoryType;
import com.github.computerhuis.dco.repository.EquipmentRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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

    public List<EquipmentCategoryType> getEquipmentCategories() {
        return Arrays.asList(EquipmentCategoryType.values());
    }
}
