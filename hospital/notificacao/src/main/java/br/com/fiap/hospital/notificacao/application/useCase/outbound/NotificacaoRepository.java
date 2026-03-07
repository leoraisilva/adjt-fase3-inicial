package br.com.fiap.hospital.notificacao.application.useCase.outbound;

import br.com.fiap.hospital.notificacao.application.domain.Notificacao;

public interface NotificacaoRepository {
    Notificacao enviar (Notificacao notificacao);
    Notificacao receber (Notificacao notificacao);
}
