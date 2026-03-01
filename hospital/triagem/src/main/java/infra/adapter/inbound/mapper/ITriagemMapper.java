package infra.adapter.inbound.mapper;

import application.domain.Triagem;
import infra.adapter.outbound.persistent.entity.AnamneseEntity;
import infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import infra.adapter.outbound.persistent.entity.TriagemEntity;

public interface ITriagemMapper {
    Triagem toDomain (TriagemEntity entity, AvaliacaoEntity avaliacaoEntity, AnamneseEntity anamneseEntity);
    TriagemEntity toEntity (Triagem domain);
}
