package com.github.computerhuis.dco.web.counter;

import com.github.computerhuis.dco.repository.view.TimesheetOverview;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class CounterModel {

    public CounterModel() {
        timesheet = new ArrayList<>();
    }

    private LocalDate datum;
    private List<TimesheetOverview> timesheet;
}
