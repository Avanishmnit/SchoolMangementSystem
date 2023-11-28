package com.avanish.schoolmangement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avanish.schoolmangement.entities.Teacher;
import com.avanish.schoolmangement.repositories.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	//Finding All Teacher
		 public List<Teacher> getAllTeachers(){
			 List<Teacher>list= teacherRepository.findAll();
			 return list;
		 }
		 
		 // GetTeacherByID
		 public Optional<Teacher> getTeacherById(int id) {
				Optional<Teacher> Teacher= null;
				
				try {
					
				 Teacher=	teacherRepository.findById(id);
				
				} catch(Exception e){
					e.printStackTrace();
				}
				return Teacher;
			}
			
		 
		 //Add Teacher
		 
		 public Teacher addTeacher(Teacher Teacher) {
				
				Teacher result=teacherRepository.save(Teacher);
				return result;
			}
		 
		 //DeleteTeacher
		 
		 public void deleteTeacher(int id) {		
				teacherRepository.deleteById(id);
			}
		 
		 //updateTeacher
		 public void updateTeacher(Teacher teacher ,int id) {
				teacher.setId(id);
				teacherRepository.save(teacher);
			}
}
