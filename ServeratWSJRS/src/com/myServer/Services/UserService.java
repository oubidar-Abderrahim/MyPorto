package com.myServer.Services;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PostParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.myServer.Business.UserBusiness;
import com.myServer.entities.Message;
import com.myServer.entities.User;


@Path("/users")
public class UserService {
	
	private UserBusiness userBusiness ;

	public UserService() {
		
		super();
		userBusiness = new UserBusiness();
		
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
	public List<User> seeAllUsers(){
		
		return userBusiness.seeAllUsers();
	}
	
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
	public User getThisUser( @PathParam (value="userName")String userName ){
		
		return userBusiness.getThisUser(userName);
	}
	
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON+"; charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
	public Message signUp(User newUser){
		
		return userBusiness.signUp(newUser);
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) // A String constant representing ""application/x-www-form-urlencoded"" media type.
	@Produces(MediaType.APPLICATION_JSON+"; charset=utf-8")
	public Message logIn(@PostParam (value="userName")String userName, @PostParam (value="password")String password){
		
		return userBusiness.logIn(userName, password);
	}	

}
