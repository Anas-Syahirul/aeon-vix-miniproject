package com.example.aeon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "karyawan")
public class Karyawan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;
    private String nama;
    private String jk;
    private Date dob;
    private String alamat;
    private String status;
    @OneToOne(mappedBy = "karyawan")
    private DetailKaryawan detailKaryawan;

    @OneToMany(mappedBy = "karyawan")
    private List<Rekening> rekeningList;

    @OneToMany(mappedBy = "karyawan")
    private List<KaryawanTraining> karyawanTrainingList;


}
