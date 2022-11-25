package com.example.aeon.repository;

import com.example.aeon.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingRepo extends JpaRepository<Training, Long> {
    @Query(value = "select t from Training t where t.id = :id")
    Training getById(@Param("id") Long id);

    @Query(value = "select t from Training t where t.namaPengajar like " + "%" + ":namaPengajar" + "%")
    Page<Training> getTransaksiByNamaPengajar(@Param("namaPengajar") String namaPengajar, Pageable pageable);

    @Query(value = "select t from Training t")
    Page<Training> getAllTrainingList(Pageable pageable);
}
