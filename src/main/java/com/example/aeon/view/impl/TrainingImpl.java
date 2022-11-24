package com.example.aeon.view.impl;

import com.example.aeon.model.Training;
import com.example.aeon.model.dto.DtoCreateTraining;
import com.example.aeon.model.dto.DtoUpdateTraining;
import com.example.aeon.repository.TrainingRepo;
import com.example.aeon.view.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TrainingImpl implements TrainingService {

    @Autowired
    TrainingRepo trainingRepo;

    @Override
    public Training save(DtoCreateTraining dtoCreateTraining) {
        return trainingRepo.save(new Training(dtoCreateTraining));
    }

    @Override
    public Training update(DtoUpdateTraining dtoUpdateTraining) {
        Training selectedTraining = trainingRepo.findById(dtoUpdateTraining.getId()).orElse(new Training());
        if (selectedTraining.getId() != null) {
            selectedTraining.setUpdatedDate(new Date());
            selectedTraining.setNamaPengajar(dtoUpdateTraining.getNamaPengajar());
            selectedTraining.setTema(dtoUpdateTraining.getTema());
            return trainingRepo.save(selectedTraining);
        }
        return null;
    }

    @Override
    public Training getTrainingById(Long id) {
        Training selectedTraining = trainingRepo.findById(id).orElse(new Training());
        if (selectedTraining.getId() != null) {
            return selectedTraining;
        }
        return null;
    }

    @Override
    public Page<Training> findByNamaPengajar(String namaPengajar, Pageable pageable) {
        if (namaPengajar == null) {
            return trainingRepo.getAllTrainingList(pageable);
        }
        return trainingRepo.getTransaksiByNamaPengajar(namaPengajar, pageable);
    }
}
