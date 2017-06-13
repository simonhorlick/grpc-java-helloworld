http_archive(
    name = "grpc_java",
    sha256 = "f092088b7391ef1a6eac0e424ab503c9e228c6e6c399357b7e81b353582edbe7",
    strip_prefix = "grpc-java-480f1d08b32f002f2eef1d63689d2b93b3717747",
    urls = ["https://github.com/simonhorlick/grpc-java/archive/480f1d08b32f002f2eef1d63689d2b93b3717747.tar.gz"],
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

git_repository(
    name = "googleapis",
    commit = "29820f9afca85b3e0ee083fc374e40de6dfa3226",
    remote = "https://github.com/simonhorlick/apis.git",
)
