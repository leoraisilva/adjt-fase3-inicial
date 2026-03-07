package br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.notificacao.EnviarRequest;
import br.com.fiap.hospital.notificacao.ReceberRequest;
import br.com.fiap.hospital.notificacao.Response;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity.NotificacaoEntity;

public interface INotificacaoMapper {
    Notificacao receberRequestToDomain (ReceberRequest request);
    Notificacao enviarRequestToDomain (EnviarRequest request);
    Response domainToResponse (Notificacao notificacao);
    NotificacaoEntity domainToEntity (Notificacao notificacao);
    Notificacao entityToDomain (NotificacaoEntity entity);

}
