#!/bin/bash
# Generate javascript rpc interfaces from the protocol buffer definitions.

mkdir -p js/gen

bazel-out/host/bin/external/com_google_protobuf/protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  --js_out=import_style=commonjs,binary:./js/gen \
  --ts_out=service=true:./js/gen \
  -I ./bazel-helloworld/external/googleapis \
  bazel-helloworld/external/googleapis/google/api/http.proto

bazel-out/host/bin/external/com_google_protobuf/protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  --js_out=import_style=commonjs,binary:./js/gen \
  --ts_out=service=true:./js/gen \
  -I ./bazel-helloworld/external/googleapis \
  bazel-helloworld/external/googleapis/google/api/annotations.proto

bazel-out/host/bin/external/com_google_protobuf/protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  --js_out=import_style=commonjs,binary:./js/gen \
  --ts_out=service=true:./js/gen \
  -I ./bazel-helloworld/external/googleapis \
  bazel-helloworld/external/googleapis/google/protobuf/field_mask.proto

bazel-out/host/bin/external/com_google_protobuf/protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  --js_out=import_style=commonjs,binary:./js/gen \
  --ts_out=service=true:./js/gen \
  -I ./bazel-helloworld/external/googleapis \
  bazel-helloworld/external/googleapis/google/protobuf/timestamp.proto

bazel-out/host/bin/external/com_google_protobuf/protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  --js_out=import_style=commonjs,binary:./js/gen \
  --ts_out=service=true:./js/gen \
  -I ./java/io/grpc/examples/helloworld \
  -I ./bazel-helloworld/external/googleapis \
  ./java/io/grpc/examples/helloworld/helloworld.proto
