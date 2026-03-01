package infra.adapter.inbound.mapper;

import application.domain.Anamnese;
import application.domain.AnamneseFactory;
import application.domain.Intensidade;
import infra.adapter.outbound.persistent.entity.AnamneseEntity;

public class AnamneseMapper implements IAnamneseMapper{

    private final AnamneseFactory factory;

    public AnamneseMapper(AnamneseFactory factory) {
        this.factory = factory;
    }

    public Anamnese toDomain (AnamneseEntity entity) {
        return factory.newAnamnese(
                entity.getIdAnamnese(),
                entity.getDescricao(),
                Intensidade.valueOf(entity.getDores()),
                entity.isDiabete(),
                entity.isPressaoAlta(),
                entity.isCoracao(),
                entity.getHistoricoFamilia(),
                entity.getMembroFamilia()
        );
    }

    public AnamneseEntity toEntity (Anamnese domain) {
        return new AnamneseEntity(
             domain.getDescricao(),
             domain.getDores().toString(),
             domain.isDiabete(),
             domain.isPressaoAlta(),
             domain.isCoracao(),
             domain.getHistoricoFamilia(),
             domain.getMembroFamilia()
        );
    }
}
