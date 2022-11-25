package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateKaryawan;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private String alamat;
    private String status;
    @JsonIgnore
    @OneToOne(mappedBy = "karyawan")
    private DetailKaryawan detailKaryawan;

    @JsonIgnore
    @OneToMany(mappedBy = "karyawan")
    private List<Rekening> rekeningList;

    @JsonIgnore
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
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, dtoCreateKaryawan.getDobYear());
        cal.set(Calendar.MONTH, dtoCreateKaryawan.getDobMonth() - 1);
        cal.set(Calendar.DAY_OF_MONTH, dtoCreateKaryawan.getDobDay());
        this.dob = cal.getTime();
        this.createdDate = new Date();
        this.nama = dtoCreateKaryawan.getNama();
        this.jk = dtoCreateKaryawan.getJk();
        this.alamat = dtoCreateKaryawan.getAlamat();
        this.status = dtoCreateKaryawan.getStatus();
    }

    public Karyawan(DtoUpdateKaryawan dtoUpdateKaryawan) {
        this.updatedDate = new Date();
        this.nama = dtoUpdateKaryawan.getNama();
        this.jk = dtoUpdateKaryawan.getJk();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, dtoUpdateKaryawan.getDobYear());
        cal.set(Calendar.MONTH, dtoUpdateKaryawan.getDobMonth() - 1);
        cal.set(Calendar.DAY_OF_MONTH, dtoUpdateKaryawan.getDobDay());
        this.dob = cal.getTime();
        this.alamat = dtoUpdateKaryawan.getAlamat();
    }

}
