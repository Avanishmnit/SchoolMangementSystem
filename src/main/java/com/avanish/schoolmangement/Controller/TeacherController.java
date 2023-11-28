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

import com.avanish.schoolmangement.entities.AssistantProfessor;
import com.avanish.schoolmangement.entities.AssociateProfessor;
import com.avanish.schoolmangement.entities.Professor;
import com.avanish.schoolmangement.entities.Teacher;
import com.avanish.schoolmangement.services.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/teachers")
	public ResponseEntity<List<Teacher>>getTeachers() {
		
		List<Teacher>list= teacherService.getAllTeachers();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	
	@GetMapping("/teachers/{id}")
	public ResponseEntity<Optional<Teacher>> getTeachers(@PathVariable int id) {
		
		Optional<Teacher> teacher= teacherService.getTeacherById(id);
		
		if(teacher==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(teacher));
		
	}
	
	@PostMapping("/teachers")
	public ResponseEntity<Teacher>addTeacher(@RequestBody Teacher Teacher) {
		Teacher b= null;
		try {
			b =teacherService.addTeacher(Teacher);
			
		} catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
		
	}
	
	//Add Assistant Prof
	
	@PostMapping("/assistant")
	public ResponseEntity<Teacher>addTeacher(@RequestBody AssistantProfessor teacher) {
		Teacher b= null;
		try {
			b =teacherService.addTeacher(teacher);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
	}
	
	//Add Associate Prof
	
	@PostMapping("/associate")
	public ResponseEntity<Teacher>addTeacher(@RequestBody AssociateProfessor teacher) {
		Teacher b= null;
		try {
			b =teacherService.addTeacher(teacher);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
	
	//Add  Prof
		
		@PostMapping("/prof")
		public ResponseEntity<Teacher>addTeacher(@RequestBody Professor teacher) {
			Teacher b= null;
			try {
				b =teacherService.addTeacher(teacher);
				return ResponseEntity.status(HttpStatus.CREATED).body(b);
				
			} catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}
		
			// Delete Teacher
	
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
		
		try {
		teacherService.deleteTeacher(id);
		return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return null;
	}
	
	@PutMapping("/teachers/{id}")
	public  ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher ,@PathVariable int id) {
		try {
		teacherService.updateTeacher( teacher ,id);
		}
		catch(Exception e) {
			e.printStackTrace();
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return ResponseEntity.of(Optional.of(teacher));
		
	} 

}
