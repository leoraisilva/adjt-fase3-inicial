package br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.TriagemEntity;

public interface ITriagemMapper {
    Triagem toDomain (TriagemEntity entity, AvaliacaoEntity avaliacaoEntity, AnamneseEntity anamneseEntity);
    TriagemEntity toEntity (Triagem domain);
}
