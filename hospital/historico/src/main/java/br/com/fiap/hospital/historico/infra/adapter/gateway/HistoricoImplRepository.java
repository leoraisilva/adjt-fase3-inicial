package br.com.fiap.hospital.historico.infra.adapter.gateway;

import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository.AgendamentoJPARepository;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.historico.application.useCase.outbound.HistoricoRepository;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.IHistoricoMapper;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.repository.HistoricoJpaRepository;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.repository.NotificacaoJpaRepository;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.ITriagemMapper;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AnamneseEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.AvaliacaoEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity.TriagemEntity;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AnamneseJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AvaliacaoJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.TriagemJPARepository;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.IUsuarioMapper;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class HistoricoImplRepository implements HistoricoRepository {
    private final HistoricoJpaRepository repository;
    private final UsuarioJPARepository usuarioRepository;
    private final TriagemJPARepository triagemRepository;
    private final NotificacaoJpaRepository notificacaoRepository;
    private final AgendamentoJPARepository agendamentoRepository;
    private final AvaliacaoJPARepository avaliacaoRepository;
    private final AnamneseJPARepository anamneseRepository;
    private final INotificacaoMapper mensagemMapper;
    private final IUsuarioMapper pacienteMapper;
    private final ITriagemMapper triagemMapper;
    private final IAgendamentoMapper agendamentoMapper;
    private final IHistoricoMapper historicoMapper;

    public HistoricoImplRepository(HistoricoJpaRepository repository, UsuarioJPARepository usuarioRepository, TriagemJPARepository triagemRepository, NotificacaoJpaRepository notificacaoRepository, AgendamentoJPARepository agendamentoRepository, AvaliacaoJPARepository avaliacaoRepository, AnamneseJPARepository anamneseRepository, INotificacaoMapper mensagemMapper, IUsuarioMapper pacienteMapper, ITriagemMapper triagemMapper, IAgendamentoMapper agendamentoMapper, IHistoricoMapper historicoMapper) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.triagemRepository = triagemRepository;
        this.notificacaoRepository = notificacaoRepository;
        this.agendamentoRepository = agendamentoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
        this.anamneseRepository = anamneseRepository;
        this.mensagemMapper = mensagemMapper;
        this.pacienteMapper = pacienteMapper;
        this.triagemMapper = triagemMapper;
        this.agendamentoMapper = agendamentoMapper;
        this.historicoMapper = historicoMapper;
    }

    @Override
    public List<Historico> acessarHistorico(String paciente) {
        return repository.findAll().stream()
                .filter(h -> Objects.equals(h.getPaciente(), paciente))
                .map(h -> {
                    var usuario = usuarioRepository.findByUsername(h.getPaciente());
                    var usuarioDomain = pacienteMapper.toDomain(usuario);
                    var triagem = triagemRepository.findById(h.getTriagem()).orElseGet(TriagemEntity::new);
                    var anamnese = anamneseRepository.findById(triagem.getIdAnamnese()).orElseGet(AnamneseEntity::new);
                    var avaliacao = avaliacaoRepository.findById(triagem.getIdAvaliacao()).orElseGet(AvaliacaoEntity::new);
                    var triagemDomain = triagemMapper.toDomain(triagem, avaliacao, anamnese);
                    var notificacao = notificacaoRepository.findById(h.getMensagem()).orElseGet(NotificacaoEntity::new);
                    var notificacaoDomain = mensagemMapper.entityToDomain(notificacao);
                    var consulta = agendamentoRepository.findById(h.getConsulta_id()).orElseGet(AgendamentoEntity::new);
                    var consultaDomain = agendamentoMapper.toDomain(consulta);

                    return historicoMapper.toDomain(
                            h,
                            usuarioDomain,
                            consultaDomain,
                            notificacaoDomain,
                            triagemDomain
                    );
                })
                .toList();
    }
}
