package br.com.vbuttini.vbuttinirepository.controller;

import br.com.vbuttini.vbuttinirepository.config.security.TokenService;
import br.com.vbuttini.vbuttinirepository.dto.TokenDto;
import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.model.LoginForm;
import br.com.vbuttini.vbuttinirepository.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vinícius Buttini
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final UserAuthService userAuthService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody
                                                 LoginForm form){
        try {
            Authentication authentication = authenticationManager.authenticate(form.converter());
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch (AuthenticationException e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    @GetMapping
    public ResponseEntity<UserDto> findAuth(){
        return ResponseEntity.ok().body(userAuthService.getAuth());
    }

}