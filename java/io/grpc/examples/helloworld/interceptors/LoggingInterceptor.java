package io.grpc.examples.helloworld.interceptors;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import javax.inject.Inject;

public class LoggingInterceptor implements ServerInterceptor {

  @Inject
  public LoggingInterceptor() {}

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
      ServerCallHandler<ReqT, RespT> next) {
    System.out.println("Handling call to " + call.getMethodDescriptor().getFullMethodName());
    return next.startCall(call, headers);
  }
}
