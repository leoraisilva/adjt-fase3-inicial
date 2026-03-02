package br.com.fiap.hospital.triagem.infra.adapter.gateway;

import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.triagem.application.useCase.outbound.TriagemRepository;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.ITriagemMapper;
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
        var avaliacaoEntity = avaliacaoJPARepository.findById(triagem.getAvaliacao().getIdAvaliacao());
        if (!avaliacaoEntity.isPresent()) {
            avaliacaoEntity.get().setIdAvaliacao(UUID.randomUUID().toString());
            avaliacaoEntity.get().setOxigenacao(triagem.getAvaliacao().getOxigenacao());
            avaliacaoEntity.get().setPressao(triagem.getAvaliacao().getPressao());
            avaliacaoEntity.get().setQuadroClinico(triagem.getAvaliacao().getQuadroClinico());
            avaliacaoEntity.get().setRisco(triagem.getAvaliacao().getRisco().toString());
            avaliacaoJPARepository.save(avaliacaoEntity.get());
        }
        var anamneseEntity = anamneseJPARepository.findById(triagem.getAnamnese().getIdAnamnese());
        if (!anamneseEntity.isPresent()) {
            anamneseEntity.get().setIdAnamnese(UUID.randomUUID().toString());
            anamneseEntity.get().setDescricao(triagem.getAnamnese().getDescricao());
            anamneseEntity.get().setDores(triagem.getAnamnese().getDores().toString());
            anamneseEntity.get().setPressaoAlta(triagem.getAnamnese().isPressaoAlta());
            anamneseEntity.get().setDiabete(triagem.getAnamnese().isDiabete());
            anamneseEntity.get().setCoracao(triagem.getAnamnese().isCoracao());
            anamneseEntity.get().setHistoricoFamilia(triagem.getAnamnese().getHistoricoFamilia());
            anamneseEntity.get().setMembroFamilia(triagem.getAnamnese().getMembroFamilia());
            anamneseJPARepository.save(anamneseEntity.get());
        }
        var triagemEntity = triagemMapper.toEntity(triagem);
        triagemEntity.setIdTriagem(UUID.randomUUID().toString());
        return triagemMapper.toDomain(triagemJPARepository.save(triagemEntity), avaliacaoEntity.get(), anamneseEntity.get());
    }

    @Override
    public Triagem alterarTriagem(Triagem triagem) {
        var avaliacaoEntity = avaliacaoJPARepository.findById(triagem.getAvaliacao().getIdAvaliacao());
        avaliacaoEntity.get().setIdAvaliacao(triagem.getAvaliacao().getIdAvaliacao());
        avaliacaoEntity.get().setOxigenacao(triagem.getAvaliacao().getOxigenacao());
        avaliacaoEntity.get().setPressao(triagem.getAvaliacao().getPressao());
        avaliacaoEntity.get().setQuadroClinico(triagem.getAvaliacao().getQuadroClinico());
        avaliacaoEntity.get().setRisco(triagem.getAvaliacao().getRisco().toString());
        avaliacaoJPARepository.save(avaliacaoEntity.get());

        var anamneseEntity = anamneseJPARepository.findById(triagem.getAnamnese().getIdAnamnese());
        anamneseEntity.get().setIdAnamnese(triagem.getAnamnese().getIdAnamnese());
        anamneseEntity.get().setDescricao(triagem.getAnamnese().getDescricao());
        anamneseEntity.get().setDores(triagem.getAnamnese().getDores().toString());
        anamneseEntity.get().setPressaoAlta(triagem.getAnamnese().isPressaoAlta());
        anamneseEntity.get().setDiabete(triagem.getAnamnese().isDiabete());
        anamneseEntity.get().setCoracao(triagem.getAnamnese().isCoracao());
        anamneseEntity.get().setHistoricoFamilia(triagem.getAnamnese().getHistoricoFamilia());
        anamneseEntity.get().setMembroFamilia(triagem.getAnamnese().getMembroFamilia());
        anamneseJPARepository.save(anamneseEntity.get());

        var triagemEntity = triagemJPARepository.findByPaciente(triagem.getPaciente());
        triagemEntity.setResponsavel(triagem.getResponsavel());
        triagemEntity.setIdTriagem(triagem.getIdTriagem());
        triagemEntity.setIdAnamnese(anamneseEntity.get().getIdAnamnese());
        triagemEntity.setIdAvaliacao(avaliacaoEntity.get().getIdAvaliacao());
        triagemJPARepository.save(triagemEntity);

        return triagemMapper.toDomain(triagemEntity, avaliacaoEntity.get(), anamneseEntity.get());
    }

    @Override
    public Triagem consultarTriagem(String paciente) {
        var triagem = triagemJPARepository.findByPaciente(paciente);
        var avaliacao = avaliacaoJPARepository.findById(triagem.getIdAvaliacao());
        var anamnese = anamneseJPARepository.findById(triagem.getIdAnamnese());
        return triagemMapper.toDomain(triagem,avaliacao.get(), anamnese.get());
    }
}
