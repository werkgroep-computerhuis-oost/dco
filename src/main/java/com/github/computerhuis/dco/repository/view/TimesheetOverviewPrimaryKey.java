package com.github.computerhuis.dco.repository.view;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TimesheetOverviewPrimaryKey implements Serializable {

    private static final long serialVersionUID = -6035199582221419640L;

    private Long personId;
    private Long activityId;
    private LocalDateTime registered;
}
