package com.example.aeon.view.service;

import com.example.aeon.model.KaryawanTraining;
import com.example.aeon.model.dto.DtoCreateKaryawanTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KaryawanTrainingService {

    KaryawanTraining save(DtoCreateKaryawanTraining dtoCreateKaryawanTraining);

    // getbypaginationlalalala
    Page<KaryawanTraining> getListByKaryawanAndTraining(String namaKaryawan, String namaPengajar, Pageable pageable);
}
