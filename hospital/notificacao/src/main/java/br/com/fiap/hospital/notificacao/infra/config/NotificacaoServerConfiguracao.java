package br.com.fiap.hospital.notificacao.infra.config;

import br.com.fiap.hospital.notificacao.application.domain.DefaultNotificacaoFactory;
import br.com.fiap.hospital.notificacao.application.domain.NotificacaoFactory;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.NotificacaoMapper;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;

import javax.annotation.Nullable;
import java.util.concurrent.Executors;

@Configuration
public class NotificacaoServerConfiguracao {
    @Bean
    public GrpcServerConfigurer serverConfigurer () {
        return serverBuilder -> serverBuilder.executor(Executors.newVirtualThreadPerTaskExecutor());
    }
    @Bean
    public GrpcAuthenticationReader grpcAuthenticationReader() {
        return new GrpcAuthenticationReader() {

            @Nullable
            @Override
            public org.springframework.security.core.Authentication readAuthentication(ServerCall<?, ?> call, Metadata headers) throws AuthenticationException {
                return null;
            }
        };
    }
    @Bean
    public INotificacaoMapper notificacaoMapper (NotificacaoFactory notificacaoFactory) {
        return new NotificacaoMapper(notificacaoFactory);
    }
    @Bean
    public NotificacaoFactory notificacaoFactory () {
        return new DefaultNotificacaoFactory();
    }

}
