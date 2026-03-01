package br.com.fiap.hospital.notificacao.application.useCase;

import br.com.fiap.hospital.notificacao.application.useCase.enviar.EnviarInput;
import br.com.fiap.hospital.notificacao.application.useCase.enviar.EnviarOutput;
import br.com.fiap.hospital.notificacao.application.useCase.receber.ReceberOutput;

public interface NotificacaoPort {
    EnviarOutput enviar (EnviarInput input);
    ReceberOutput receber (String idMensagem);
}
