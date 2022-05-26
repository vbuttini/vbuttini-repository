package br.com.vbuttini.vbuttinirepository.config.security;

import br.com.vbuttini.vbuttinirepository.model.UserModel;
import br.com.vbuttini.vbuttinirepository.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
@Configuration
@RequiredArgsConstructor
public class FilterTokenAuthentication extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(request);
        if (Boolean.TRUE.equals(tokenService.isValidToken(token))){
            authenticateUser(token);
        }
        filterChain.doFilter(request,response);
    }

    private void authenticateUser(String token) {
        Long userId = tokenService.getUserId(token);
        UserModel user = userRepository.getById(userId);
        SecurityContextHolder
                .getContext()
                .setAuthentication(
                        new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities())
                );
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        //noinspection AlibabaUndefineMagicConstant
        if (ObjectUtils.isEmpty(token) || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7);
    }

}