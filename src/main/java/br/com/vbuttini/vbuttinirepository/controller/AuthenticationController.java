package br.com.buttini.roupaBackend.controller;

import br.com.buttini.roupaBackend.config.security.TokenService;
import br.com.buttini.roupaBackend.dto.DepartmentDto;
import br.com.buttini.roupaBackend.dto.TokenDto;
import br.com.buttini.roupaBackend.dto.UserDto;
import br.com.buttini.roupaBackend.entity.LoginForm;
import br.com.buttini.roupaBackend.mapper.DepartmentMapper;
import br.com.buttini.roupaBackend.service.UserAuthService;
import br.com.buttini.roupaBackend.service.exception.DataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import static br.com.buttini.roupaBackend.util.Constants.TEAM_NOT_RETURN;

/**
 * @author Vinícius Buttini
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody
                                                      LoginForm form){
        try {
            Authentication authentication = authenticationManager.authenticate(form.converter());
            String token = tokenService.generateToken(authentication);
            DepartmentDto department = departmentMapper.convertToDto(tokenService.getDepartment(token), TEAM_NOT_RETURN);
            Long userId = tokenService.getUserId(token);
            return ResponseEntity.ok(new TokenDto(token, "Bearer", department, userId));
        }catch (AuthenticationException e){
            throw new DataBaseException("User not found");
        }
    }

    @GetMapping
    public ResponseEntity<UserDto> findAuth(){
        return ResponseEntity.ok().body(userAuthService.getAuth());
    }

    @GetMapping(value = "/department")
    public ResponseEntity<DepartmentDto> findAuthDepartment(){
        return ResponseEntity.ok().body(userAuthService.getDepartmentByAuth());
    }

}