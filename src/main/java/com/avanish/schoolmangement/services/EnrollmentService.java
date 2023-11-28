package com.avanish.schoolmangement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanish.schoolmangement.entities.Course;
import com.avanish.schoolmangement.entities.Student;
import com.avanish.schoolmangement.repositories.CourseRepository;
import com.avanish.schoolmangement.repositories.StudentRepository;

@Service
public class EnrollmentService {
	
	@Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    
    public boolean enrollStudent(int studentId, String courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student != null && course != null && course.getEnrolledStudents().size() < course.getMaxCapacity()) {
            course.getEnrolledStudents().add(student);
            courseRepository.save(course);
            return true;
        }

        return false;
    }
}
