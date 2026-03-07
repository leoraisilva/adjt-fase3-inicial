package br.com.fiap.hospital.notificacao.infra.config;

import br.com.fiap.hospital.notificacao.application.domain.DefaultNotificacaoFactory;
import br.com.fiap.hospital.notificacao.application.domain.NotificacaoFactory;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.NotificacaoMapper;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class NotificacaoServerConfiguracao {
    @Bean
    public GrpcServerConfigurer serverConfigurer () {
        return serverBuilder -> serverBuilder.executor(Executors.newVirtualThreadPerTaskExecutor());
    }
    @Bean
    public INotificacaoMapper notificacaoMapper (NotificacaoFactory factory) {
        return new NotificacaoMapper(factory);
    }
    @Bean
    public NotificacaoFactory factory () {
        return new DefaultNotificacaoFactory();
    }

}
