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
        "@grpc_java//:grpc-java",
        "@grpc_java//:grpc-okhttp",
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
    srcs = ["HelloWorldServer.java"],
    deps = [
        ":helloworld_java_grpc",
        ":helloworld_java_proto",
        "@grpc_java//:grpc-java",
    ],
)

java_binary(
    name = "HelloWorldServer",
    runtime_deps = [
        ":server",
        "@grpc_java//:grpc-netty",
    ],
)
