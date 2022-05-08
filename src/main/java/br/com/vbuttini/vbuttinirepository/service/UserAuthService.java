package br.com.buttini.roupaBackend.service;

import br.com.buttini.roupaBackend.dto.DepartmentDto;
import br.com.buttini.roupaBackend.dto.UserDto;
import br.com.buttini.roupaBackend.entity.User;
import br.com.buttini.roupaBackend.mapper.DepartmentMapper;
import br.com.buttini.roupaBackend.mapper.UserMapper;
import br.com.buttini.roupaBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.buttini.roupaBackend.util.Constants.EMPLOY_RETURN;
import static br.com.buttini.roupaBackend.util.Constants.TEAM_NOT_RETURN;

/**
 * @author Vinícius Buttini
 */
@Service
@Transactional
public class UserAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public UserDto getAuth(){
        return userMapper.convertToDto(getAuthModel(), EMPLOY_RETURN);
    }

    public User getAuthModel(){
        return userRepository.findByEmail(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
        ).get();
    }

    public DepartmentDto getDepartmentByAuth(){
        return departmentMapper.convertToDto(
                getAuthModel().getDepartment(),
                TEAM_NOT_RETURN
        );
    }

}