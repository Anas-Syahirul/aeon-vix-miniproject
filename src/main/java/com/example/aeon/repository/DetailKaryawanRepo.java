package com.example.aeon.repository;

import com.example.aeon.model.DetailKaryawan;
import com.example.aeon.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailKaryawanRepo extends JpaRepository<DetailKaryawan, Long> {
    DetailKaryawan getDetailKaryawanByKaryawan(Karyawan karyawan);
}
