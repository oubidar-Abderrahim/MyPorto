package com.myServer.Services;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.myServer.DAO.UserDAO;
import com.myServer.DAO.HibernateImp.UserDAOHibernateImp;
import com.myServer.entities.User;



@Path("/test")
public class TestServ {
	
	
	@GET
	@Path("/plz")
	@Produces(MediaType.TEXT_HTML)
	public String forTest() {
		
		
		return "<html><head><title>test</title></head><body><h1>TEST</h1></body></html>" ;
	}
	
	
	@GET
	@Path("/hibernate")
	@Produces(MediaType.APPLICATION_JSON)
	public String gimme() {
		
		UserDAO userDao = new UserDAOHibernateImp();
		
		StringBuilder sb = new StringBuilder("");
		
		sb.append("<html><head><title>test</title></head><body><p>");
		
		List<User> listUsers = userDao.findAll();
		
		if( listUsers != null ) {
			
			for ( User u : listUsers ){
				
				sb.append(u.toString());
			}
		} else {
			sb.append("Could not retreive Users from Database");
		}
		
		sb.append("</p></body></html>");
		
		return sb.toString() ;
	}
	
}
