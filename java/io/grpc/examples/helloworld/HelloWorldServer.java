/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc.examples.helloworld;

import com.google.common.collect.ImmutableList;
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
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Singleton;

/**
 * Server that manages startup/shutdown of a {@link Hello} server.
 */
public class HelloWorldServer {

  private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());

  static class CommandLineFlags {
    private final int port;

    private CommandLineFlags(int port) {
      this.port = port;
    }

    int getPort() {
      return port;
    }

    static CommandLineFlags parse(ImmutableList<String> args) {
      int port = 50051;
      // TODO(simon): Parse command line args.
      return new CommandLineFlags(port);
    }
  }

  @Module
  static abstract class HelloServiceGrpcModule {

    @Binds
    abstract HelloServiceDefinition provideHelloServiceDefinition(
        ServerComponent serverComponent);

    @Provides
    @ForGrpcService(HelloServiceGrpc.class)
    static List<? extends ServerInterceptor> provideHelloInterceptors() {
      return new ArrayList<>();
    }

  }

  /** The component used to construct a Server to listen for {@link HelloServiceGrpc} rpcs. */
  @Singleton
  @Component(modules = {
      HelloUnscopedGrpcServiceModule.class,
      HelloServiceGrpcModule.class,
      NettyServerModule.class,
  })
  interface ServerComponent extends HelloServiceDefinition {
    Server server();
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    // Parse any command line flags.
    CommandLineFlags flags = CommandLineFlags.parse(ImmutableList.copyOf(args));

    // Create any necessary dagger modules.
    NettyServerModule nettyServerModule = NettyServerModule.bindingToPort(flags.getPort());

    ServerComponent component = DaggerHelloWorldServer_ServerComponent.builder()
            .nettyServerModule(nettyServerModule)
            .build();
    Server server = component.server();
    server.start();
    logger.info("Starting rpc server on port " + flags.getPort());
    try {
      server.awaitTermination();
    } catch(InterruptedException e) {
      logger.info("Stopping rpc server");
    }
  }

}
