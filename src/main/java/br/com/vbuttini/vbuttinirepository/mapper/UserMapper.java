package br.com.vbuttini.vbuttinirepository.mapper;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private CompanyMapper companyMapper;

    public UserDto convertToDto(UserModel user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                companyMapper.convertToDto(user.getCompany())
        );
    }

}
