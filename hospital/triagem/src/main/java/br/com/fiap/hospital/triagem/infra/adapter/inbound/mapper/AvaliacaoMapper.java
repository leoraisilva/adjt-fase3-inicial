package br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.application.domain.AvaliacaoFactory;
import br.com.fiap.hospital.triagem.application.domain.Classificacao;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;

public class AvaliacaoMapper implements IAvaliacaoMapper {
    private final AvaliacaoFactory factory;

    public AvaliacaoMapper(AvaliacaoFactory factory) {
        this.factory = factory;
    }

    public Avaliacao toDomain (AvaliacaoEntity entity) {
        return factory.newAvaliacao(
                entity.getIdAvaliacao(),
                entity.getPressao(),
                entity.getOxigenacao(),
                entity.getQuadroClinico(),
                Classificacao.valueOf(entity.getRisco())
        );
    }

    public AvaliacaoEntity toEntity (Avaliacao domain) {
        return new AvaliacaoEntity(
                domain.getPressao(),
                domain.getOxigenacao(),
                domain.getQuadroClinico(),
                domain.getRisco().toString()
        );
    }
}
