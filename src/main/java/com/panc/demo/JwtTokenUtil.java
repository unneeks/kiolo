package com.panc.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenUtil {

   
    private String secret;

    public String getUsernameFromToken(String token) {
       // secret = token;
		return "";  //;Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return true;
    }

    private String getExpirationDateFromToken(String token) {
        return ""; //;new Date(); //Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
    }
}
