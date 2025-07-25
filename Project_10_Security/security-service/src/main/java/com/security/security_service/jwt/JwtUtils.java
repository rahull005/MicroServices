package com.security.security_service.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.websocket.Decoder;
import org.bouncycastle.jcajce.provider.asymmetric.mldsa.MLDSAKeyFactorySpi;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtUtils {

    private String secretKey = "mysecretkeymysecretkeymysecretkeymysecretkey";


    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+3600000))
                .signWith(getKey())
                .compact();
    }


    public SecretKey getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public void validateToken(String token){
         Jwts.parser()
         .verifyWith(getKey())
         .build()
         .parseSignedClaims(token);
    }
}
