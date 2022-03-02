package org.example.Model.Token;

import java.security.Key;

public interface ITokenIssuer {
    String JWS_Create(String username);

    String issueToken(String username);
}
