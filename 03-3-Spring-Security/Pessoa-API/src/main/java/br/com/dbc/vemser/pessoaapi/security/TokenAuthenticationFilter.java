package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final String BEARER = "Bearer ";

//    private void authenticate(Optional<UsuarioEntity> optionalUsuarioEntity) {
//        if (optionalUsuarioEntity.isPresent()) {
//            UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                    new UsernamePasswordAuthenticationToken(usuarioEntity.getLogin(), usuarioEntity.getSenha(), Collections.emptyList());
//            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        } else {
//            SecurityContextHolder.getContext().setAuthentication(null);
//        }
//    }

    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        return token.replace(BEARER, "");
    }

    // TokenAuthenticationFilter
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String tokenFromHeader = getTokenFromHeader(request);
        UsernamePasswordAuthenticationToken user = tokenService.isValid(tokenFromHeader);
        SecurityContextHolder.getContext().setAuthentication(user);

        // authenticate(usuario);

        filterChain.doFilter(request, response);
    }

}
