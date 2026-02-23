package br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.usuario.application.domain.Usuario;
import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;

public class UsuarioMapper implements IUsuarioMapper {
    private final UsuarioFactory factory;

    public UsuarioMapper (UsuarioFactory factory) {
        this.factory = factory;
    }

    public Usuario toDomain (UsuarioEntity entity) {
        return factory.usuarioFactory(
                entity.getNome(),
                entity.getUsername(),
                entity.getSenha(),
                entity.getDataNascimento(),
                entity.getCPF(),
                entity.getEmail(),
                entity.getTell(),
                entity.getTipo()
        );
    }

    public UsuarioEntity toEntity (Usuario usuario) {
        return  new UsuarioEntity(
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNascimento(),
                usuario.getTipo(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getTell()
        );
    }
}
