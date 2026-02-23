package br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.usuario.application.domain.Usuario;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;

public interface IUsuarioMapper {
    Usuario toDomain (UsuarioEntity entity);
    UsuarioEntity toEntity (Usuario usuario);
}
