package br.com.vbuttini.vbuttinirepository.mapper;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto convertToDto(UserModel user) {
        return new UserDto(user.getId(), user.getEmail());
    }

}
