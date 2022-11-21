package com.example.aeon.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoUpdateTraining {
    private Long id;

    private Date updatedDate;
    private String namaPengajar;
    private String tema;

    public DtoUpdateTraining(Long id, String namaPengajar, String tema) {
        this.id = id;
        this.updatedDate = new Date(java.time.LocalDate.now().toString());
        this.namaPengajar = namaPengajar;
        this.tema = tema;
    }
}
