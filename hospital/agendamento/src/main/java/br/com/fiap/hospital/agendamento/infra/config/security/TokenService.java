package br.com.fiap.hospital.agendamento.infra.config.security;

import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service("agendamentoTokenService")
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String GenerationToken (UsuarioEntity entity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("hospital")
                    .withSubject(entity.getUsername())
                    .withExpiresAt(LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException jwtException) {
            throw new JWTCreationException("Erro na Criação do Token", jwtException);
        }
    }

    public String ValidationToken (String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("hospital")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException jwtException) {
            throw new JWTVerificationException("Erro na validação do token", jwtException);
        }
    }
}