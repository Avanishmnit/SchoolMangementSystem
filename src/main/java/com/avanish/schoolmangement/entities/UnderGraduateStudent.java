package com.avanish.schoolmangement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Ug")
public class UnderGraduateStudent extends Student {
	
	private String program;

	public UnderGraduateStudent() {
		super();
		
	}

	public UnderGraduateStudent(int id, String name, int age, String address,String program) {
		super(id, name, age, address);
		this.program=program;
	}



	public String getprogram() {
		return program;
	}

	public void setprogram(String program) {
		this.program = program;
	}


	@Override
	public String getStudentType() {
		// TODO Auto-generated method stub
		return "UnderGraduate";
	}


	@Override
	public void setStudentType(String studentType) {
		// TODO Auto-generated method stub
		
	}
	
    
	
}
