package br.com.vbuttini.vbuttinirepository.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Vinícius Buttini
 */
@Getter
@Setter
public class LoginForm {

    private String email;

    private String password;

    public UsernamePasswordAuthenticationToken converter(){
        return new UsernamePasswordAuthenticationToken(email,password);
    }

}