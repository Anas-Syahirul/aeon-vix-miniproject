package com.example.aeon.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoUpdateKaryawan {
    private Long id;
    private String nama;
    private String jk;
    private Date dob;
    private String alamat;
    private String status;

    private String nik;
    private String npwp;

    public DtoUpdateKaryawan(Long id, String nama, String jk, Date dob, String alamat, String status,
                             String nik, String npwp){
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.alamat = alamat;
        this.status = status;

        this.nik = nik;
        this.npwp = npwp;

    }
}
