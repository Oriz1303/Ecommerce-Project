package com.oriz.backend_system.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtConstant {
//    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final String SECRET_KEY = "asdasdasdvfgbdsbertyiueytbgd@fbtrshgwer12312sdsatewrqgrqevfgvcxbrtb";
    public static final String JWT_HEADER = "Authorization";
}
