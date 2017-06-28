#!/bin/bash

# Kill all backgrounded processes on exit.
trap "pkill -P $$" EXIT

bazel build ... || exit 1

./bazel-bin/java/io/grpc/examples/helloworld/HelloWorldServer &
./bazel-bin/external/com_github_improbable_eng_grpc_web/go/grpcwebproxy/grpcwebproxy \
  --server_tls_cert_file=certs/localhost.pem \
  --server_tls_key_file=certs/localhost-key.pkcs8 \
  --server_http_tls_port=50061 \
  --server_http_debug_port=9090 \
  --backend_addr=localhost:50051 \
  --backend_tls=false &

npm start
