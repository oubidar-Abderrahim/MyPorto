package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import com.model.User;

@ManagedBean(name="user", eager=true)
@SessionScoped
public class TableBean {
	
	private User selectedUser = new User();
	private int editedId;
	private User userToAdd = new User();
	private List<User> userList = new ArrayList<User>(
			Arrays.asList( 
					new User(1, "zayzay@hotmail.com", "4qsd455sj"),
					new User(2, "fay�al@gmail.com", "452141Hello"),
					new User(3, "aziz@hotmail.com", "ssqdqsd"),
					new User(4, "hitowangying@gmail.com", "447474"),
					new User(5, "HitoWang@gmail.com", "78qsdqshd")
					)
			); 

	public void isUserListEmpty(ComponentSystemEvent event) {
		 
		
		if (userList.size() == 0){
			
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			    try {
					ec.redirect(ec.getRequestContextPath() + "/error.jsf");
				} catch (IOException e) {
				
					e.printStackTrace();
				}
		}		
	  }
	
	public void selectUserListener(ValueChangeEvent e){
		
		int selectedId = Integer.parseInt(e.getNewValue().toString());
		for(User user : userList){
			if(user.getId() == selectedId){
				selectedUser = user;
				break;
			}
		}
		
	}
	
	public String add(){
		userToAdd.setId(userList.get(userList.size() - 1).getId() + 1);
		userList.add(userToAdd);
		userToAdd = new User();
		return null;
	}
	public String save(int id){
		editedId = -1;
		return null;
	}
	public String edit(int id){
		editedId = id;
		return null;
	}
	public String delete(int id){
		for(User user : userList){
			if(user.getId() == id){
				userList.remove(user);
				break;
			}
		}
		return null;
	}
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public int getEditedId() {
		return editedId;
	}
	public void setEditedId(int editedId) {
		this.editedId = editedId;
	}
	public User getUserToAdd() {
		return userToAdd;
	}
	public void setUserToAdd(User userToAdd) {
		this.userToAdd = userToAdd;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

}
