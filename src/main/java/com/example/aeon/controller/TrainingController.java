package com.example.aeon.controller;

import com.example.aeon.model.Training;
import com.example.aeon.model.dto.DtoCreateTraining;
import com.example.aeon.model.dto.DtoUpdateTraining;
import com.example.aeon.repository.TrainingRepo;
import com.example.aeon.view.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping("")
    public ResponseEntity<Training> insertTraining(@RequestBody DtoCreateTraining dtoCreateTraining) {
        Training train = trainingService.save(dtoCreateTraining);
        return new ResponseEntity<>(train, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Training> updateTraining(@RequestBody DtoUpdateTraining dtoUpdateTraining) {
        Training train = trainingService.update(dtoUpdateTraining);
        return new ResponseEntity<>(train, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Training>> getListTraining(@RequestParam(defaultValue = "1") Integer page,
                                                          @RequestParam(defaultValue = "5") Integer size,
                                                          @RequestParam(required = false) String namaPengajar) {
        Pageable paging = PageRequest.of(page - 1, size);
        Page<Training> listTraining = trainingService.findByNamaPengajar(namaPengajar, paging);
        return new ResponseEntity<>(listTraining, HttpStatus.OK);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Training> getTrainingByID(@PathVariable("ID") Long id) {
        Training traing = trainingService.getTrainingById(id);
        return new ResponseEntity<>(traing, HttpStatus.OK);
    }

}
