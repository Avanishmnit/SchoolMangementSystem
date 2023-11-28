package com.avanish.schoolmangement.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="student_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Student {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="s_id")
	 private int Id;
	 protected String name;
	 private  int age;
	 private String address;
	 

	 @ManyToMany(mappedBy = "enrolledStudents")
	 private List<Course> cources = new ArrayList<>();
	 
	 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, int age, String address) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.address = address;
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


	public List<Course> getCources() {
		return cources;
	}

	public void setCources(List<Course> cources) {
		this.cources = cources;
	}
	
	
	// Getter and Setter for discriminator value
    public abstract String getStudentType();

    public abstract void setStudentType(String studentType);
	 
}
