package br.com.fiap.hospital.historico.infra.adapter.gateway;

import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository.AgendamentoJPARepository;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.historico.application.useCase.outbound.HistoricoRepository;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.IHistoricoMapper;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity.HistoricoEntity;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.repository.HistoricoJpaRepository;
import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
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
                    var usuario = usuarioRepository.findByUsername(paciente);
                    var usuarioDomain = pacienteMapper.toDomain(usuario);

                    TriagemEntity triagem = null;
                    if (h.getTriagem() != null) {
                        triagem = triagemRepository.findById(h.getTriagem()).orElse(null);
                    }

                    AnamneseEntity anamnese = null;
                    if (triagem != null && triagem.getIdAnamnese() != null) {
                        anamnese = anamneseRepository.findById(triagem.getIdAnamnese()).orElse(null);
                    }

                    AvaliacaoEntity avaliacao = null;
                    if (triagem != null && triagem.getIdAvaliacao() != null) {
                        avaliacao = avaliacaoRepository.findById(triagem.getIdAvaliacao()).orElse(null);
                    }

                    var triagemDomain = triagem != null
                            ? triagemMapper.toDomain(triagem, avaliacao, anamnese)
                            : null;

                    NotificacaoEntity notificacao = null;
                    if (h.getMensagem() != null) {
                        notificacao = notificacaoRepository.findById(h.getMensagem()).orElse(null);
                    }
                    var notificacaoDomain = notificacao != null
                            ? mensagemMapper.entityToDomain(notificacao)
                            : null;

                    AgendamentoEntity consulta = null;
                    if (h.getConsulta() != null) {
                        consulta = agendamentoRepository.findById(h.getConsulta()).orElse(null);
                    }
                    var consultaDomain = consulta != null
                            ? agendamentoMapper.toDomain(consulta)
                            : null;

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

    public void registrar(HistoricoDTO historico) {

        var usuario = historico.usuario() != null &&
                historico.usuario().username() != null
                ? usuarioRepository.findByUsername(historico.usuario().username())
                : null;

        var triagem = historico.triagem() != null &&
                historico.triagem().idTriagem() != null
                ? triagemRepository.findById(historico.triagem().idTriagem()).orElse(null)
                : null;

        var notificacao = historico.notificacao() != null &&
                historico.notificacao().idMensagem() != null
                ? notificacaoRepository.findById(historico.notificacao().idMensagem()).orElse(null)
                : null;

        var consulta = historico.agendamento() != null &&
                historico.agendamento().idAgendamento() != null
                ? agendamentoRepository.findById(historico.agendamento().idAgendamento()).orElse(null)
                : null;

        var historicoEntity = new HistoricoEntity(
                historico.usuario().username(),
                consulta != null ? historico.agendamento().idAgendamento() : null,
                notificacao != null ? historico.notificacao().idMensagem(): null,
                triagem != null ? historico.triagem().idTriagem() : null,
                historico.dataRegistro(),
                historico.resultado()
        );

        repository.save(historicoEntity);
    }
}
