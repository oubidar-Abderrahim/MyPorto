package com.myServer.Business;

import java.util.ArrayList;
import java.util.List;

import com.myServer.DAO.UserDAO;
import com.myServer.DAO.HibernateImp.UserDAOHibernateImp;
import com.myServer.entities.Message;
import com.myServer.entities.User;

public class UserBusiness {
	
	private UserDAO userDao ;

	
	public UserBusiness() {
		super();
		this.userDao = new UserDAOHibernateImp();
		
	}

	public List<User> seeAllUsers() {

		return userDao.findAll();
	}
	

	public User getThisUser(String userName) {

		return userDao.findByUsername(userName);
	}
	
	public Message signUp(User user) {
		
		User tempUser = null ;
		boolean hasError = false ;
		List<String> errorMsgs = new ArrayList<>();
		
		tempUser = userDao.findByUsername(user.getUserName());
		
		if( tempUser != null ) {
			
			errorMsgs.add("the user name : " + user.getUserName() + " already exist");
			hasError = true;
			tempUser = null ;
		}
		
		tempUser = userDao.findByEmail(user.getEmail());
		
		if( tempUser != null ) {
			
			errorMsgs.add("your email is already registered");
			hasError = true;
			tempUser = null ;
		}
		
		if( !hasError ){
			
			hasError = !(userDao.add(user));
			
			if( hasError )
				errorMsgs.add("Somthing went wrong with our database");
		}
		
		return new Message(hasError,errorMsgs.toArray(new String[0]));
		
	}
	
public Message logIn(String userName, String password) {
		
		User tempUser = null ;
		boolean hasError = false ;
		List<String> errorMsgs = new ArrayList<>();
		
		tempUser = userDao.findForAuthen(userName, password);
		
		if( tempUser == null ) {
			
			errorMsgs.add("Invalid UserName or Password");
			hasError = true;
		}
		
		return new Message(hasError,errorMsgs.toArray(new String[0]));
		
	}
}
