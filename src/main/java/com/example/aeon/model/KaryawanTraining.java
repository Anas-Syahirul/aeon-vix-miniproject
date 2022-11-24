package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateKaryawanTraining;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;
    private Date tanggalTraining;

    @ManyToOne
    @JoinColumn(name = "karyawan_id", referencedColumnName = "id")
    private Karyawan karyawan;

    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    public KaryawanTraining() {

    }

    public KaryawanTraining(DtoCreateKaryawanTraining dtoCreateKaryawanTraining) {
        this.createdDate = new Date();
        this.tanggalTraining = dtoCreateKaryawanTraining.getTanggalTraining();
        this.karyawan = new Karyawan(dtoCreateKaryawanTraining.getIdKaryawan());
        this.training = new Training(dtoCreateKaryawanTraining.getIdTraining());
    }
}
