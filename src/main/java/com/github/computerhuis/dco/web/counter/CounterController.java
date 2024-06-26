package com.github.computerhuis.dco.web.counter;

import com.github.computerhuis.dco.repository.TimesheetOverviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/balie")
@Controller
class CounterController {

    private final TimesheetOverviewRepository timesheetOverviewRepository;

    @GetMapping
    public String index(@RequestParam(name = "datum", required = false) LocalDate datum, final CounterModel model) {

        model.setDatum(datum);
        if (datum == null) datum = LocalDate.now();
        model.setTimesheet(timesheetOverviewRepository.findByRegisteredBetween(datum.atStartOfDay(), datum.plusDays(1).atStartOfDay().minusSeconds(1)));

        return "/counter/index";
    }

    @GetMapping("/aanmelden")
    public String register() {
        return "/counter/register";
    }

}
