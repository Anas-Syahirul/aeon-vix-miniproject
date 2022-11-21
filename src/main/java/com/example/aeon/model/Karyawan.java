package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateKaryawan;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
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

    public Karyawan() {

    }

    public Karyawan(Long id) {
        this.id = id;
    }

    public Karyawan(String nama, String jk, Date dob, String alamat, String status) {
        this.nama = nama;
        this.jk = jk;
        this.dob = dob;
        this.alamat = alamat;
        this.status = status;
    }

    public Karyawan(DtoCreateKaryawan dtoCreateKaryawan) {
        this.createdDate = new Date(java.time.LocalDate.now().toString());
        this.nama = dtoCreateKaryawan.getNama();
        this.jk = dtoCreateKaryawan.getJk();
        this.dob = dtoCreateKaryawan.getDob();
        this.alamat = dtoCreateKaryawan.getAlamat();
    }

    public Karyawan(DtoUpdateKaryawan dtoUpdateKaryawan) {
        this.updatedDate = dtoUpdateKaryawan.getUpdatedDate();
        this.nama = dtoUpdateKaryawan.getNama();
        this.jk = dtoUpdateKaryawan.getJk();
        this.dob = dtoUpdateKaryawan.getDob();
        this.alamat = dtoUpdateKaryawan.getAlamat();
    }

}
