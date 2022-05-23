package com.user.model;

import java.util.Date;

public class UserDTO { 
	private String id;
	private String pwd;
	private String name;
	private int age;
	private String phone;
	private String email;
	private Date register;
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	
	

	
	
}
