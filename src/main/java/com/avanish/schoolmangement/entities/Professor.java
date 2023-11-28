package com.avanish.schoolmangement.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends Teacher{
	 private String achievement;

	public Professor() {
		super();
		
	}

	public Professor(int id, String name, int age, String address, String qualification, String experience , String achievement) {
		super(id, name, age, address, qualification, experience);
		this.achievement=achievement;
	}




	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	 	 
	
}
