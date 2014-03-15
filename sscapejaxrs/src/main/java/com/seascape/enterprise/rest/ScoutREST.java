package com.seascape.enterprise.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.seascape.enterprise.dao.UserAccountDao;
import com.seascape.enterprise.data.queries.UserAccountQuery;
import com.seascape.enterprise.entity.UserAccount;
import com.seascape.enterprise.secure.service.Authenticator;
import com.seascape.enterprise.secure.service.DataConnector;
 
@Path("/scoutxy-rest")
public class ScoutREST {
	
	private final String jdbcUrl = "jdbc:mysql://localhost:3306/ffarm_dev?user=root&password=admin";
	
	@GET
	@Path("/getUsers")
	@Produces("application/json")
	public List<UserAccount> listUsers(@QueryParam("accessCode") String accessCode,
			@QueryParam("accessKey") String accessKey) {
	
		List<UserAccount>list = new ArrayList<UserAccount>();
		if (Authenticator.authenticateAccess(accessCode, accessKey)) {
				Connection conn=DataConnector.getConnection();
				UserAccountDao q = new UserAccountQuery();
				list=q.findAll(conn);				
				DataConnector.closeConnection(conn);
		}		
		return list;
	}
	
	@GET
	@Path("/findUser")
	@Produces("application/json")
	public UserAccount findUser(@QueryParam("accessCode") String accessCode,
			@QueryParam("accessKey") String accessKey,
			@QueryParam("key") String key) {
	
		UserAccount user = new UserAccount();
		if (Authenticator.authenticateAccess(accessCode, accessKey)) {
				Connection conn=DataConnector.getConnection();
				UserAccountDao q = new UserAccountQuery();
				user=q.findById(new Long(key), conn);
				DataConnector.closeConnection(conn);
		}		
		return user;
	}
	
	@GET
	@Path("/createAccount")
	@Produces(MediaType.TEXT_HTML)
	public Response createAccount(@QueryParam("accessCode") String accessCode,
			@QueryParam("accessKey") String accessKey,
			@QueryParam("username") String username,
			@QueryParam("password") String password,
			@QueryParam("emailAddress") String emailAddress,
			@QueryParam("dob") String dob,
			@QueryParam("gender") String gender,
			@QueryParam("location") String location,
			@QueryParam("phone") String phone) {
	
		UserAccount user = new UserAccount(null, username,password, emailAddress,dob,gender,phone,location,"Yes",null,null);
		Long key=null;
		if (Authenticator.authenticateAccess(accessCode, accessKey)) {
				Connection conn=DataConnector.getConnection();
				UserAccountDao q = new UserAccountQuery();
				key=q.createAccountUser(user, conn);			
				DataConnector.closeConnection(conn);
		}		
		return Response.status(200).entity(key+"").build();
	}
 
}
