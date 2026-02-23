package application.useCase;

import application.useCase.enviar.EnviarInput;
import application.useCase.enviar.EnviarOutput;
import application.useCase.receber.ReceberOutput;

public interface NotificacaoPort {
    EnviarOutput enviar (EnviarInput input);
    ReceberOutput receber (String idMensagem);
}
