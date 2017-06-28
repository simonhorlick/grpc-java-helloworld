workspace(name = "helloworld")

# Override maven_jar so we can get sources.
load("//tools/build_rules:maven_jar.bzl", "maven_jar")

http_archive(
    name = "grpc_java",
    sha256 = "b2dfb2602f752dfe413f163e89b6d8e21cbc71dcaf5bc9baa35ebc53916b39a6",
    strip_prefix = "grpc-java-f0901ed08f3f09049b06177802404b07207a75f0",
    urls = ["https://github.com/simonhorlick/grpc-java/archive/f0901ed08f3f09049b06177802404b07207a75f0.tar.gz"],
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")

grpc_java_repositories(
    omit_com_google_guava = True,
)

bind(
    name = "guava",
    actual = "@com_google_guava//jar",
)

bind(
    name = "gson",
    actual = "@com_google_code_gson//jar",
)

git_repository(
    name = "googleapis",
    commit = "29820f9afca85b3e0ee083fc374e40de6dfa3226",
    remote = "https://github.com/simonhorlick/apis.git",
)

maven_jar(
    name = "javax_annotation_jsr250_api",
    artifact = "javax.annotation:jsr250-api:1.0",
    sha1 = "5025422767732a1ab45d93abfea846513d742dcf",
)

maven_jar(
    name = "javax_inject_javax_inject",
    artifact = "javax.inject:javax.inject:1",
    sha1 = "6975da39a7040257bd51d21a231b76c915872d38",
)

maven_jar(
    name = "javax_inject_javax_inject_tck",
    artifact = "javax.inject:javax.inject-tck:1",
    sha1 = "bb0090d50219c265be40fcc8e034dae37fa7be99",
)

maven_jar(
    name = "com_google_guava_guava",
    artifact = "com.google.guava:guava:21.0",
    sha1 = "3a3d111be1be1b745edfa7d91678a12d7ed38709",
)

local_repository(
    name = "com_google_guava",
    path = "third_party/guava",
)

maven_jar(
    name = "com_google_guava_guava_testlib",
    artifact = "com.google.guava:guava-testlib:21.0-rc1",
    sha1 = "13f0f0dce4e710bb0bb791bd07f6e9858670a865",
)

maven_jar(
    name = "com_google_errorprone_javac",
    artifact = "com.google.errorprone:javac:9-dev-r3297-1-shaded",
    sha1 = "0f6d4998965282068a3feecddc21578d23f17275",
)

maven_jar(
    name = "com_google_googlejavaformat_google_java_format",
    artifact = "com.google.googlejavaformat:google-java-format:1.3",
    sha1 = "949e85e75b3160ce1446aa99d806d5b509631b02",
)

maven_jar(
    name = "com_google_auto_auto_common",
    artifact = "com.google.auto:auto-common:0.8",
    sha1 = "c6f7af0e57b9d69d81b05434ef9f3c5610d498c4",
)

maven_jar(
    name = "com_google_auto_factory_auto_factory",
    artifact = "com.google.auto.factory:auto-factory:1.0-beta3",
    sha1 = "99b2ffe0e41abbd4cc42bf3836276e7174c4929d",
)

maven_jar(
    name = "com_squareup_javawriter",
    artifact = "com.squareup:javawriter:2.5.1",
    sha1 = "54c87b3d91238e5b58e1a436d4916eee680ec959",
)

maven_jar(
    name = "com_google_auto_service_auto_service",
    artifact = "com.google.auto.service:auto-service:1.0-rc2",
    sha1 = "51033a5b8fcf7039159e35b6878f106ccd5fb35f",
)

maven_jar(
    name = "com_google_auto_value_auto_value",
    artifact = "com.google.auto.value:auto-value:1.4-rc1",
    sha1 = "9347939002003a7a3c3af48271fc2c18734528a4",
)

maven_jar(
    name = "junit_junit",
    artifact = "junit:junit:4.11",
    sha1 = "4e031bb61df09069aeb2bffb4019e7a5034a4ee0",
)

maven_jar(
    name = "com_google_testing_compile_compile_testing",
    artifact = "com.google.testing.compile:compile-testing:0.10",
    sha1 = "51e6189be9d2861d1eb22b4009c8f3430319490c",
)

maven_jar(
    name = "org_mockito_mockito_core",
    artifact = "org.mockito:mockito-core:1.9.5",
    sha1 = "c3264abeea62c4d2f367e21484fbb40c7e256393",
)

maven_jar(
    name = "org_hamcrest_hamcrest_core",
    artifact = "org.hamcrest:hamcrest-core:1.3",
    sha1 = "42a25dc3219429f0e5d060061f71acb49bf010a0",
)

maven_jar(
    name = "org_objenesis_objenesis",
    artifact = "org.objenesis:objenesis:1.0",
    sha1 = "9b473564e792c2bdf1449da1f0b1b5bff9805704",
)

maven_jar(
    name = "com_google_truth_truth",
    artifact = "com.google.truth:truth:0.30",
    sha1 = "9d591b5a66eda81f0b88cf1c748ab8853d99b18b",
)

maven_jar(
    name = "com_google_truth_extensions_truth_java8_extension",
    artifact = "com.google.truth.extensions:truth-java8-extension:0.30",
    sha1 = "f3bb5e49001a9b575bcdef9aa8417b6d1ef35509",
)

maven_jar(
    name = "com_squareup_javapoet",
    artifact = "com.squareup:javapoet:1.7.0",
    sha1 = "4fdcf1fc27c1a8f55d1109df986c923152f07759",
)

local_repository(
    name = "io_grpc_grpc_core",
    path = "third_party/grpc_core",
)

local_repository(
    name = "io_grpc_grpc_netty",
    path = "third_party/grpc_netty",
)

local_repository(
    name = "io_grpc_grpc_context",
    path = "third_party/grpc_context",
)

local_repository(
    name = "io_grpc_grpc_protobuf",
    path = "third_party/grpc_protobuf",
)

local_repository(
    name = "io_grpc_grpc_stub",
    path = "third_party/grpc_stub",
)

local_repository(
    name = "com_google_protobuf_protobuf_java",
    path = "third_party/com_google_protobuf_protobuf_java",
)

http_archive(
    name = "com_google_dagger",
    sha256 = "5ee0a8b1f707f0c8a5c27f3c6b107e5863dd0f463797c05bbe68f55f811737d7",
    strip_prefix = "dagger-792adb3fb98a5ea54e421d5f7bec0b38473fa6ad",
    urls = [
        "https://github.com/google/dagger/archive/792adb3fb98a5ea54e421d5f7bec0b38473fa6ad.tar.gz",
    ],
)
