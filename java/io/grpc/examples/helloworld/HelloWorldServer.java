package io.grpc.examples.helloworld;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.grpc.server.ForGrpcService;
import dagger.grpc.server.NettyServerModule;
import io.grpc.Server;
import io.grpc.ServerInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Singleton;

/** Server that manages startup/shutdown of a {@link Hello} server. */
public class HelloWorldServer {

  private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

  @Module
  abstract static class HelloServiceGrpcModule {

    @Binds
    abstract HelloServiceDefinition provideHelloServiceDefinition(ServerComponent serverComponent);

    @Provides
    @ForGrpcService(HelloServiceGrpc.class)
    static List<? extends ServerInterceptor> provideHelloInterceptors() {
      return new ArrayList<>();
    }
  }

  /** The component used to construct a Server to listen for {@link HelloServiceGrpc} rpcs. */
  @Singleton
  @Component(
    modules = {
      HelloUnscopedGrpcServiceModule.class,
      HelloServiceGrpcModule.class,
      NettyServerModule.class,
    }
  )
  interface ServerComponent extends HelloServiceDefinition {
    Server server();
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ServerFlags flags = ServerFlags.parse(Arrays.asList(args));
    try {
      logger.info("Starting rpc server on port " + flags.getPort());
      DaggerHelloWorldServer_ServerComponent.builder()
            .nettyServerModule(NettyServerModule.bindingToPort(flags.getPort()))
            .build()
            .server()
            .start()
            .awaitTermination();
    } catch (InterruptedException e) {
      logger.info("Stopping rpc server");
    }
  }
}
