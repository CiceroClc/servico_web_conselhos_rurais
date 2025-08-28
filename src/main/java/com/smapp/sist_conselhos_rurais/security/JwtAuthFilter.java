package com.smapp.sist_conselhos_rurais.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.io.IOException;

@Component
public class JwtAuthFilter extends GenericFilter{

	private final JwtUtil jwt;
    private final CustomUserDetailsService uds;

    public JwtAuthFilter(JwtUtil jwt, CustomUserDetailsService uds) {
        this.jwt = jwt;
        this.uds = uds;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        String header = request.getHeader("Authorization");

        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                var jws = jwt.parse(token);
                String username = jws.getPayload().getSubject();

                UserDetails user = uds.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                // token inválido/expirado - segue sem autenticar
            }
        }

        chain.doFilter(req, res);
    }	
}
