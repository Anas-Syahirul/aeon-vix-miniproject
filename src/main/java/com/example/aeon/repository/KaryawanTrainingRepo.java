package com.example.aeon.repository;

import com.example.aeon.model.Karyawan;
import com.example.aeon.model.KaryawanTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepo extends JpaRepository<KaryawanTraining, Long> {

    @Query(value = "select kt from KaryawanTraining kt where kt.karyawan.nama like :namaKaryawan" + "%" +
            " and kt.training.namaPengajar like " + "%" + ":namaPengajar" + "%")
    Page<KaryawanTraining> getByKaryawanNamaAndTrainingPengajar(@Param("namaKaryawan") String namaKaryawan,
                                                                @Param("namaPengajar") String namaPengajar,
                                                                Pageable pageable);
    @Query(value = "select kt from KaryawanTraining kt where kt.karyawan.nama like " + "%" + ":namaKaryawan" + "%")
    Page<KaryawanTraining> getByKaryawanNama(@Param("namaKaryawan") String namaKaryawan, Pageable pageable);

    @Query(value = "select kt from KaryawanTraining kt where kt.training.namaPengajar like " + "%" + ":namaPengajar" + "%")
    Page<KaryawanTraining> getByTrainingNamaPengajar(@Param("namaPengajar") String namaPengajar, Pageable pageable);

    @Query(value = "select kt from KaryawanTraining kt")
    Page<KaryawanTraining> getAllKaryawanTraining(Pageable pageable);
}
