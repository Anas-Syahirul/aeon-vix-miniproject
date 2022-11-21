package com.example.aeon.repository;

import com.example.aeon.model.KaryawanTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanTrainingRepo extends JpaRepository<KaryawanTraining, Long> {
}
