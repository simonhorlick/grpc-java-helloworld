local_repository(
    name = "grpc_java",
    path = "/usr/local/src/io_grpc_java",
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

git_repository(
    name = "googleapis",
    commit = "29820f9afca85b3e0ee083fc374e40de6dfa3226",
    remote = "https://github.com/simonhorlick/apis.git",
)
