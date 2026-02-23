package br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJPARepository extends JpaRepository<UsuarioEntity, String> {
    UsuarioEntity findByUsername(String username);
}
