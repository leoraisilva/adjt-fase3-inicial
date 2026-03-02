package br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvaliacaoJPARepository extends JpaRepository<AvaliacaoEntity, String> {
    Optional<AvaliacaoEntity> findById (String idAvaliacao);
}
