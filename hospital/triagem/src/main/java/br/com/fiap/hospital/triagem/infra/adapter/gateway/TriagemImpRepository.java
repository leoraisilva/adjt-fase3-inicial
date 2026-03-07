package br.com.fiap.hospital.triagem.infra.adapter.gateway;

import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.triagem.application.useCase.outbound.TriagemRepository;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.ITriagemMapper;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AnamneseJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AvaliacaoJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.TriagemJPARepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TriagemImpRepository implements TriagemRepository {
    private final AnamneseJPARepository anamneseJPARepository;
    private final AvaliacaoJPARepository avaliacaoJPARepository;
    private final TriagemJPARepository triagemJPARepository;
    private final ITriagemMapper triagemMapper;

    public TriagemImpRepository(AnamneseJPARepository anamneseJPARepository, AvaliacaoJPARepository avaliacaoJPARepository, TriagemJPARepository triagemJPARepository, ITriagemMapper triagemMapper) {
        this.anamneseJPARepository = anamneseJPARepository;
        this.avaliacaoJPARepository = avaliacaoJPARepository;
        this.triagemJPARepository = triagemJPARepository;
        this.triagemMapper = triagemMapper;
    }

    @Override
    public Triagem gerarTriagem(Triagem triagem) {
        var avaliacaoEntity = avaliacaoJPARepository.findById(triagem.getAvaliacao().getIdAvaliacao()).orElseGet(AvaliacaoEntity::new);
        avaliacaoEntity.setIdAvaliacao(triagem.getAvaliacao().getIdAvaliacao());
        avaliacaoEntity.setOxigenacao(triagem.getAvaliacao().getOxigenacao());
        avaliacaoEntity.setPressao(triagem.getAvaliacao().getPressao());
        avaliacaoEntity.setQuadroClinico(triagem.getAvaliacao().getQuadroClinico());
        avaliacaoEntity.setRisco(triagem.getAvaliacao().getRisco().toString());
        avaliacaoJPARepository.save(avaliacaoEntity);

        var anamneseEntity = anamneseJPARepository.findById(triagem.getAnamnese().getIdAnamnese()).orElseGet(AnamneseEntity::new);
        anamneseEntity.setIdAnamnese(triagem.getAnamnese().getIdAnamnese());
        anamneseEntity.setDescricao(triagem.getAnamnese().getDescricao());
        anamneseEntity.setDores(triagem.getAnamnese().getDores().toString());
        anamneseEntity.setPressaoAlta(triagem.getAnamnese().isPressaoAlta());
        anamneseEntity.setDiabete(triagem.getAnamnese().isDiabete());
        anamneseEntity.setCoracao(triagem.getAnamnese().isCoracao());
        anamneseEntity.setHistoricoFamilia(triagem.getAnamnese().getHistoricoFamilia());
        anamneseEntity.setMembroFamilia(triagem.getAnamnese().getMembroFamilia());
        anamneseJPARepository.save(anamneseEntity);

        var triagemEntity = triagemMapper.toEntity(triagem);
        triagemEntity.setIdTriagem(UUID.randomUUID().toString());
        return triagemMapper.toDomain(triagemJPARepository.save(triagemEntity), avaliacaoEntity, anamneseEntity);
    }

    @Override
    public Triagem alterarTriagem(Triagem triagem) {
        var avaliacaoEntity = avaliacaoJPARepository.findById(triagem.getAvaliacao().getIdAvaliacao()).orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
        avaliacaoEntity.setIdAvaliacao(triagem.getAvaliacao().getIdAvaliacao());
        avaliacaoEntity.setOxigenacao(triagem.getAvaliacao().getOxigenacao());
        avaliacaoEntity.setPressao(triagem.getAvaliacao().getPressao());
        avaliacaoEntity.setQuadroClinico(triagem.getAvaliacao().getQuadroClinico());
        avaliacaoEntity.setRisco(triagem.getAvaliacao().getRisco().toString());
        avaliacaoJPARepository.save(avaliacaoEntity);

        var anamneseEntity = anamneseJPARepository.findById(triagem.getAnamnese().getIdAnamnese()).orElseThrow(() -> new RuntimeException("Anamnese não encontrada"));
        anamneseEntity.setIdAnamnese(triagem.getAnamnese().getIdAnamnese());
        anamneseEntity.setDescricao(triagem.getAnamnese().getDescricao());
        anamneseEntity.setDores(triagem.getAnamnese().getDores().toString());
        anamneseEntity.setPressaoAlta(triagem.getAnamnese().isPressaoAlta());
        anamneseEntity.setDiabete(triagem.getAnamnese().isDiabete());
        anamneseEntity.setCoracao(triagem.getAnamnese().isCoracao());
        anamneseEntity.setHistoricoFamilia(triagem.getAnamnese().getHistoricoFamilia());
        anamneseEntity.setMembroFamilia(triagem.getAnamnese().getMembroFamilia());
        anamneseJPARepository.save(anamneseEntity);

        var triagemEntity = triagemJPARepository.findByPaciente(triagem.getPaciente());
        triagemEntity.setResponsavel(triagem.getResponsavel());
        triagemEntity.setIdTriagem(triagem.getIdTriagem());
        triagemEntity.setIdAnamnese(anamneseEntity.getIdAnamnese());
        triagemEntity.setIdAvaliacao(avaliacaoEntity.getIdAvaliacao());
        triagemJPARepository.save(triagemEntity);

        return triagemMapper.toDomain(triagemEntity, avaliacaoEntity, anamneseEntity);
    }

    @Override
    public Triagem consultarTriagem(String idTriagem) {
        var triagem = triagemJPARepository.findById(idTriagem)
                .orElseThrow(() -> new RuntimeException("Triagem não encontrada"));

        var avaliacao = avaliacaoJPARepository.findById(triagem.getIdAvaliacao())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        var anamnese = anamneseJPARepository.findById(triagem.getIdAnamnese())
                .orElseThrow(() -> new RuntimeException("Anamnese não encontrada"));

        return triagemMapper.toDomain(triagem,avaliacao, anamnese);
    }
}
