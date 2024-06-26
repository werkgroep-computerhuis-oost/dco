package com.github.computerhuis.dco.repository.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TimesheetPrimaryKey implements Serializable {

    private static final long serialVersionUID = -8714404286147373620L;

    private Long personId;
    private Long activityId;
}
