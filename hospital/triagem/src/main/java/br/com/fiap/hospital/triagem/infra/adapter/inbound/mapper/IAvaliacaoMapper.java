package br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;

public interface IAvaliacaoMapper {
    Avaliacao toDomain (AvaliacaoEntity entity);
    AvaliacaoEntity toEntity (Avaliacao domain);
}
