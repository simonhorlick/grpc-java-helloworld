load("@grpc_java//:java_grpc_library.bzl", "java_grpc_library")

proto_library(
    name = "helloworld_proto",
    srcs = ["helloworld.proto"],
    deps = ["@googleapis//google/api:annotations_proto"],
)

java_proto_library(
    name = "helloworld_java_proto",
    deps = [":helloworld_proto"],
)

java_grpc_library(
    name = "helloworld_java_grpc",
    srcs = [":helloworld_proto"],
    deps = [":helloworld_java_proto"],
)

java_library(
    name = "client",
    srcs = ["HelloWorldClient.java"],
    deps = [
        ":helloworld_java_grpc",
        ":helloworld_java_proto",
        "@grpc_java//core",
        "@grpc_java//okhttp",
        "@grpc_java//stub",
    ],
)

java_binary(
    name = "HelloWorldClient",
    runtime_deps = [
        ":client",
    ],
)

java_library(
    name = "server",
    srcs = [
        "Hello.java",
        "HelloWorldServer.java",
    ],
    deps = [
        ":helloworld_java_grpc",
        ":helloworld_java_proto",
        "@com_google_dagger//:dagger_with_compiler",
        "@com_google_dagger//java/dagger/grpc/server",
        "@grpc_java//core",
        "@grpc_java//netty",
        "@grpc_java//stub",
        "@com_google_guava//jar",
    ],
)

java_binary(
    name = "HelloWorldServer",
    runtime_deps = [
        ":server",
        "@io_netty_buffer//jar",
        "@io_netty_codec//jar",
        "@io_netty_codec_http//jar",
        "@io_netty_codec_http2//jar",
        "@io_netty_codec_socks//jar",
        "@io_netty_common//jar",
        "@io_netty_handler//jar",
        "@io_netty_handler_proxy//jar",
        "@io_netty_resolver//jar",
        "@io_netty_tcnative_boringssl_static//jar",
        "@io_netty_transport//jar",
    ],
)
