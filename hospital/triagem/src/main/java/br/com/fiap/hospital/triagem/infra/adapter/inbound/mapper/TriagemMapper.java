package br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.triagem.application.domain.TriagemFactory;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.TriagemEntity;

public class TriagemMapper implements ITriagemMapper {
    private final TriagemFactory factory;
    private final IAvaliacaoMapper avaliacaoMapper;
    private final IAnamneseMapper anamneseMapper;

    public TriagemMapper(TriagemFactory factory, IAvaliacaoMapper avaliacaoMapper, IAnamneseMapper anamneseMapper) {
        this.factory = factory;
        this.avaliacaoMapper = avaliacaoMapper;
        this.anamneseMapper = anamneseMapper;
    }

    public Triagem toDomain (TriagemEntity entity, AvaliacaoEntity avaliacaoEntity, AnamneseEntity anamneseEntity) {
        return factory.newTriagem(
                entity.getIdTriagem(),
                entity.getPaciente(),
                entity.getResponsavel(),
                anamneseMapper.toDomain(anamneseEntity),
                avaliacaoMapper.toDomain(avaliacaoEntity)
        );
    }

    public TriagemEntity toEntity (Triagem domain) {
        return new TriagemEntity (
                domain.getPaciente(),
                domain.getResponsavel(),
                domain.getAnamnese().getIdAnamnese(),
                domain.getAvaliacao().getIdAvaliacao()
        );
    }
}
