package com.avanish.schoolmangement.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
		
		@Id
		@Column(name="c_code")
		private String courseCode;
	    private  String courseName;
	    private int maxCapacity;

	    private  String type;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinTable(
	    		name = "assignedTeacher",
	    				 joinColumns = @JoinColumn(name = "course_id"),
	    		            inverseJoinColumns = @JoinColumn(name = "teachert_id")
	    		)
	    private  Teacher assignedTeacher;
	    
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "enrollment",
	            joinColumns = @JoinColumn(name = "course_id"),
	            inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    
	    private List<Student> enrolledStudents = new ArrayList<>();
	    
	    
		public Course() {
			super();
		}

		public Course(String courseCode, String courseName, int maxCapacity, String type, Teacher assignedTeacher
				) {
			super();
			this.courseCode = courseCode;
			this.courseName = courseName;
			this.maxCapacity = maxCapacity;
			this.type = type;
			this.assignedTeacher = assignedTeacher;
		}

		public String getCourseCode() {
			return courseCode;
		}

		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public int getMaxCapacity() {
			return maxCapacity;
		}

		public void setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Teacher getAssignedTeacher() {
			return assignedTeacher;
		}

		public void setAssignedTeacher(Teacher assignedTeacher) {
			this.assignedTeacher = assignedTeacher;
		}

		public List<Student> getEnrolledStudents() {
			return enrolledStudents;
		}

		public void setEnrolledStudents(List<Student> enrolledStudents) {
			this.enrolledStudents = enrolledStudents;
		}
		
		
	    
	    
	    
}
