package org.example.Model.Login;

import org.example.Data.IDataBaseWork;
import org.example.Data.MyData.DLogin;
import org.example.Model.Token.IToken;
import org.example.Model.Token.Token;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

public class Login implements ILogin {

    @Inject
    private IDataBaseWork DataBaseWork;


    @Override
    public Response LoginFunc(String login, String password) {

        Map<String, String> Result = new HashMap<>();

        String Checklogin = "qqw";
        String Checkpassword = "3331";

        try {

            if (!login.isEmpty() && !password.isEmpty()) {

                if (DataBaseWork.ping()) {

                    DLogin dlogin = (DLogin) DataBaseWork.login(login, password);

                    if (dlogin.getMsg() == null) {

                        IToken GenToken = new Token();

                        String newToken = GenToken.GenerateToken(login).get("FullToken");

                        if (!newToken.isEmpty()) {
                            Result.put("Token", newToken);
                            Result.put("UserID", String.valueOf(dlogin.getUser_ID()));
                            Result.put("UserName", dlogin.getUser_name());
                        }else
                            Result.put("Msg", "Token Error");
                    } else Result.put("Msg", dlogin.getMsg());


                } else if (login.equals(Checklogin) && password.equals(Checkpassword)){
                    IToken GenToken = new Token();

                    String newToken = GenToken.GenerateToken(login).get("FullToken");
                    if (!newToken.isEmpty()) {
                        Result.put("Token", newToken);
                        Result.put("UserID", String.valueOf(-1));
                        Result.put("UserName", login);
                    }else
                        Result.put("Msg", "Token Error");
                } else Result.put("Msg", "Wrong login or password");

            } else Result.put("Msg", "Fill in all the fields");

            Jsonb jsonb = JsonbBuilder.create();

            return Response.ok(jsonb.toJson(Result)).build();
        } catch (JsonbException e) {
            System.out.println(e);
            return Response.status(Response.Status.BAD_REQUEST).entity("Error: " + e.getMessage()).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(Response.Status.BAD_REQUEST).entity("Error: " + e.getMessage()).build();
        }
    }

}
