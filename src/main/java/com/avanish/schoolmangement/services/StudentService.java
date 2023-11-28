package com.avanish.schoolmangement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanish.schoolmangement.entities.Student;
import com.avanish.schoolmangement.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	//Finding All Student
	 public List<Student> getAllStudents(){
		 List<Student>list= studentRepository.findAll();
		 return list;
	 }
	 
	 // GetStudentByID
	 public Optional<Student> getStudentById(int id) {
			Optional<Student> student= null;
			
			try {
				
			 student=	studentRepository.findById(id);
			
			} catch(Exception e){
				e.printStackTrace();
			}
			return student;
		}
		
	 
	 //Add Student
	 
	 public Student addStudent(Student student) {
			
			Student result=studentRepository.save(student);
			return result;
		}
	 //DeleteStudent
	 
	 public void deleteStudent(int id) {		
			studentRepository.deleteById(id);
		}
	 
	 //updateStudent
	 public void updateStudent(Student student ,int id) {
			student.setId(id);
			studentRepository.save(student);
		}
	
}
