package com.avanish.schoolmangement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avanish.schoolmangement.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
}
