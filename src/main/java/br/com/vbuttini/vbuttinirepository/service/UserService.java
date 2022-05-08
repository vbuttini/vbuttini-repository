package br.com.vbuttini.vbuttinirepository.service;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.mapper.UserMapper;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Vinícius Buttini
 */
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAuthService userAuthService;

    public UserModel insert(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserDto findById(Long id) {
        return userMapper.convertToDto(
                userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")));
    }

    public UserDto getUserByAuth() {
        return userAuthService.getAuth();
    }

}
