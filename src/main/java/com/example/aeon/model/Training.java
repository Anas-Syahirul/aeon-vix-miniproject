package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateTraining;
import com.example.aeon.model.dto.DtoUpdateTraining;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "training")
    private List<KaryawanTraining> karyawanTrainingList;

    public Training() {

    }

    public Training(Long id) {
        this.id = id;
    }

    public Training(DtoCreateTraining dtoCreateTraining) {
        this.createdDate = new Date();
        this.namaPengajar = dtoCreateTraining.getNamaPengajar();
        this.tema = dtoCreateTraining.getTema();
    }

    public Training(DtoUpdateTraining dtoUpdateTraining) {
        this.updatedDate = new Date();
        this.namaPengajar = dtoUpdateTraining.getNamaPengajar();
        this.tema = dtoUpdateTraining.getTema();
    }
}
