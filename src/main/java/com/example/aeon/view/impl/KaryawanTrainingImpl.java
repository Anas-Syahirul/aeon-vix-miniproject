package com.example.aeon.view.impl;

import com.example.aeon.model.Karyawan;
import com.example.aeon.model.KaryawanTraining;
import com.example.aeon.model.Training;
import com.example.aeon.model.dto.DtoCreateKaryawanTraining;
import com.example.aeon.repository.KaryawanRepo;
import com.example.aeon.repository.KaryawanTrainingRepo;
import com.example.aeon.repository.TrainingRepo;
import com.example.aeon.view.service.KaryawanTrainingService;
import org.springframework.beans.factory.annotation.Autowired;

public class KaryawanTrainingImpl implements KaryawanTrainingService {
    @Autowired
    private KaryawanTrainingRepo karyawanTrainingRepo;

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    private KaryawanRepo karyawanRepo;

    @Override
    public KaryawanTraining save(DtoCreateKaryawanTraining dtoCreateKaryawanTraining) {
        Karyawan karyawan = karyawanRepo.findById(dtoCreateKaryawanTraining.getIdKaryawan()).orElse(new Karyawan());
        Training training = trainingRepo.findById(dtoCreateKaryawanTraining.getIdTraining()).orElse(new Training());
        if (karyawan.getNama() == null || training.getNamaPengajar() == null) {
            return null; // tidak ada id yg sesuai dengan karyawan/training
        }
        return karyawanTrainingRepo.save(new KaryawanTraining(dtoCreateKaryawanTraining));
    }


}
