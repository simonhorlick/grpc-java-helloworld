package io.grpc.examples.helloworld;

import java.util.List;

/** Command line arguments for grpc server applications. */
public class ServerFlags {

  /** Builder for ServerFlags objects. */
  public static class Builder {

    private int port = 50051;

    public Builder setPort(int port) {
      this.port = port;
      return this;
    }

    public ServerFlags build() {
      return new ServerFlags(port);
    }
  }

  private final int port;

  private ServerFlags(int port) {
    this.port = port;
  }

  int getPort() {
    return port;
  }

  /**
   * Parses a command line into a ServerFlags object. Parameters are separated by spaces, for example,
   * --arg1 one --arg2 two --arg3 three
   * @param args The list of command line arguments provided to the application.
   * @return a ServerFlags object containing all of the command line arguments.
   */
  static ServerFlags parse(List<String> args) {
    Builder builder = new Builder();
    while (!args.isEmpty()) {
      String arg = args.remove(0);
      switch (arg) {
        case "--rpc_port":
          builder.setPort(Integer.parseInt(args.remove(0)));
          break;
        case "--rpc_cert_chain_file":
          break;
        case "--rpc_private_key_file":
          break;
        case "--ca_certificate":
          break;
        case "--metrics_port":
          break;
        default:
          System.err.println("Unrecognised option: " + arg);
          System.exit(1);
      }
    }

    return builder.build();
  }
}
