package br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity.HistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricoJpaRepository extends JpaRepository<HistoricoEntity, String> {
    Optional<HistoricoEntity> findByPaciente (String paciente);
}
