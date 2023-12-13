package com.avanish.schoolmangement.Controller;

import com.avanish.schoolmangement.entities.Course;
import com.avanish.schoolmangement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
	//hi
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>>getCourses() {
		
		List<Course>list= courseService.getAllCourses();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Optional<Course>> getCourses(@PathVariable String id) {
		
		Optional<Course> Course= courseService.getCourseById(id);
		
		if(Course==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(Course));
		
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course>addCourse(@RequestBody Course Course) {
		Course b= null;
		try {
			b =courseService.addCourse(Course);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
		
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
		
		try {
		courseService.deleteCourse(id);
		return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
	}
	
	@PutMapping("/courses/{id}")
	public  ResponseEntity<Course> updateCourse(@RequestBody Course Course ,@PathVariable String id) {
		try {
		courseService.updateCourse( Course ,id);
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.of(Optional.of(Course));
		
	} 
	
	// Assign Teacher
	
	 @PostMapping("/assignTeacherToCourse")
	    public String assignTeacherToCourse(
	            @RequestParam String courseCode,
	            @RequestParam int teacherId
	    ) {
	        courseService.assignTeacherToCourse(courseCode, teacherId);

	        return "Assignment process completed. Check the console for details.";
	    }

}
