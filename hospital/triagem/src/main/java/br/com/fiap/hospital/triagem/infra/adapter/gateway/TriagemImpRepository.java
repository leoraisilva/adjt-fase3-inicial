package br.com.fiap.hospital.triagem.infra.adapter.gateway;

import br.com.fiap.hospital.mensageria.event.*;
import br.com.fiap.hospital.mensageria.producer.MensageriaEventProducer;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.triagem.application.useCase.outbound.TriagemRepository;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.ITriagemMapper;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AnamneseJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AvaliacaoJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.TriagemJPARepository;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class TriagemImpRepository implements TriagemRepository {
    private final AnamneseJPARepository anamneseJPARepository;
    private final AvaliacaoJPARepository avaliacaoJPARepository;
    private final TriagemJPARepository triagemJPARepository;
    private final UsuarioJPARepository usuarioJPARepository;
    private final ITriagemMapper triagemMapper;
    private final MensageriaEventProducer mensageria;

    public TriagemImpRepository(AnamneseJPARepository anamneseJPARepository, AvaliacaoJPARepository avaliacaoJPARepository, TriagemJPARepository triagemJPARepository, UsuarioJPARepository usuarioJPARepository, ITriagemMapper triagemMapper, MensageriaEventProducer mensageria) {
        this.anamneseJPARepository = anamneseJPARepository;
        this.avaliacaoJPARepository = avaliacaoJPARepository;
        this.triagemJPARepository = triagemJPARepository;
        this.usuarioJPARepository = usuarioJPARepository;
        this.triagemMapper = triagemMapper;
        this.mensageria = mensageria;
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

        var avalicaoDTO = new AvaliacaoDTO(
                avaliacaoEntity.getIdAvaliacao(),
                avaliacaoEntity.getPressao(),
                avaliacaoEntity.getOxigenacao(),
                avaliacaoEntity.getQuadroClinico(),
                avaliacaoEntity.getRisco()
        );

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

        var anamneseDTO = new AnamneseDTO(
                anamneseEntity.getIdAnamnese(),
                anamneseEntity.getDescricao(),
                anamneseEntity.getDores(),
                anamneseEntity.isDiabete(),
                anamneseEntity.isPressaoAlta(),
                anamneseEntity.isCoracao(),
                anamneseEntity.getHistoricoFamilia(),
                anamneseEntity.getMembroFamilia()
        );

        var triagemEntity = triagemMapper.toEntity(triagem);
        triagemEntity.setIdTriagem(UUID.randomUUID().toString());
        var usuario = usuarioJPARepository.findByUsername(triagemEntity.getPaciente());
        triagemEntity = triagemJPARepository.save(triagemEntity);

        var triagemDTO = new TriagemDTO(
                triagemEntity.getIdTriagem(),
                triagemEntity.getPaciente(),
                triagemEntity.getResponsavel(),
                anamneseDTO,
                avalicaoDTO
        );

        var usuarioDTO = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getDataNascimento().toString(),
                usuario.getTipo().toString(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getTell()
        );

        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                null,
                triagemDTO,
                LocalDate.now().toString(),
                "Criar a triagem para usuario " + usuarioDTO.username()
        );

        mensageria.sendHistorico(mensagemEnviada);
        return triagemMapper.toDomain(triagemEntity, avaliacaoEntity, anamneseEntity);
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

        var avalicaoDTO = new AvaliacaoDTO(
                avaliacaoEntity.getIdAvaliacao(),
                avaliacaoEntity.getPressao(),
                avaliacaoEntity.getOxigenacao(),
                avaliacaoEntity.getQuadroClinico(),
                avaliacaoEntity.getRisco()
        );

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

        var anamneseDTO = new AnamneseDTO(
                anamneseEntity.getIdAnamnese(),
                anamneseEntity.getDescricao(),
                anamneseEntity.getDores(),
                anamneseEntity.isDiabete(),
                anamneseEntity.isPressaoAlta(),
                anamneseEntity.isCoracao(),
                anamneseEntity.getHistoricoFamilia(),
                anamneseEntity.getMembroFamilia()
        );

        var triagemEntity = triagemJPARepository.findByPaciente(triagem.getPaciente());
        triagemEntity.setResponsavel(triagem.getResponsavel());
        triagemEntity.setIdTriagem(triagem.getIdTriagem());
        triagemEntity.setIdAnamnese(anamneseEntity.getIdAnamnese());
        triagemEntity.setIdAvaliacao(avaliacaoEntity.getIdAvaliacao());
        var usuario = usuarioJPARepository.findByUsername(triagemEntity.getPaciente());
        triagemJPARepository.save(triagemEntity);

        var triagemDTO = new TriagemDTO(
                triagemEntity.getIdTriagem(),
                triagemEntity.getPaciente(),
                triagemEntity.getResponsavel(),
                anamneseDTO,
                avalicaoDTO
        );

        var usuarioDTO = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getDataNascimento().toString(),
                usuario.getTipo().toString(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getTell()
        );

        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                null,
                triagemDTO,
                LocalDate.now().toString(),
                "Alterar a triagem para usuario " + usuarioDTO.username()
        );
        mensageria.sendHistorico(mensagemEnviada);
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
