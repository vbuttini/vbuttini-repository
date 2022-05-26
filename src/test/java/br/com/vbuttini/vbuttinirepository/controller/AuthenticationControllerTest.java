package br.com.vbuttini.vbuttinirepository.controller;

import br.com.vbuttini.vbuttinirepository.config.security.TokenService;
import br.com.vbuttini.vbuttinirepository.model.LoginForm;
import br.com.vbuttini.vbuttinirepository.service.UserAuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author Vinícius Buttini
 */
class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenService tokenService;

    @Mock
    private UserAuthService userAuthService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void authenticate(){
        var requestBody = Mockito.any(LoginForm.class);
    }


}