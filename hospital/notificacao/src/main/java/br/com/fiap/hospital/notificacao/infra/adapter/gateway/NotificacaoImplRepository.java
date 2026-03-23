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
    public void consulta(EnviarRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.consulta(mapper.enviarRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }

    @Override
    public void triagem(EnviarRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.triagem(mapper.enviarRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }

    @Override
    public void retorno(ReceberRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.retorno(mapper.receberRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }

    @Override
    public void cancelamento(EnviarRequest request, StreamObserver<Response> responseObserver) {
        var response = handler.cancelamento(mapper.enviarRequestToDomain(request));
        responseObserver.onNext(mapper.domainToResponse(response));
        responseObserver.onCompleted();
    }
}
