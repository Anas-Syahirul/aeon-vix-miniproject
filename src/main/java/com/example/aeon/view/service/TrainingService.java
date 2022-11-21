package com.example.aeon.view.service;

import com.example.aeon.model.Training;
import com.example.aeon.model.dto.DtoCreateTraining;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
import com.example.aeon.model.dto.DtoUpdateTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TrainingService {
    Training save(DtoCreateTraining dtoCreateTraining);

    Training update(DtoUpdateTraining dtoUpdateTraining);

    // getall pagination blm

    Training getTrainingById(Long id);

    Page<Training> findByNamaPengajar(String namaPengajar, Pageable pageable);
}
