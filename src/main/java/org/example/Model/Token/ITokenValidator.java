package org.example.Model.Token;

import java.security.Key;

public interface ITokenValidator {
    String validate(String token) throws Exception;
}
