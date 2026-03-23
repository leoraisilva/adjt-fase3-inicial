package br.com.fiap.hospital.notificacao.infra.adapter.gateway.handler;

import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
import br.com.fiap.hospital.mensageria.event.NotificacaoDTO;
import br.com.fiap.hospital.mensageria.event.UsuarioDTO;
import br.com.fiap.hospital.mensageria.producer.MensageriaEventProducer;
import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.notificacao.application.useCase.outbound.NotificacaoRepository;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.repository.NotificacaoJpaRepository;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class NotificacaoHandler implements NotificacaoRepository {
    private final NotificacaoJpaRepository notificacaoJpaRepository;
    private final UsuarioJPARepository usuarioJPARepository;
    private final INotificacaoMapper mapper;
    private final MensageriaEventProducer mensageria;

    public NotificacaoHandler(NotificacaoJpaRepository notificacaoJpaRepository, UsuarioJPARepository usuarioJPARepository, INotificacaoMapper mapper, MensageriaEventProducer mensageria) {
        this.notificacaoJpaRepository = notificacaoJpaRepository;
        this.usuarioJPARepository = usuarioJPARepository;
        this.mapper = mapper;
        this.mensageria = mensageria;
    }


    @Override
    public Notificacao consulta(Notificacao notificacao) {
        var entity = new NotificacaoEntity();
        entity.setIdMensagem(UUID.randomUUID().toString());
        entity.setCategoria(notificacao.getCategoria().name());
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Consulta " + entity.getCategoria() + " marcado para " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente a consulta " + entity.getCategoria() + ", estamos confirmando.\n" +
                "Agradecemos e aguardamos ansiosamente pela consulta!!");
        entity = notificacaoJpaRepository.save(entity);
        var mensagemNotificacao = new NotificacaoDTO(
                entity.getIdMensagem(),
                entity.getCategoria(),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTell()
        );
        var usuarioEntity = usuarioJPARepository.findByUsername(entity.getNome());
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
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                mensagemNotificacao,
                null,
                LocalDate.now().toString(),
                "Enviando Mensagem " + notificacao.getCategoria().toString() + " ao usuario " + usuarioDTO.username()
        );
        mensageria.sendHistorico(mensagemEnviada);
        return mapper.entityToDomain(entity);
    }

    @Override
    public Notificacao retorno(Notificacao notificacao) {
        var entity = new NotificacaoEntity();
        entity.setIdMensagem(UUID.randomUUID().toString());
        entity.setCategoria(Categoria.RETORNO.name());
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Retorno Consulta de " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente a retorno da consulta feita. \n" +
                "Agradecemos e aguardamos ansiosamente pela retorno!!");
        var mensagemNotificacao = new NotificacaoDTO(
                entity.getIdMensagem(),
                entity.getCategoria(),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTell()
        );
        var usuarioEntity = usuarioJPARepository.findByUsername(entity.getNome());
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
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                mensagemNotificacao,
                null,
                LocalDate.now().toString(),
                "Enviando Mensagem " + notificacao.getCategoria().toString() + " ao usuario " + usuarioDTO.username()
        );
        mensageria.sendHistorico(mensagemEnviada);
        return mapper.entityToDomain(entity);
    }

    @Override
    public Notificacao cancelamento(Notificacao notificacao) {
        var entity = new NotificacaoEntity();
        entity.setIdMensagem(UUID.randomUUID().toString());
        entity.setCategoria(Categoria.RETORNO.name());
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Cancelamento Consulta de " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente ao Cancelametno da consulta feita. \n" +
                "Consulta Cancelado com sucesso" +
                "Agradecemos e aguardamos ansiosamente pelas proximas consultas!!");
        entity = notificacaoJpaRepository.save(entity);
        var mensagemNotificacao = new NotificacaoDTO(
                entity.getIdMensagem(),
                entity.getCategoria(),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTell()
        );
        var usuarioEntity = usuarioJPARepository.findByUsername(entity.getNome());
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
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                mensagemNotificacao,
                null,
                LocalDate.now().toString(),
                "Enviando Mensagem " + notificacao.getCategoria().toString() + " ao usuario " + usuarioDTO.username()
        );
        mensageria.sendHistorico(mensagemEnviada);
        return mapper.entityToDomain(entity);
    }

    @Override
    public Notificacao triagem(Notificacao notificacao) {
        var entity = new NotificacaoEntity();
        entity.setIdMensagem(UUID.randomUUID().toString());
        entity.setCategoria(Categoria.RETORNO.name());
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Triagem para " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente a Triagem que precisa ser feito. \n" +
                "Gostaria que procurasse posto de saúde ou entrar em contato com a Enfermagem" +
                "Agradecemos e aguardamos a sua resposta!!");
        var mensagemNotificacao = new NotificacaoDTO(
                entity.getIdMensagem(),
                entity.getCategoria(),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTell()
        );
        var usuarioEntity = usuarioJPARepository.findByUsername(entity.getNome());
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
        var mensagemEnviada = new HistoricoDTO(
                usuarioDTO,
                null,
                mensagemNotificacao,
                null,
                LocalDate.now().toString(),
                "Enviando Mensagem " + notificacao.getCategoria().toString() + " ao usuario " + usuarioDTO.username()
        );
        mensageria.sendHistorico(mensagemEnviada);
        return mapper.entityToDomain(entity);
    }
}
