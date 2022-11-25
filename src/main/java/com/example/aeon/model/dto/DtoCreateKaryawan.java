package com.example.aeon.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoCreateKaryawan {
    private String nama;
    private String jk;

    private Integer dobYear;

    private Integer dobMonth;

    private Integer dobDay;
    private String alamat;
    private String status;

    private String nik;
    private String npwp;

    public DtoCreateKaryawan(String nama, String jk, Date dob, String alamat, String status,
                             String nik, String npwp){
        this.nama = nama;
        this.jk = jk;
        this.alamat = alamat;
        this.status = status;
        this.nik = nik;
        this.npwp = npwp;

    }
}
