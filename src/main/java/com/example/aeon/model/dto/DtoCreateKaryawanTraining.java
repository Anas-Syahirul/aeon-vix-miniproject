package com.example.aeon.model.dto;

import com.example.aeon.model.Karyawan;
import com.example.aeon.model.Training;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class DtoCreateKaryawanTraining {
    private Date createdDate;
    private Date tanggalTraining;

    private Long idKaryawan;
    private Long idTraining;
}
