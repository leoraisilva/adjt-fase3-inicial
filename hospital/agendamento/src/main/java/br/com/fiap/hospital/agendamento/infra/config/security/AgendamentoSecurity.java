package br.com.fiap.hospital.agendamento.infra.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AgendamentoSecurity {
    private final SecurityFilter securityFilter;

    public AgendamentoSecurity(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean(name = "agendamentoSecurityFilterChain")
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers(HttpMethod.POST, "/hospital/agendamento/api/v1/agendar").hasAnyRole("MEDICO", "ENFERMEIRO", "PACIENTE")
                        .requestMatchers(HttpMethod.PUT, "/hospital/agendamento/api/v1/reagendar").hasAnyRole("MEDICO", "ENFERMEIRO", "PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/hospital/agendamento/api/v1/verificar").hasAnyRole("MEDICO", "ENFERMEIRO")
                        .requestMatchers(HttpMethod.GET, "/hospital/agendamento/api/v1/buscarConsulta/{id}").hasAnyRole("MEDICO", "ENFERMEIRO", "PACIENTE")
                        .requestMatchers(HttpMethod.GET, "/hospital/agendamento/api/v1/cancelar/{id}").hasAnyRole("MEDICO", "ENFERMEIRO", "PACIENTE")
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
