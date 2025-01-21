package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.repository.EquipmentRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Data
@Component
public class EquipmentListBean {

    private final EquipmentRepository equipmentRepository;

    private List<Equipment> list;
    private Equipment selected;

    @PostConstruct
    public void init() {
        list = equipmentRepository.findAll();
    }

}
