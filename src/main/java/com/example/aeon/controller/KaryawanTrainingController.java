package com.example.aeon.controller;

import com.example.aeon.model.KaryawanTraining;
import com.example.aeon.model.dto.DtoCreateKaryawanTraining;
import com.example.aeon.repository.KaryawanTrainingRepo;
import com.example.aeon.view.service.KaryawanTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/training-karyawan")
public class KaryawanTrainingController {

    @Autowired
    private KaryawanTrainingService karyawanTrainingService;

    @PostMapping("")
    public ResponseEntity<KaryawanTraining> insertKaryawanTraining(@RequestBody DtoCreateKaryawanTraining dtoCreateKaryawanTraining) {
        KaryawanTraining karyawanTraining = karyawanTrainingService.save(dtoCreateKaryawanTraining);
        return new ResponseEntity<>(karyawanTraining, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<KaryawanTraining>> getListPaging(@RequestParam(defaultValue = "1") Integer page,
                                                                @RequestParam(defaultValue = "5") Integer size,
                                                                @RequestParam(required = false) String namaKaryawan,
                                                                @RequestParam(required = false) String namaPengajar){
        Pageable paging = PageRequest.of(page - 1, size);
        Page<KaryawanTraining> listKaryawanTraining = karyawanTrainingService.
                getListByKaryawanAndTraining(namaKaryawan, namaPengajar, paging);

        return new ResponseEntity<>(listKaryawanTraining, HttpStatus.OK);

    }
}
