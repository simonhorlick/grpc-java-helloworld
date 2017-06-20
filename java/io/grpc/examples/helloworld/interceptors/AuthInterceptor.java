package io.grpc.examples.helloworld.interceptors;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import javax.inject.Inject;

public class AuthInterceptor implements ServerInterceptor {

  public static final Metadata.Key<String> AUTHORISATION =
      Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

  @Inject
  public AuthInterceptor() {}

  @Override
  public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
      ServerCallHandler<ReqT, RespT> next) {

    String authorisationHeader = headers.get(AUTHORISATION);
    if (authorisationHeader == null) {
      System.err.println("Token not supplied");
      return closeCall(Status.UNAUTHENTICATED, call);
    }

    // Ensure we're actually dealing with a bearer token.
    if (!authorisationHeader.startsWith("Bearer ")) {
      return closeCall(Status.UNAUTHENTICATED, call);
    }

    return next.startCall(call, headers);
  }

  // Close the current call with the provided status.
  private <ReqT, RespT> ServerCall.Listener<ReqT> closeCall(
      Status status, ServerCall<ReqT, RespT> serverCall) {
    serverCall.close(status, new Metadata());

    // Return an empty listener as we've already already closed the channel and don't care about
    // further messages.
    return new ServerCall.Listener<ReqT>() {};
  }
}
