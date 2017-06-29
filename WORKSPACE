workspace(name = "helloworld")

# Override maven_jar so we can get sources.
load("//tools/build_rules:maven_jar.bzl", "maven_jar")

git_repository(
    name = "io_bazel_rules_go",
    commit = "152a165327817c214f5ea5861a1af68918883189",
    remote = "https://github.com/bazelbuild/rules_go.git",
)

load("@io_bazel_rules_go//go:def.bzl", "go_repositories", "go_repository")

go_repositories()

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

http_file(
    name = "com_github_tianon_docker_brew_debian",
    sha256 = "479bbadb58c74bd3f14507eda2c5ff03b88f7f9db0d7ce60471ffa0c6864f8df",
    urls = [
        "http://storage.googleapis.com/sh-external-artifacts/raw.githubusercontent.com/tianon/docker-brew-debian/b39d31635ca26c8b1f3d982090ba8d54167c4d85/jessie/rootfs.tar.gz",
    ],
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
    commit = "1dccf5c4a4c2ffc3e7cf4b9246d7cf82bc7efaff",
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

# For grpc-web-proxy
go_repository(
    name = "com_github_golang_protobuf",
    commit = "8ee79997227bf9b34611aee7946ae64735e6fd93",
    importpath = "github.com/golang/protobuf",
)

go_repository(
    name = "org_golang_x_text",
    commit = "4e9ab9ee170f2a39bd66c92b3e0a47ff47a4bc77",
    importpath = "golang.org/x/text",
)

go_repository(
    name = "org_golang_x_net",
    commit = "5f8847ae0d0e90b6a9dc8148e7ad616874625171",
    importpath = "golang.org/x/net",
)

go_repository(
    name = "org_golang_x_sys",
    commit = "f7928cfef4d09d1b080aa2b6fd3ca9ba1567c733",
    importpath = "golang.org/x/sys",
)

go_repository(
    name = "org_golang_google_grpc",
    importpath = "google.golang.org/grpc",
    tag = "v1.4.2",
)

go_repository(
    name = "com_github_grpc_ecosystem_go_grpc_middleware",
    commit = "f63a7dfb64c138bd93d5c5b896d8b33c4b08e000",
    importpath = "github.com/grpc-ecosystem/go-grpc-middleware",
)

go_repository(
    name = "com_github_mwitkow_grpc_proxy",
    commit = "fdb8208ccf3cad0ca72183a18dce12bb2c294c97",
    remote = "https://github.com/simonhorlick/grpc-proxy",
    vcs = "git",
    importpath = "github.com/mwitkow/grpc-proxy",
)

go_repository(
    name = "com_github_mwitkow_go_conntrack",
    commit = "cc309e4a22231782e8893f3c35ced0967807a33e",
    importpath = "github.com/mwitkow/go-conntrack",
)

go_repository(
    name = "com_github_grpc_ecosystem_go_grpc_prometheus",
    commit = "0c1b191dbfe51efdabe3c14b9f6f3b96429e0722",
    importpath = "github.com/grpc-ecosystem/go-grpc-prometheus",
)

go_repository(
    name = "com_github_spf13_pflag",
    commit = "e57e3eeb33f795204c1ca35f56c44f83227c6e66",
    importpath = "github.com/spf13/pflag",
)

go_repository(
    name = "com_github_sirupsen_logrus",
    commit = "3d4380f53a34dcdc95f0c1db702615992b38d9a4",
    importpath = "github.com/sirupsen/logrus",
)

go_repository(
    name = "com_github_prometheus_client_model",
    commit = "6f3806018612930941127f2a7c6c453ba2c527d2",
    importpath = "github.com/prometheus/client_model",
)

go_repository(
    name = "com_github_prometheus_common",
    commit = "0866df4b85a18d652b6965be022d007cdf076822",
    importpath = "github.com/prometheus/common",
)

go_repository(
    name = "com_github_prometheus_client_golang",
    commit = "de4d4ffe63b9eff7f27484fdef6e421597e6abb4",
    importpath = "github.com/prometheus/client_golang",
)

go_repository(
    name = "com_github_prometheus_procfs",
    commit = "822d4a1f8edcbcbc71e8d1fd6527b12331a6d0ad",
    importpath = "github.com/prometheus/procfs",
)

go_repository(
    name = "com_github_beorn7_perks",
    commit = "4c0e84591b9aa9e6dcfdf3e020114cd81f89d5f9",
    importpath = "github.com/beorn7/perks",
)

go_repository(
    name = "com_github_matttproud_golang_protobuf_extensions",
    commit = "c12348ce28de40eed0136aa2b644d0ee0650e56c",
    importpath = "github.com/matttproud/golang_protobuf_extensions",
)

go_repository(
    name = "com_github_improbable_eng_grpc_web",
    commit = "85d29a20b3d8cc55f53d19143ba2dd37946a2bd6",
    importpath = "github.com/improbable-eng/grpc-web",
)

go_repository(
    name = "com_github_rs_cors",
    commit = "8dd4211afb5d08dbb39a533b9bb9e4b486351df6",
    importpath = "github.com/rs/cors",
)

go_repository(
    name = "org_golang_google_genproto",
    commit = "aa2eb687b4d3e17154372564ad8d6bf11c3cf21f",
    importpath = "google.golang.org/genproto",
)
