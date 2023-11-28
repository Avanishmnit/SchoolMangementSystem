package com.avanish.schoolmangement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pg")
public class PostGraduateStudent extends Student {
	
	 private String major;

	public PostGraduateStudent() {
		super();
		
	}

	

	public PostGraduateStudent(int id, String name, int age, String address,String major ) {
		super(id, name, age, address);
		this.major=major;
	}



	public String getmajor() {
		return major;
	}

	public void setmajor(String major) {
		this.major = major;
	}



	@Override
	public String getStudentType() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void setStudentType(String studentType) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
}
