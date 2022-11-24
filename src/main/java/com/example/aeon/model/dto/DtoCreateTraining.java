package com.example.aeon.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoCreateTraining {
    private String namaPengajar;
    private String tema;

    public DtoCreateTraining(String namaPengajar, String tema) {
        this.namaPengajar = namaPengajar;
        this.tema = tema;
    }
}
