package com.github.computerhuis.dco.web.timesheet;

import com.github.computerhuis.dco.repository.TimesheetOverviewRepository;
import com.github.computerhuis.dco.repository.view.TimesheetOverview;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/tijdregistratie")
@RestController
class TimesheetRestController {

    private final TimesheetOverviewRepository timesheetOverviewRepository;

    @GetMapping
    Map<String, List<TimesheetOverview>> get() {
        val result = new HashMap<String, List<TimesheetOverview>>();
        val data = timesheetOverviewRepository.findAll();
        result.put("data", data);
        return result;
    }
}
