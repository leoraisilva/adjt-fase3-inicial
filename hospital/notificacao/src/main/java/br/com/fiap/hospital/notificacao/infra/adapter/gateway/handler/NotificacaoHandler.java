package br.com.fiap.hospital.notificacao.infra.adapter.gateway.handler;

import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.notificacao.application.useCase.outbound.NotificacaoRepository;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.repository.NotificacaoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificacaoHandler implements NotificacaoRepository {
    private final NotificacaoJpaRepository notificacaoJpaRepository;
    private final INotificacaoMapper mapper;

    public NotificacaoHandler(NotificacaoJpaRepository notificacaoJpaRepository, INotificacaoMapper mapper) {
        this.notificacaoJpaRepository = notificacaoJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Notificacao enviar(Notificacao notificacao) {
        var entity = notificacaoJpaRepository.findByCategoria(notificacao.getCategoria().name()).orElseGet(NotificacaoEntity::new);
        if (entity.getIdMensagem() == null) {
            entity.setIdMensagem(UUID.randomUUID().toString());
        }
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Consulta " + entity.getCategoria() + " marcado para " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente a consulta " + entity.getCategoria() + ", estamos confirmando.\n" +
                "Agradecemos e aguardamos ansiosamente pela consulta!!");
        return mapper.entityToDomain(notificacaoJpaRepository.save(entity));
    }

    @Override
    public Notificacao receber(Notificacao notificacao) {
        var entity = notificacaoJpaRepository.findByCategoria(Categoria.RETORNO.name()).orElseGet(NotificacaoEntity::new);
        if (entity.getIdMensagem() == null) {
            entity.setIdMensagem(UUID.randomUUID().toString());
        }
        entity.setCategoria(Categoria.RETORNO.name());
        entity.setEmail(notificacao.getEmail());
        entity.setNome(notificacao.getNome());
        entity.setTell(notificacao.getTell());
        entity.setTitulo("Retorno Consulta de " + entity.getNome() + "!!");
        entity.setMensagem("Bom Dia " + entity.getNome() + "!\n" +
                "O motivo do nosso Contato é referente a retorno da consulta feita. \n" +
                "Agradecemos e aguardamos ansiosamente pela consulta!!");
        return mapper.entityToDomain(notificacaoJpaRepository.save(entity));
    }
}
