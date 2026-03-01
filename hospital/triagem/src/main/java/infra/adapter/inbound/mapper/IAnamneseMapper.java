package infra.adapter.inbound.mapper;

import application.domain.Anamnese;
import infra.adapter.outbound.persistent.entity.AnamneseEntity;

public interface IAnamneseMapper {
    Anamnese toDomain (AnamneseEntity entity);
    AnamneseEntity toEntity (Anamnese domain);
}
