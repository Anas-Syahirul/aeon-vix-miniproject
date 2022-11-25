package com.example.aeon.model.dto;

import lombok.Data;

@Data
public class DtoCreateKaryawanTraining {

    // dot stands for date of training
    private Integer dotYear;

    private Integer dotMonth;

    private Integer dotDay;

    private Long idKaryawan;
    private Long idTraining;
}
