package org.example.Model.Token;

import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.core.Response;

import java.security.MessageDigest;
import java.util.*;
import java.util.stream.Collectors;

public class Token implements IToken{
/*
    private final String server_key = "qwerty";

    private HashMap<String,String> StrToMap(String StrMap){
        HashMap<String,String> Result;
        StrMap = StrMap.replaceAll("[{}]","");
        try {
            Result = (HashMap<String,String>) Arrays.stream(StrMap.split(","))
                    .map(entry -> entry.split("="))
                    .collect(Collectors.toMap(entry -> entry[0].replaceAll(" ",""), entry -> entry[1]));
            return Result;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public String HS(String data){
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            return null;
        }

        messageDigest.update(data.getBytes());

        return Base64.getEncoder().withoutPadding().encodeToString(messageDigest.digest());
    }

    @Override
    public HashMap<String,String> GenerateToken(String login) {

        HashMap<String,String> HEADER = new HashMap<>();
        HashMap<String,String> PAYLOAD = new HashMap<>();

        HEADER.put("alg", "SHA-256");

        PAYLOAD.put("name", login);

        int s = 1;
        int m = 1;
        int h = 1;
        PAYLOAD.put("time", String.valueOf(new Date().getTime() + (1000 * s * m * h)));

        String HEADER_hash = Base64.getEncoder().withoutPadding().encodeToString(HEADER.toString().getBytes());
        String PAYLOAD_hash = Base64.getEncoder().withoutPadding().encodeToString(PAYLOAD.toString().getBytes());

        String key_hash = Base64.getEncoder().withoutPadding().encodeToString(server_key.getBytes());

        String data = HEADER_hash + key_hash + PAYLOAD_hash;

        String token = HS(data);

        return new HashMap<>(){{
            put("HEADER_hash", HEADER_hash);
            put("PAYLOAD_hash", PAYLOAD_hash);
            put("Token", token);
            put("FullToken", HEADER_hash+'.'+PAYLOAD_hash+'.'+token);
        }};
    }

    @Override
    public boolean CheckToken(String Token) {
        try {
            ArrayList<String> parse_token = new ArrayList<>(Arrays.asList(Token.split("\\.")));
            if (parse_token.size() != 3)
                return false;

            String key_hash = Base64.getEncoder().withoutPadding().encodeToString(server_key.getBytes());
            String data = parse_token.get(0) + key_hash + parse_token.get(1);
            String new_token = HS(data);

            boolean token_equals = parse_token.get(2).equals(new_token);
            if (!token_equals)
                return false;

            HashMap<String,String> PAYLOAD;
            String PAYLOAD_str = new String(Base64.getUrlDecoder().decode(parse_token.get(1)));
            PAYLOAD = StrToMap(PAYLOAD_str);

            if (PAYLOAD == null)
                return false;

            if (new Date().getTime() > new Date(Long.parseLong(PAYLOAD.get("time"))).getTime())
                return false;

            return true;
        }catch (Exception e) {
            System.out.println("Error token: " + e);
            return false;
        }
    }

    @Override
    public Response CreateResponse(HashMap<String, String> data){
        return Response.status(Response.Status.FORBIDDEN).entity(JsonbBuilder.create().toJson(data)).build();
    }
*/

}
