# grpc-java bazel rules example

Try something like this:

```shell
$ bazel build ...
$ ./bazel-bin/java/io/grpc/examples/helloworld/HelloWorldServer &
$ ./bazel-bin/java/io/grpc/examples/helloworld/HelloWorldClient
```
