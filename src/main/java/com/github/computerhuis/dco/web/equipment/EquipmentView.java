package com.github.computerhuis.dco.web.equipment;

import com.github.computerhuis.dco.repository.model.Equipment;
import com.github.computerhuis.dco.repository.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class EquipmentView {

    private Equipment equipment;
    private Person owner;
}
