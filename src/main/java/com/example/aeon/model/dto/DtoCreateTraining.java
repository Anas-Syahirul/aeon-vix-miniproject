package com.example.aeon.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoCreateTraining {
    private Date createdDate;
    private String namaPengajar;
    private String tema;

    public DtoCreateTraining(String namaPengajar, String tema) {
        this.createdDate = new Date(java.time.LocalDate.now().toString());
        this.namaPengajar = namaPengajar;
        this.tema = tema;
    }
}
