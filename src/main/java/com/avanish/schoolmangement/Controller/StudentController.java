package com.avanish.schoolmangement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avanish.schoolmangement.entities.PostGraduateStudent;
import com.avanish.schoolmangement.entities.Student;
import com.avanish.schoolmangement.entities.UnderGraduateStudent;
import com.avanish.schoolmangement.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	@GetMapping("/students")
	public ResponseEntity<List<Student>>getstudents() {
		
		List<Student>list= studentService.getAllStudents();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Optional<Student>> getstudents(@PathVariable int id) {
		
		Optional<Student> student= studentService.getStudentById(id);
		
		if(student==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(student));
		
	}
	
	/*
	 * @PostMapping("/students") public
	 * ResponseEntity<Student>addstudent(@RequestBody Student student) { Student b=
	 * null; try { b =studentService.addStudent(student);
	 * 
	 * } catch(Exception e) { e.printStackTrace();
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(b);
	 * 
	 * }
	 */
	
	//Add Ug Student
	
	@PostMapping("/saveUndergraduate")
    public String saveUndergraduateStudent(@RequestBody UnderGraduateStudent undergraduateStudent) {
        studentService.addStudent(undergraduateStudent);
        return "Undergraduate student saved successfully.";
    }
	
	// Adding Pg Student
	
	@PostMapping("/savePostgraduate")
    public String savePostgraduateStudent(@RequestBody PostGraduateStudent postgraduateStudent) {
        studentService.addStudent(postgraduateStudent);
        return "PostGraduate student saved successfully.";
    }
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deletestudent(@PathVariable int id) {
		
		try {
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
	}
	
	@PutMapping("/students/{id}")
	public  ResponseEntity<Student> updatestudent(@RequestBody Student student ,@PathVariable int id) {
		try {
		studentService.updateStudent( student ,id);
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.of(Optional.of(student));
		
	} 
}
