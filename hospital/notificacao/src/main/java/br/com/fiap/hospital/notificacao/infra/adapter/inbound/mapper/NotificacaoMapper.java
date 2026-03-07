package br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.notificacao.*;
import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.notificacao.application.domain.NotificacaoFactory;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;

import java.util.UUID;

public class NotificacaoMapper implements INotificacaoMapper {
    private final NotificacaoFactory factory;

    public NotificacaoMapper(NotificacaoFactory factory) {
        this.factory = factory;
    }

    public Notificacao enviarRequestToDomain (EnviarRequest request) {
        return factory.newNotificacao(
                null,
                Categoria.valueOf(request.getCategoria()),
                null,
                null,
                request.getNome(),
                request.getEmail(),
                request.getTell());
    }

    public Notificacao receberRequestToDomain (ReceberRequest request) {
        return factory.newNotificacao(
            null,
            Categoria.RETORNO,
            null,
            null,
            request.getNome(),
            request.getEmail(),
            request.getTell());
    }

    public Response domainToResponse (Notificacao notificacao) {
        return Response.newBuilder()
                .setIdMensagem(notificacao.getIdMensagem())
                .setCategoria(notificacao.getCategoria().name())
                .setTitulo(notificacao.getTitulo())
                .setMensagem(notificacao.getMensagem())
                .setNome(notificacao.getNome())
                .setEmail(notificacao.getEmail())
                .setTell(notificacao.getTell())
                .build();
    }
    public NotificacaoEntity domainToEntity (Notificacao notificacao) {
        return new NotificacaoEntity(
                notificacao.getCategoria().name(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getNome(),
                notificacao.getEmail(),
                notificacao.getTell()
        );
    }
    public Notificacao entityToDomain (NotificacaoEntity entity) {
        return factory.newNotificacao(
                entity.getIdMensagem(),
                Categoria.valueOf(entity.getCategoria()),
                entity.getTitulo(),
                entity.getMensagem(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTell()
        );
    }

}
