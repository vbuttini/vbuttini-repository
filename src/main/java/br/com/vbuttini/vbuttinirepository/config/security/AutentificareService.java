package br.com.buttini.roupaBackend.config.security;

import br.com.buttini.roupaBackend.entity.User;
import br.com.buttini.roupaBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Vinícius Buttini
 */
@Service
public class AutentificareService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos!");
    }
}