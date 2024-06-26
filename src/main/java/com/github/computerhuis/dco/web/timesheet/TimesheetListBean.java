package com.github.computerhuis.dco.web.timesheet;

import com.github.computerhuis.dco.repository.TimesheetOverviewRepository;
import com.github.computerhuis.dco.repository.model.Equipment;
import com.github.computerhuis.dco.repository.view.TimesheetOverview;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Data
@ViewScoped
@Component
public class TimesheetListBean {

    private final TimesheetOverviewRepository timesheetOverviewRepository;

    private List<TimesheetOverview> list;
    private Equipment selected;

    @PostConstruct
    public void init() {
        list = timesheetOverviewRepository.findAll();
    }
}
