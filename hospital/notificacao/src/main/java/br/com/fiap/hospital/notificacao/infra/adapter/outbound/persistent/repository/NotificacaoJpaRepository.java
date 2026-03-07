package br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificacaoJpaRepository extends JpaRepository<NotificacaoEntity, String> {
    Optional<NotificacaoEntity> findByCategoria (String categoria);
}
