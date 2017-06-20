package io.grpc.examples.helloworld;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.grpc.server.ForGrpcService;
import dagger.grpc.server.NettyServerModule;
import io.grpc.Server;
import io.grpc.ServerInterceptor;
import io.grpc.examples.helloworld.interceptors.AuthInterceptor;
import io.grpc.examples.helloworld.interceptors.LoggingInterceptor;
import java.util.Arrays;
import java.util.List;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    HelloUnscopedGrpcServiceModule.class,
    MyModule.class,
    NettyServerModule.class,
})
interface MyComponent extends HelloServiceDefinition {
  /* Dagger implements this interface by providing a NettyServer. */
  Server server();
}

@Module
abstract class MyModule {

  @Binds
  abstract HelloServiceDefinition helloComponent(MyComponent myComponent);

  @Provides
  @ForGrpcService(HelloServiceGrpc.class)
  static List<? extends ServerInterceptor> helloInterceptors(
      AuthInterceptor authInterceptor,
      LoggingInterceptor loggingInterceptor) {
    return Arrays.asList(authInterceptor, loggingInterceptor);
  }
}