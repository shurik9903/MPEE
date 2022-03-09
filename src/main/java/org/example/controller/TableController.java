package org.example.controller;

import org.example.Model.Table.ITable;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.example.Model.Token.ITokenKey;
import org.example.Model.Token.ITokenValidator;
import org.example.Model.Token.TokenKey;
import org.example.Model.Token.TokenValidator;

import java.util.HashMap;

@Path("/table")
public class TableController{

	@Inject
	private ITable tab;

    @GET
    @Path("{UserID:.*}")
	@Produces("application/json")
	public Response doGet(@PathParam("UserID") String UserID, @HeaderParam("Token") String UserToken) {
		try {
			try {
				ITokenKey tokenKey = new TokenKey();
				ITokenValidator tokenValidator = new TokenValidator(tokenKey.getKey());
				tokenValidator.validate(UserToken);
			}catch (Exception e){
				return Response.status(Response.Status.FORBIDDEN).entity("|Error: " + e.getMessage()).build();
			}

			return tab.GetDBData(UserID);
		}catch (Exception e) {
			System.out.println("MYError" + e);
            return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
		}
	}

    @POST
    @Consumes("application/json")
    @Produces("application/json")
	public Response doPost(String TableData, @HeaderParam("Token") String UserToken) {
		try {
			try {
				ITokenKey tokenKey = new TokenKey();
				ITokenValidator tokenValidator = new TokenValidator(tokenKey.getKey());
				tokenValidator.validate(UserToken);
			}catch (Exception e){
				return Response.status(Response.Status.FORBIDDEN).entity("|Error: " + e.getMessage()).build();
			}
			return tab.SetData(TableData);
		} catch (Exception e) {
			System.out.println("MYError: " + e);
			return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
		}
	}



}