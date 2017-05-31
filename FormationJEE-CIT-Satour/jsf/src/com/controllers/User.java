package com.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userSample",eager=true)
@SessionScoped
public class User{

	private String name = "Hello";
	private String email;
	private int count = 0;
	private boolean edit;
	
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
	
	public String countVisits(){
		setCount(getCount() + 1);
		return null;
	}
	public  int getCount() {
		return count;
	}
	public  void setCount(int count) {
		this.count = count;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean isEdit) {
		this.edit = isEdit;
	}
	
	public void setEditMode(){
		edit = false;
	}
	
	public void setSaveMode(){
		edit = true;
	}
}
