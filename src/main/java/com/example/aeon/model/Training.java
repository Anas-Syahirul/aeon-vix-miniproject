package com.example.aeon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "training")
public class Training {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdDate;
    private Date deletedDate;
    private Date updatedDate;
    private String namaPengajar;
    private String tema;

    @OneToMany(mappedBy = "training")
    private List<KaryawanTraining> karyawanTrainingList;
}
