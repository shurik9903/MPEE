package org.example.Model.Token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

class TokenIssuer implements ITokenIssuer{

    private String key;


    public TokenIssuer(String lKey) {
        key = lKey;
    }

    @Override
    public String JWS_Create(String username){

        String header = "{\"alg\":\"HS256\"}";
        String claims = "{\"sub\":\""+username+"\"}";

        String encodedHeader;
        String encodedClaims;

        try {
            encodedHeader = Base64.getUrlEncoder().encodeToString(header.getBytes("UTF-8"));
            encodedClaims = Base64.getUrlEncoder().encodeToString(claims.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }

        String concatenated = encodedHeader + '.' + encodedClaims;
        String jws = Encoders.BASE64.encode(new SecretKeySpec((concatenated+key).getBytes(StandardCharsets.UTF_8) , "HmacSHA256").getEncoded());

        return concatenated + '.' + Base64.getUrlEncoder().encodeToString(jws.getBytes(StandardCharsets.UTF_8));

    }

    @Override
    public String issueToken(String username) {

        String jws = JWS_Create(username);

        LocalDateTime expiryPeriod = LocalDateTime.now().plusMinutes(600L);
        Date expirationDateTime = Date.from(
                expiryPeriod.atZone(ZoneId.systemDefault())
                        .toInstant());


        String compactJws = Jwts.builder()
                .setSubject(username)
                .claim("scope", "user")
                .signWith(SignatureAlgorithm.HS256, key)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + (1000)))
                .compact();

        return compactJws;
    }
}
