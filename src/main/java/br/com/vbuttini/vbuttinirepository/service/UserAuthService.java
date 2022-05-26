package br.com.vbuttini.vbuttinirepository.service;

import br.com.vbuttini.vbuttinirepository.dto.UserDto;
import br.com.vbuttini.vbuttinirepository.mapper.UserMapper;
import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Vinícius Buttini
 */
@SuppressWarnings("AlibabaTransactionMustHaveRollback")
@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto getAuth(){
        return userMapper.convertToDto(getAuthModel());
    }

    public UserModel getAuthModel(){
        return userRepository.findByEmail(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
        ).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }

}