package com.avanish.schoolmangement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Associate")
public class AssociateProfessor extends Teacher {
	
	 private String specialization;

	public AssociateProfessor() {
		super();
		
	}


	public AssociateProfessor(int id, String name, int age, String address, String qualification, String experience,String specialization) {
		super(id, name, age, address, qualification, experience);
		this.specialization=specialization;
	}


	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	 
	
	 
}
