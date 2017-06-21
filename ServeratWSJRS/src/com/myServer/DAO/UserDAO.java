package com.myServer.DAO;

import java.util.List;

import com.myServer.entities.User;

public interface UserDAO {
	
	public void initFactory();
	
	public void closeFactory();
	
	public boolean add(User u);
	
	public boolean update(User u);
	
	public User findByUsername(String userName);
	
	public User findByEmail(String email);
	
	public List<User> findAll();
	
	public User findByID(int id);
	
	public User findForAuthen (String userName, String password);
	
	public boolean delete(User u);

	
}
