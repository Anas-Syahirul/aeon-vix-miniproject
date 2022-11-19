package com.example.aeon.model;

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

}
