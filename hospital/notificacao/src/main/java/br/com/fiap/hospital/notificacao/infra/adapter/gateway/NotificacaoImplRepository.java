package br.com.fiap.hospital.notificacao.infra.adapter.gateway;

import br.com.fiap.hospital.notificacao.*;
import br.com.fiap.hospital.notificacao.infra.adapter.gateway.handler.NotificacaoHandler;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class NotificacaoImplRepository extends NotificacaoGrpc.NotificacaoImplBase {
    private final NotificacaoHandler handler;
    private final INotificacaoMapper mapper;

    public NotificacaoImplRepository(NotificacaoHandler handler, INotificacaoMapper mapper) {
        this.handler = handler;
        this.mapper = mapper;
    }

    @Override
    public void enviar(EnviarRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.enviar(mapper.enviarRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }

    @Override
    public void receber(ReceberRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.receber(mapper.receberRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }
}
