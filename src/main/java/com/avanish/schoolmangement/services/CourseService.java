package com.avanish.schoolmangement.services;

import com.avanish.schoolmangement.entities.*;
import com.avanish.schoolmangement.repositories.CourseRepository;
import com.avanish.schoolmangement.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	private TeacherRepository teacherRepository;
	
	//Finding All course
		 public List<Course> getAllCourses(){
			 List<Course>list= courseRepository.findAll();
			 return list;
		 }
		 
		 // GetcourseByID
		 public Optional<Course> getCourseById(String id) {
				Optional<Course> course= null;
				
				try {
					
				 course=	courseRepository.findById(id);
				
				} catch(Exception e){
					e.printStackTrace();
				}
				return course;
			}
			
		 
		 //Add course
		 
		 public Course addCourse(Course course) {
				
				Course result=courseRepository.save(course);
				return result;
			}
		 
		 //Delete course
		 
		 public void deleteCourse(String id) {		
				courseRepository.deleteById(id);
			}
		 
		 //update Course
		 public void updateCourse(Course course ,String id) {
				course.setCourseCode(id);
				courseRepository.save(course);
			}
		 
		 //Assigning teacher
		 
		 public void assignTeacherToCourse(String courseCode, int teacherId) {
		        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
		        Course course = courseRepository.findById(courseCode).orElse(null);

		        if (teacher == null || course == null) {
		            System.out.println("Invalidd Teacher ID or Course Code.");
		        } else if (teacher instanceof Professor && course.getType().equals("Advanced")) {
		            course.setAssignedTeacher(teacher);
		            courseRepository.save(course);
		            System.out.println("Teacher assigned to the course successfully.");
		        } else if ((teacher instanceof AssistantProfessor || teacher instanceof AssociateProfessor) && course.getType().equals("Introductory")) {
		            course.setAssignedTeacher(teacher);
		            courseRepository.save(course);
		            System.out.println("Teacher assigned to the course successfully.");
		        } else {
		            System.out.println("Teacher is not qualified to teach this course.");
		        }
		    }
		  
}
