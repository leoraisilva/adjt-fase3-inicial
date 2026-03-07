package br.com.fiap.hospital.notificacao;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: notificacao.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotificacaoGrpc {

  private NotificacaoGrpc() {}

  public static final java.lang.String SERVICE_NAME = "notificacao.Notificacao";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.EnviarRequest,
      br.com.fiap.hospital.notificacao.Response> getEnviarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Enviar",
      requestType = br.com.fiap.hospital.notificacao.EnviarRequest.class,
      responseType = br.com.fiap.hospital.notificacao.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.EnviarRequest,
      br.com.fiap.hospital.notificacao.Response> getEnviarMethod() {
    io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.EnviarRequest, br.com.fiap.hospital.notificacao.Response> getEnviarMethod;
    if ((getEnviarMethod = NotificacaoGrpc.getEnviarMethod) == null) {
      synchronized (NotificacaoGrpc.class) {
        if ((getEnviarMethod = NotificacaoGrpc.getEnviarMethod) == null) {
          NotificacaoGrpc.getEnviarMethod = getEnviarMethod =
              io.grpc.MethodDescriptor.<br.com.fiap.hospital.notificacao.EnviarRequest, br.com.fiap.hospital.notificacao.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Enviar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.fiap.hospital.notificacao.EnviarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.fiap.hospital.notificacao.Response.getDefaultInstance()))
              .setSchemaDescriptor(new NotificacaoMethodDescriptorSupplier("Enviar"))
              .build();
        }
      }
    }
    return getEnviarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.ReceberRequest,
      br.com.fiap.hospital.notificacao.Response> getReceberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Receber",
      requestType = br.com.fiap.hospital.notificacao.ReceberRequest.class,
      responseType = br.com.fiap.hospital.notificacao.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.ReceberRequest,
      br.com.fiap.hospital.notificacao.Response> getReceberMethod() {
    io.grpc.MethodDescriptor<br.com.fiap.hospital.notificacao.ReceberRequest, br.com.fiap.hospital.notificacao.Response> getReceberMethod;
    if ((getReceberMethod = NotificacaoGrpc.getReceberMethod) == null) {
      synchronized (NotificacaoGrpc.class) {
        if ((getReceberMethod = NotificacaoGrpc.getReceberMethod) == null) {
          NotificacaoGrpc.getReceberMethod = getReceberMethod =
              io.grpc.MethodDescriptor.<br.com.fiap.hospital.notificacao.ReceberRequest, br.com.fiap.hospital.notificacao.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Receber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.fiap.hospital.notificacao.ReceberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.fiap.hospital.notificacao.Response.getDefaultInstance()))
              .setSchemaDescriptor(new NotificacaoMethodDescriptorSupplier("Receber"))
              .build();
        }
      }
    }
    return getReceberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotificacaoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificacaoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificacaoStub>() {
        @java.lang.Override
        public NotificacaoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificacaoStub(channel, callOptions);
        }
      };
    return NotificacaoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificacaoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificacaoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificacaoBlockingStub>() {
        @java.lang.Override
        public NotificacaoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificacaoBlockingStub(channel, callOptions);
        }
      };
    return NotificacaoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotificacaoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificacaoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificacaoFutureStub>() {
        @java.lang.Override
        public NotificacaoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificacaoFutureStub(channel, callOptions);
        }
      };
    return NotificacaoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void enviar(br.com.fiap.hospital.notificacao.EnviarRequest request,
        io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnviarMethod(), responseObserver);
    }

    /**
     */
    default void receber(br.com.fiap.hospital.notificacao.ReceberRequest request,
        io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Notificacao.
   */
  public static abstract class NotificacaoImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return NotificacaoGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Notificacao.
   */
  public static final class NotificacaoStub
      extends io.grpc.stub.AbstractAsyncStub<NotificacaoStub> {
    private NotificacaoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificacaoStub(channel, callOptions);
    }

    /**
     */
    public void enviar(br.com.fiap.hospital.notificacao.EnviarRequest request,
        io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnviarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receber(br.com.fiap.hospital.notificacao.ReceberRequest request,
        io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Notificacao.
   */
  public static final class NotificacaoBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotificacaoBlockingStub> {
    private NotificacaoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificacaoBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.fiap.hospital.notificacao.Response enviar(br.com.fiap.hospital.notificacao.EnviarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnviarMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.fiap.hospital.notificacao.Response receber(br.com.fiap.hospital.notificacao.ReceberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Notificacao.
   */
  public static final class NotificacaoFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotificacaoFutureStub> {
    private NotificacaoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificacaoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificacaoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.fiap.hospital.notificacao.Response> enviar(
        br.com.fiap.hospital.notificacao.EnviarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnviarMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.fiap.hospital.notificacao.Response> receber(
        br.com.fiap.hospital.notificacao.ReceberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENVIAR = 0;
  private static final int METHODID_RECEBER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENVIAR:
          serviceImpl.enviar((br.com.fiap.hospital.notificacao.EnviarRequest) request,
              (io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response>) responseObserver);
          break;
        case METHODID_RECEBER:
          serviceImpl.receber((br.com.fiap.hospital.notificacao.ReceberRequest) request,
              (io.grpc.stub.StreamObserver<br.com.fiap.hospital.notificacao.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getEnviarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              br.com.fiap.hospital.notificacao.EnviarRequest,
              br.com.fiap.hospital.notificacao.Response>(
                service, METHODID_ENVIAR)))
        .addMethod(
          getReceberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              br.com.fiap.hospital.notificacao.ReceberRequest,
              br.com.fiap.hospital.notificacao.Response>(
                service, METHODID_RECEBER)))
        .build();
  }

  private static abstract class NotificacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificacaoBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.fiap.hospital.notificacao.NotificacaoOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Notificacao");
    }
  }

  private static final class NotificacaoFileDescriptorSupplier
      extends NotificacaoBaseDescriptorSupplier {
    NotificacaoFileDescriptorSupplier() {}
  }

  private static final class NotificacaoMethodDescriptorSupplier
      extends NotificacaoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NotificacaoMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NotificacaoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificacaoFileDescriptorSupplier())
              .addMethod(getEnviarMethod())
              .addMethod(getReceberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
