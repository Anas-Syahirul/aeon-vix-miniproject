package com.example.aeon.model;

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
}
