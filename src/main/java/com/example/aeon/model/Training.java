package com.example.aeon.model;

import com.example.aeon.model.dto.DtoCreateTraining;
import com.example.aeon.model.dto.DtoUpdateTraining;
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

    public Training() {

    }

    public Training(Long id) {
        this.id = id;
    }

    public Training(DtoCreateTraining dtoCreateTraining) {
        this.createdDate = new Date(java.time.LocalDate.now().toString());
        this.namaPengajar = dtoCreateTraining.getNamaPengajar();
        this.tema = dtoCreateTraining.getTema();
    }

    public Training(DtoUpdateTraining dtoUpdateTraining) {
        this.updatedDate = dtoUpdateTraining.getUpdatedDate();
        this.namaPengajar = dtoUpdateTraining.getNamaPengajar();
        this.tema = dtoUpdateTraining.getTema();
    }
}
