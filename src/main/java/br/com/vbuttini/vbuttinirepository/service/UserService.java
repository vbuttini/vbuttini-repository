package br.com.vbuttini.vbuttinirepository.service;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.mapper.UserMapper;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.repository.UserRepository;
import br.com.vbuttini.vbuttinirepository.service.exception.DataBaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Vinícius Buttini
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserAuthService userAuthService;

    public UserDto insert(UserModel userModel) {
            verifyExistence(userModel.getEmail());
            userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
            userModel.getCompany().setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
            userModel.getCompany().setUser(userModel);
            return userMapper.convertToDto(userRepository.save(userModel));

    }

    public UserDto findById(Long id) {
        return userMapper.convertToDto(
                userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")));
    }

    public UserDto getUserByAuth() {
        return userAuthService.getAuth();
    }

    private void verifyExistence(String email) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(email))) {
            throw new DataBaseException("Usuário já existe!");
        }
    }

}