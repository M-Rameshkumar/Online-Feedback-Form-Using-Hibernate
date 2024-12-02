package com.goole.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="google")
public class FeedbackBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_Id")
	private int Eid;
	@Column(name="Employee_name")
	private String name;
	@Column(unique = true ,name = "Email")
	private String username;
	private String password;
	
	public FeedbackBean(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	

	public FeedbackBean(String name,String password,String username) {
		super();
		this.name = name;
		this.password = password;
		this.username = username;
	}


	public FeedbackBean(int Eid, String name, String username, String password) {
		super();
		this.Eid = Eid;
		this.name = name;
		this.username = username;
		this.password = password;
	}


	public FeedbackBean() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
