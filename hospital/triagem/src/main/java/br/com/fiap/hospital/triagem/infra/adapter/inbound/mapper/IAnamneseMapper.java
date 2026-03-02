package br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;

public interface IAnamneseMapper {
    Anamnese toDomain (AnamneseEntity entity);
    AnamneseEntity toEntity (Anamnese domain);
}
