package br.com.fiap.hospital.usuario.infra.config.security;

import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class UsuarioSecurity {
    private final SecurityFilter securityFilter;

    public UsuarioSecurity(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/hospital/usuario/api/v1/create").permitAll()
                        .requestMatchers(HttpMethod.POST, "/hospital/usuario/api/v1/auth/login").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/hospital/usuario/api/v1/update").hasAnyRole("MEDICO", "ENFERMEIRO", "PACIENTE")
                        .requestMatchers(HttpMethod.DELETE, "/hospital/usuario/api/v1/delete/{username}").hasAnyRole("MEDICO", "ENFERMEIRO")
                        .requestMatchers(HttpMethod.GET, "/hospital/usuario/api/v1/get/{username}").hasAnyRole("MEDICO", "ENFERMEIRO")
                        .requestMatchers(HttpMethod.GET, "/hospital/usuario/api/v1/list").hasAnyRole("MEDICO", "ENFERMEIRO")
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UsuarioJPARepository usuarioJPARepository) {
        return username -> {
            var user = usuarioJPARepository.findByUsername(username);
            if(user == null)
                throw new UsernameNotFoundException("Usuario não encontrado " + username);
            return user;
        };
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
