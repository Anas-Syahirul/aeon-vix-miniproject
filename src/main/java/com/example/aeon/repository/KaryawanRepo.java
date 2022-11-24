package com.example.aeon.repository;

import com.example.aeon.model.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepo extends JpaRepository<Karyawan, Long> {
    @Query(value = "select k from Karyawan k where k.id = :id")
    Karyawan getById(@Param("id") Long id);

    @Query(value = "select k from Karyawan k where k.nama like " + "%" + ":nama" + "%")
    Page<Karyawan> getKaryawanByNama(@Param("nama") String nama, Pageable pageable);

    @Query(value = "select k from Karyawan k")
    Page<Karyawan> getAllKaryawanList(Pageable pageable);

    @Query(value = "select k from Karyawan k where k.nama = :nama")
    Karyawan findBynama(String nama);


}
