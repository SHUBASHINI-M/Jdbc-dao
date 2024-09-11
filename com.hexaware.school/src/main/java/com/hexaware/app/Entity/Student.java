package com.hexaware.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
	
	@Id
	int Roll;
	
	@NotEmpty
	String name;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Double fee;
	
	@Min(value=18,message="Age cannot be less than 18")
	@Max(value=60,message="Age cannot be greater than 60")
	int age;
	
	@Email
	String email;
	
	
	@Size(min = 4, max = 50)
	String Address;
	
	@Pattern(regexp = "^\\d+(\\.\\d{1,2})?$")
	String salary;
	


	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	Student()
	{
		
	}

	public Student(int roll, String name, Double fee) {
		super();
		Roll = roll;
		name = name;
		this.fee = fee;
	}

	public int getRoll() {
		return Roll;
	}

	public void setRoll(int roll) {
		Roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + name + ", fee=" + fee + "]";
	}
	

}
