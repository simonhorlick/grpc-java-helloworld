package io.grpc.examples.helloworld;

import io.grpc.examples.helloworld.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;

public class Hello extends HelloServiceImplBase {

  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloResponse> responseObserver) {
    HelloResponse reply = HelloResponse.newBuilder().setMessage("Hello " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}
