package io.grpc.examples.helloworld;

import dagger.Component;
import dagger.grpc.server.NettyServerModule;
import io.grpc.Server;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    HelloUnscopedGrpcServiceModule.class,
    MyModule.class,
    NettyServerModule.class,
})
interface MyComponent extends HelloServiceDefinition {
  Server server();
}