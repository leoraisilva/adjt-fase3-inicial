package application.service;

import application.useCase.NotificacaoPort;
import application.useCase.enviar.EnviarInput;
import application.useCase.enviar.EnviarOutput;
import application.useCase.receber.ReceberOutput;

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
