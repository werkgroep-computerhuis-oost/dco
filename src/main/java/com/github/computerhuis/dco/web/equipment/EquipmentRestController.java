package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.repository.EquipmentRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/apparatuur")
@RestController
class EquipmentRestController {

    private final EquipmentRepository equipmentRepository;

    @GetMapping
    Map<String, List<Equipment>> get() {
        val result = new HashMap<String, List<Equipment>>();
        val data = equipmentRepository.findAll();
        result.put("data", data);

        return result;
    }
}
