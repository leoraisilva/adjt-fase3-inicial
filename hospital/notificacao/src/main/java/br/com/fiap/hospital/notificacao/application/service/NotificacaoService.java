package br.com.fiap.hospital.notificacao.application.service;

import br.com.fiap.hospital.notificacao.application.useCase.NotificacaoPort;
import br.com.fiap.hospital.notificacao.application.useCase.enviar.EnviarInput;
import br.com.fiap.hospital.notificacao.application.useCase.enviar.EnviarOutput;
import br.com.fiap.hospital.notificacao.application.useCase.receber.ReceberOutput;

public class NotificacaoService implements NotificacaoPort {
    @Override
    public EnviarOutput enviar(EnviarInput input) {
        return null;
    }

    @Override
    public ReceberOutput receber(String idMensagem) {
        return null;
    }
}
