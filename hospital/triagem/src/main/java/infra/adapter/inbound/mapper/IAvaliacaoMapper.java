package infra.adapter.inbound.mapper;

import application.domain.Avaliacao;
import infra.adapter.outbound.persistent.entity.AvaliacaoEntity;

public interface IAvaliacaoMapper {
    Avaliacao toDomain (AvaliacaoEntity entity);
    AvaliacaoEntity toEntity (Avaliacao domain);
}
