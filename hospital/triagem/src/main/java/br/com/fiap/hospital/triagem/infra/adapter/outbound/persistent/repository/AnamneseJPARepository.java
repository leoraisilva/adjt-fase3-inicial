package br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository;

import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnamneseJPARepository extends JpaRepository<AnamneseEntity, String> {
    Optional<AnamneseEntity> findById (String IdAnamnese);
}
