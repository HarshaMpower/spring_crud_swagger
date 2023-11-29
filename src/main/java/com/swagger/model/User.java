package com.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User {

	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String role;

	@Column
	private String email;

	public User(int id, String name, String role, String email) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role='" + role + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
