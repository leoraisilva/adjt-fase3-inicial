package infra.adapter.inbound.mapper;

import application.domain.Triagem;
import application.domain.TriagemFactory;
import infra.adapter.outbound.persistent.entity.AnamneseEntity;
import infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import infra.adapter.outbound.persistent.entity.TriagemEntity;

public class TriagemMapper {
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
