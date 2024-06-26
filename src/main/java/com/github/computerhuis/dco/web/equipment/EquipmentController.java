package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.repository.EquipmentRepository;
import com.github.computerhuis.dco.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/apparatuur")
@Validated
@Controller
class EquipmentController {

    private final EquipmentRepository equipmentRepository;
    private final PersonRepository personRepository;

    @GetMapping
    public String all() {
        return "/equipment/all";
    }


    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final EquipmentView view) {

        val equipment = equipmentRepository.findById(id);
        if (equipment.isPresent()) {
            view.setEquipment(equipment.get());

            if (equipment.get().getCustomerId() != null) {
                val owner = personRepository.findById(equipment.get().getCustomerId());
                owner.ifPresent(view::setOwner);
            }
        }
        return "/equipment/index";
    }
}
