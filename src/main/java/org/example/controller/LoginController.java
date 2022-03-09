package org.example.controller;

import org.example.Model.Login.ILogin;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class LoginController {

	@Inject
	private ILogin log;

	@GET
	@Path("/ping")
	public String ping() {
		return "Ping";
	}

	@GET
	@Path("{login:.*}/{password:.*}")
	@Produces("application/json")
	public Response doGet(@PathParam("login") String login, @PathParam("password") String password, @HeaderParam("Token") String UserToken) {
		try {
			System.out.println("Test111");

			return log.LoginFunc(login, password);
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
		}
	}
}