package br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoJPARepository extends JpaRepository<AgendamentoEntity, String> {
}
