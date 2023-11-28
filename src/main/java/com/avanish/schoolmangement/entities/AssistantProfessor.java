package com.avanish.schoolmangement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Assistant")
public class AssistantProfessor extends Teacher {
	
	private String researchArea;

	public AssistantProfessor() {
		super();
		
	}

	public AssistantProfessor(int id, String name, int age, String address, String qualification, String experience, String researchArea) {
		super(id, name, age, address, qualification, experience);
		this.researchArea=researchArea;
		
	}

	public String getResearchArea() {
		return researchArea;
	}

	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}
	
	
}
