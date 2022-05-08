package br.com.buttini.roupaBackend.config.security;

import br.com.buttini.roupaBackend.entity.User;
import br.com.buttini.roupaBackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vinícius Buttini
 */
@SuppressWarnings("ALL")
@Configuration
@AllArgsConstructor
public class FilterTokenAuthentificare extends OncePerRequestFilter {

    private TokenService tokenService;

    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = retriveToken(request);

        if (tokenService.isValidToken(token)){
            authenticateUser(token);
        }

        filterChain.doFilter(request,response);
    }

    private void authenticateUser(String token) {
        Long userId = tokenService.getUserId(token);
        User user = userRepository.getById(userId);
        UsernamePasswordAuthenticationToken authenticarion = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticarion);
    }

    private String retriveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(token) || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7);
    }
}