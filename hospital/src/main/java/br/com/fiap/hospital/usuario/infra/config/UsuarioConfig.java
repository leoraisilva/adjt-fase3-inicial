package br.com.fiap.hospital.usuario.infra.config;

import br.com.fiap.hospital.usuario.application.domain.DefaultUsuarioFactory;
import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import br.com.fiap.hospital.usuario.application.service.UsuarioService;
import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.deleteUsuario.DeleteUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario.GetUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio.ListUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuario;
import br.com.fiap.hospital.usuario.application.useCase.outbound.UsuarioRepository;
import br.com.fiap.hospital.usuario.infra.adapter.gateway.UsuarioImplRepository;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.IUsuarioMapper;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.UsuarioMapper;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CreateUsuario createUsuario (UsuarioPort usuarioPort) {
        return new CreateUsuario(usuarioPort);
    }

    @Bean
    UpdateUsuario updateUsuario (UsuarioPort usuarioPort) {
        return new UpdateUsuario(usuarioPort);
    }

    @Bean
    DeleteUsuario deleteUsuario (UsuarioPort usuarioPort) {
        return new DeleteUsuario(usuarioPort);
    }

    @Bean
    GetUsuario getUsuario (UsuarioPort usuarioPort) {
        return new GetUsuario(usuarioPort);
    }

    @Bean
    ListUsuario listUsuario (UsuarioPort usuarioPort) {
        return new ListUsuario(usuarioPort);
    }

    @Bean
    UsuarioPort usuarioPort (UsuarioRepository repository) {
        return new UsuarioService(repository);
    }

    @Bean
    UsuarioFactory usuarioFactory () {
        return new DefaultUsuarioFactory();
    }

    @Bean
    IUsuarioMapper usuarioMapper (UsuarioFactory factory) {
        return new UsuarioMapper(factory);
    }

}
