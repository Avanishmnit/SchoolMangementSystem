package com.avanish.schoolmangement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avanish.schoolmangement.entities.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
	
	
}
