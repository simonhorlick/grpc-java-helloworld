package io.grpc.examples.helloworld;

import dagger.grpc.server.GrpcService;
import io.grpc.examples.helloworld.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import javax.inject.Inject;

@GrpcService(grpcClass = HelloServiceGrpc.class)
public class Hello extends HelloServiceImplBase {

  @Inject
  Hello() {}

  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloResponse> responseObserver) {
    HelloResponse reply = HelloResponse.newBuilder().setMessage("Hello " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}
