package org.example.Model.Token;

import io.jsonwebtoken.*;

import java.security.Key;

class TokenValidator implements ITokenValidator{

    private Key key;


    public TokenValidator(Key lKey) {
        key = lKey;
    }

    @Override
    public String validate(String token) throws Exception {

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return claims.getBody().getSubject();
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            throw new Exception("Invalid JWT");
        }
    }

}
