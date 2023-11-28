package com.avanish.schoolmangement.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="teachers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="designation",discriminatorType = DiscriminatorType.STRING)
public class Teacher {
	
	@Id
	@GeneratedValue
	private int Id;
	
	protected String name;
    private  int age;

    private  String address;

	private String qualification;
	private String experience;
	
	
	@OneToMany(mappedBy = "assignedTeacher")
	private List<Course> courses= new ArrayList<>();
	
	public Teacher() {
		super();
	}
	
	public Teacher(int id, String name, int age, String address, String qualification, String experience
			) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.qualification = qualification;
		this.experience = experience;
		
	}





	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}


	
	
}
