package com.avanish.schoolmangement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanish.schoolmangement.entities.UnderGraduateStudent;

public interface UnderGraduateRepository extends JpaRepository<UnderGraduateStudent, Integer> {

}
