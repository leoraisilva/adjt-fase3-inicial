package br.com.fiap.hospital.agendamento.infra.adapter.gateway;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;
import br.com.fiap.hospital.agendamento.application.useCase.outbound.AgendamentoRepository;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository.AgendamentoJPARepository;
import br.com.fiap.hospital.mensageria.event.MensagemDTO;
import br.com.fiap.hospital.mensageria.producer.EventoProducer;
import br.com.fiap.hospital.mensageria.event.AgendamentoDTO;
import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
import br.com.fiap.hospital.mensageria.event.UsuarioDTO;
import br.com.fiap.hospital.mensageria.producer.MensageriaEventProducer;
import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AgendamentoImplRepository implements AgendamentoRepository {
    private final AgendamentoJPARepository jpaRepository;
    private final IAgendamentoMapper mapper;
    private final AgendamentoFactory factory;
    private final MensageriaEventProducer mensageria;
    private final UsuarioJPARepository usuarioJPARepository;
    private final EventoProducer evento;

    public AgendamentoImplRepository(AgendamentoJPARepository jpaRepository, IAgendamentoMapper mapper, AgendamentoFactory factory, MensageriaEventProducer mensageria, UsuarioJPARepository usuarioJPARepository, EventoProducer evento) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
        this.factory = factory;
        this.mensageria = mensageria;
        this.usuarioJPARepository = usuarioJPARepository;
        this.evento = evento;
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        var agendamentoEntity = jpaRepository.save(mapper.toEntity(agendamento));
        var usuarioEntity = usuarioJPARepository.findByUsername(agendamento.getPaciente());
        var usuarioDTO = new UsuarioDTO(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getNome(),
                usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                usuarioEntity.getDataNascimento().toString(),
                usuarioEntity.getTipo().toString(),
                usuarioEntity.getCPF(),
                usuarioEntity.getEmail(),
                usuarioEntity.getTell()
        );
        var agendamentoDTO = new AgendamentoDTO(
                agendamentoEntity.getIdAgendamento(),
                agendamentoEntity.getPaciente(),
                agendamentoEntity.getConsulta().toString(),
                agendamentoEntity.getResponsavel(),
                agendamentoEntity.getDataConsulta(),
                agendamentoEntity.isReagendavel(),
                agendamentoEntity.isTriagem()
        );
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                agendamentoDTO,
                null,
                null,
                LocalDate.now().toString(),
                "Criar agendamento para usuario " + usuarioDTO.username()
        );
        var eventoMensagem = new MensagemDTO(
                usuarioDTO.username(),
                usuarioDTO.email(),
                usuarioDTO.tell(),
                agendamentoEntity.isTriagem() ?  Categoria.CONSULTA.name() : Categoria.TRIAGEM.name()
        );

        mensageria.sendHistorico(mensagemEnviada);
        evento.enviar(eventoMensagem);
        return mapper.toDomain(agendamentoEntity);
    }

    @Override
    public Agendamento findById(String idAgendamento) {
        var optionalAgendamento = jpaRepository.findById(idAgendamento).orElseThrow(() -> new RuntimeException("Agendamento não localizado"));
        return mapper.toDomain(optionalAgendamento);
    }

    @Override
    public Agendamento delete(String idAgendamento) {
        var agendamentoEntity = jpaRepository.findById(idAgendamento).orElseThrow(() -> new RuntimeException("Agendamento não localizado"));
        agendamentoEntity.setConsulta(ConsultaType.CANCELADO);
        var usuarioEntity = usuarioJPARepository.findByUsername(agendamentoEntity.getPaciente());
        var usuarioDTO = new UsuarioDTO(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getNome(),
                usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                usuarioEntity.getDataNascimento().toString(),
                usuarioEntity.getTipo().toString(),
                usuarioEntity.getCPF(),
                usuarioEntity.getEmail(),
                usuarioEntity.getTell()
        );
        var agendamentoDTO = new AgendamentoDTO(
                agendamentoEntity.getIdAgendamento(),
                agendamentoEntity.getPaciente(),
                agendamentoEntity.getConsulta().toString(),
                agendamentoEntity.getResponsavel(),
                agendamentoEntity.getDataConsulta(),
                agendamentoEntity.isReagendavel(),
                agendamentoEntity.isTriagem()
        );
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                agendamentoDTO,
                null,
                null,
                LocalDate.now().toString(),
                "Cancelar agendamento para usuario " + usuarioDTO.username()
        );

        var eventoMensagem = new MensagemDTO(
                usuarioDTO.username(),
                usuarioDTO.email(),
                usuarioDTO.tell(),
                Categoria.CANCELADO.name()
        );

        mensageria.sendHistorico(mensagemEnviada);
        evento.enviar(eventoMensagem);
        return mapper.toDomain(jpaRepository.save(agendamentoEntity));
    }

    @Override
    public Agendamento update(Agendamento agendamento) {
        var agendamentoEntity = jpaRepository.findById(agendamento.getIdAgendamento()).orElseGet(AgendamentoEntity::new);
        agendamentoEntity.setConsulta(agendamento.getConsulta());
        agendamentoEntity.setPaciente(agendamento.getPaciente());
        agendamentoEntity.setReagendavel(agendamento.isReagendavel());
        agendamentoEntity.setResponsavel(agendamento.getResponsavel());
        agendamentoEntity.setTriagem(agendamento.isTriagem());
        agendamentoEntity.setDataConsulta(agendamento .getDataConsulta());
        var usuarioEntity = usuarioJPARepository.findByUsername(agendamentoEntity.getPaciente());
        var usuarioDTO = new UsuarioDTO(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getNome(),
                usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                usuarioEntity.getDataNascimento().toString(),
                usuarioEntity.getTipo().toString(),
                usuarioEntity.getCPF(),
                usuarioEntity.getEmail(),
                usuarioEntity.getTell()
        );
        var agendamentoDTO = new AgendamentoDTO(
                agendamentoEntity.getIdAgendamento(),
                agendamentoEntity.getPaciente(),
                agendamentoEntity.getConsulta().toString(),
                agendamentoEntity.getResponsavel(),
                agendamentoEntity.getDataConsulta(),
                agendamentoEntity.isReagendavel(),
                agendamentoEntity.isTriagem()
        );
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                agendamentoDTO,
                null,
                null,
                LocalDate.now().toString(),
                "Alterar agendamento para usuario " + usuarioDTO.username()
        );

        var eventoMensagem = new MensagemDTO(
                usuarioDTO.username(),
                usuarioDTO.email(),
                usuarioDTO.tell(),
                agendamentoEntity.isReagendavel() ? Categoria.RETORNO.name() : Categoria.CONSULTA.name()
        );

        evento.enviar(eventoMensagem);
        mensageria.sendHistorico(mensagemEnviada);
        return mapper.toDomain(jpaRepository.save(agendamentoEntity));
    }

    @Override
    public List<Agendamento> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
