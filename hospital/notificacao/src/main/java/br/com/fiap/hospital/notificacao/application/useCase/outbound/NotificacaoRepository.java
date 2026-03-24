package br.com.fiap.hospital.notificacao.application.useCase.outbound;

import br.com.fiap.hospital.notificacao.EnviarRequest;
import br.com.fiap.hospital.notificacao.ReceberRequest;
import br.com.fiap.hospital.notificacao.Response;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import io.grpc.stub.StreamObserver;

public interface NotificacaoRepository {
    Notificacao cancelamento (Notificacao notificacao);
    Notificacao retorno (Notificacao notificacao);
    Notificacao consulta(Notificacao notificacao);
    Notificacao triagem(Notificacao notificacao);

}
