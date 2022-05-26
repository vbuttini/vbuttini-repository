package br.com.vbuttini.vbuttinirepository.config.security;

import br.com.vbuttini.vbuttinirepository.model.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Vinícius Buttini
 */
@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication){
        UserModel user = (UserModel) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime()+ Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("vbuttini-repository")
                .setSubject(user.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getUserId(String token) {
        return Long.parseLong(Jwts.parser().setSigningKey(this.secret)
                .parseClaimsJws(token).getBody().getSubject());
    }
    
}