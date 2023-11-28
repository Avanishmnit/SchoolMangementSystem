package com.avanish.schoolmangement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avanish.schoolmangement.services.EnrollmentService;

@RestController
public class EnrollController {
	
	@Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enrollStudentInCourse(
            @RequestParam int studentId,
            @RequestParam String courseId
    ) {
        if (enrollmentService.enrollStudent(studentId, courseId)) {
            return "Student with ID " + studentId + " enrolled in course with ID " + courseId + " successfully.";
        } else {
            return "Failed to enroll student in the course.";
        }
    }
}
