package br.com.vbuttini.vbuttinirepository.mapper;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Vinícius Buttini
 */
@Component
@RequiredArgsConstructor
public class UserMapper {

    private final CompanyMapper companyMapper;

    public UserDto convertToDto(UserModel user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                companyMapper.convertToDto(user.getCompany())
        );
    }

}