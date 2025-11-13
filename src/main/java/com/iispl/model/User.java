package com.iispl.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String mobNo;
	private String password;
	private String role;
	
	public User(int id, String name, String mobNo, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email.trim();
		this.mobNo = mobNo;
		this.password = password.trim();
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobNo=" + mobNo + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
