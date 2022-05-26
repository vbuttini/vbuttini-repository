package br.com.vbuttini.vbuttinirepository.controller;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Vinícius Buttini
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserControllerTest {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserModel userModel){
        UserDto userDto = userService.insert(userModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping(value = "/auth")
    public ResponseEntity<UserDto> findUserByAuth(){
        return ResponseEntity.ok().body(userService.getUserByAuth());
    }

}
