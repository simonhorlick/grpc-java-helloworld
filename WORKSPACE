workspace(name = "helloworld")

http_archive(
    name = "grpc_java",
    sha256 = "7316e8399ad888a0a19259d778d2e24fba2fac9e2f083ce1fa81ec7337754c43",
    strip_prefix = "grpc-java-2dfcd1a6b4310c9508dcbf762dc60772072aa613",
    urls = ["https://github.com/simonhorlick/grpc-java/archive/2dfcd1a6b4310c9508dcbf762dc60772072aa613.tar.gz"],
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories()

git_repository(
    name = "googleapis",
    commit = "29820f9afca85b3e0ee083fc374e40de6dfa3226",
    remote = "https://github.com/simonhorlick/apis.git",
)
