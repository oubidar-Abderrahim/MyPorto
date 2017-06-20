package com.myServer.DAO.JDBCImp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myServer.DAO.UserDAO;
import com.myServer.entities.User;

import java.sql.Connection;


public class UserDAOImp implements UserDAO {
	
	private final String jdbcUri = "jdbc:mysql://localhost:3306/gestionvol";
	private final String jdbcUser = "user" ;
	private final String jdbcPass = "yassine" ;
	
	private Connection mysqlConnection = null ;
	
	
	
	public Connection openConnection() throws ClassNotFoundException, SQLException {
		
		
		return  DriverManager.getConnection(jdbcUri, jdbcUser, jdbcPass);

		
	}
	
	public UserDAOImp() {
		super();
		System.out.println("Hi I' starting :D ");
	}

	public void closeConnection() throws SQLException {
		if( mysqlConnection != null ) {
			mysqlConnection.close();
		}
	}

	@Override
	public boolean add(User u) {
		
		boolean status = false ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "INSERT INTO appuser (first_name, last_name, user_name, "
					+ "email, pass) VALUES ( ?, ?, ?, ?, ? );";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setString(1, u.getFirstName());
			pst.setString(2, u.getLastName());
			pst.setString(3, u.getUserName());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			
			int rs = pst.executeUpdate();
			
			if (rs > 0)
	        {
	            status =  true;
	        }	
			
			pst.close();
			closeConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		} 
		return status;
	}

	@Override
	public boolean update(User u) {
		boolean status = false ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "UPDATE appuser SET first_name = ? , last_name = ?, "
					+ "user_name = ?, email = ?, pass = ? WHERE id = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setString(1, u.getFirstName());
			pst.setString(2, u.getLastName());
			pst.setString(3, u.getUserName());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getPassword());
			pst.setInt(6, u.getId());
			
			int rs = pst.executeUpdate();
			
			if (rs > 0)
	        {
	            status =  true;
	        }	
			
			pst.close();
			closeConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		} 
		return status;
	}
	

	@Override
	public User findByUsername(String userName) {

		User aUser = null ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "SELECT * FROM appuser WHERE user_name = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setString(1, userName);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
	        {
	            aUser = new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
	        }	
			
			pst.close();
			closeConnection();
			
			return aUser;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return aUser;
	}

	@Override
	public User findByEmail(String email) {
		
		User aUser = null ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "SELECT * FROM appuser WHERE email = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setString(1, email);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
	        {
	            aUser = new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
	        }	
			
			pst.close();
			closeConnection();
			
			return aUser;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return aUser;
	}

	@Override
	public User findByID(int id) {

		User aUser = null ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "SELECT * FROM appuser WHERE id = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
	        {
	            aUser = new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
	        }	
			
			pst.close();
			closeConnection();
			
			return aUser;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return aUser;
	}

	@Override
	public User findForAuthen(String userName, String password) {

		User aUser = null ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "SELECT * FROM appuser WHERE user_name = ? AND pass = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setString(1, userName);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
	        {
	            aUser = new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
	        }	
			
			pst.close();
			closeConnection();
			
			return aUser;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return aUser;
	}

	@Override
	public boolean delete(User u) {

		boolean status = false ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "DELETE FROM appuser WHERE id = ? ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			pst.setInt(1, u.getId());
			
			int rs = pst.executeUpdate();
			
			if (rs > 0)
	        {
	            status =  true;
	        }	
			
			pst.close();
			closeConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
			return status;
		} 
		return status;
	}

	@Override
	public List<User> findAll() {

		List<User> userList = null ;
		
		try {
			mysqlConnection = openConnection();
			
			String req = "SELECT * FROM appuser ;";
			
			PreparedStatement pst = mysqlConnection.prepareStatement(req);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
	        {
				if( userList == null)
					userList = new ArrayList<>();
				
				User tempUser = new User(rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6));
				
				userList.add(tempUser);
				
	        }	
			
			pst.close();
			closeConnection();
			
			return userList;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
		return userList;
		
	}

}
