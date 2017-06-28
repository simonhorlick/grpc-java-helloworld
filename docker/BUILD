package(default_visibility = ["//visibility:public"])

load("@bazel_tools//tools/build_defs/docker:docker.bzl", "docker_build")

# The base layer, a debian jessie rootfs.
docker_build(
    name = "jessie",
    tars = ["@com_github_tianon_docker_brew_debian//file"],
)

docker_build(
    name = "grpc_web_proxy_container",
    base = ":jessie",
    data_path = "/",
    entrypoint = [
        "com_github_improbable_eng_grpc_web/go/grpcwebproxy/grpcwebproxy",
    ],
    files = [
        "@com_github_improbable_eng_grpc_web//go/grpcwebproxy:grpcwebproxy",
    ],
)
