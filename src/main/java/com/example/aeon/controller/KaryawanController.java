package com.example.aeon.controller;

import com.example.aeon.model.Karyawan;
import com.example.aeon.model.dto.DtoCreateKaryawan;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
import com.example.aeon.view.service.KaryawanService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanService karyawanService;
    @PostMapping("")
    public ResponseEntity<Karyawan> insertKaryawan(@RequestBody DtoCreateKaryawan dtoCreateKaryawan) {
        Karyawan karyawan = karyawanService.save(dtoCreateKaryawan);
        return new ResponseEntity<>(karyawan, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Karyawan> updateKaryawan(@RequestBody DtoUpdateKaryawan dtoUpdateKaryawan) {
        Karyawan updatedKaryawan = karyawanService.update(dtoUpdateKaryawan);
        return new ResponseEntity<>(updatedKaryawan, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Karyawan>> getListKaryawan(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "5") Integer size,
                                                          @RequestParam(required = false) String nama){
        Pageable paging = PageRequest.of(page, size);
        Page<Karyawan> listKaryawan = karyawanService.findByNama(nama, paging);
        return new ResponseEntity<>(listKaryawan, HttpStatus.OK);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Karyawan> getById(@PathVariable("ID") Long id) {
        Karyawan karyawan = karyawanService.getById(id);
        return new ResponseEntity<>(karyawan, HttpStatus.OK);
    }
}
