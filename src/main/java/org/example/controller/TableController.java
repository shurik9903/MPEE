package org.example.controller;

import org.example.Model.Table.ITable;
import org.example.Model.Token.IToken;
import org.example.Model.Token.Token;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

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
			IToken token = new Token();
			if (!token.CheckToken(UserToken))
				return token.CreateResponse(new HashMap<>() {{
					put("Msg", "Token Error");
				}});

			return tab.GetDBData(UserID);
		}catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
		}
	}

    @POST
    @Consumes("application/json")
    @Produces("application/json")
	public Response doPost(String TableData, @HeaderParam("Token") String UserToken) {
		try {
			IToken token = new Token();
			if (!token.CheckToken(UserToken))
				return token.CreateResponse(new HashMap<>() {{
					put("Msg", "Token Error");
				}});

			return tab.SetData(TableData);
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("|Error: " + e.getMessage()).build();
		}
	}



}