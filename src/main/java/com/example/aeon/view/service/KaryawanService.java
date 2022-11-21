package com.example.aeon.view.service;

import com.example.aeon.model.Karyawan;
import com.example.aeon.model.dto.DtoCreateKaryawan;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface KaryawanService {
    Karyawan save(DtoCreateKaryawan dtoCreateKaryawanPlusDetail);

    Karyawan update(DtoUpdateKaryawan dtoUpdateKaryawan);

    List<Karyawan> getAll(); //kurang like byNama

    Karyawan getById(Long id);

    Page<Karyawan> findByNama(String nama, Pageable pageable);
}
