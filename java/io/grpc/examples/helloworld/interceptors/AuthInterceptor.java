package io.grpc.examples.helloworld.interceptors;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import javax.inject.Inject;

public class AuthInterceptor implements ServerInterceptor {

  @Inject
  public AuthInterceptor() {}

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
      ServerCallHandler<ReqT, RespT> next) {
    return next.startCall(call, headers);
  }
}
