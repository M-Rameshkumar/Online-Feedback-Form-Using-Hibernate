package com.goole.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="feedback")
public class feedback {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String message;
	@Column(unique=true,nullable = false)
	private String email;
	
	
	
	
	public feedback() {
		super();
	}
	public feedback(String name, String message, String email) {
		super();
		this.name = name;
		this.message = message;
		this.email = email;
	}
	public feedback(int id, String name, String message, String email) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
