package com.example.aeon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "rekening")
public class Rekening {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;
    private String jenis;
    private String nama;
    private String nomor;
    @ManyToOne
    @JoinColumn(name = "karyawan_id", referencedColumnName = "id")
    private Karyawan karyawan;
}
