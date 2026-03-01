package infra.adapter.outbound.persistent.repository;

import infra.adapter.outbound.persistent.entity.TriagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriagemJPARepository extends JpaRepository<TriagemEntity, String> {
    TriagemEntity findByPaciente (String paciente);
}
