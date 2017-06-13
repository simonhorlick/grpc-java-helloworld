http_archive(
    name = "grpc_java",
    sha256 = "956c7258c53f45824e3ce6d7e7e2211dc40640c1ba685f7c895c174fbd9106ba",
    strip_prefix = "grpc-java-5ea8323164f7dae9ca972324d6e42344a1d04035",
    urls = ["https://github.com/simonhorlick/grpc-java/archive/5ea8323164f7dae9ca972324d6e42344a1d04035.tar.gz"],
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

git_repository(
    name = "googleapis",
    commit = "29820f9afca85b3e0ee083fc374e40de6dfa3226",
    remote = "https://github.com/simonhorlick/apis.git",
)
