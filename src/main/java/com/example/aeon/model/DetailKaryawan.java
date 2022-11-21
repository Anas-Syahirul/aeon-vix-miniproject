package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateKaryawan;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "npwp")
    private String npwp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id")
    private Karyawan karyawan;

    public DetailKaryawan() {

    }

    public DetailKaryawan(DtoCreateKaryawan dtoCreateKaryawanPlusDetail) {
        this.nik = dtoCreateKaryawanPlusDetail.getNik();
        this.npwp = dtoCreateKaryawanPlusDetail.getNpwp();
    }

    public DetailKaryawan(Karyawan karyawan, String nik, String npwp) {
        this.karyawan = karyawan;
        this.nik = nik;
        this.npwp = npwp;
    }
}
