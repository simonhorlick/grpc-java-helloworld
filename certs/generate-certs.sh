#!/bin/bash

# Create the CA
cfssl gencert -initca ca-csr.json | cfssljson -bare ca

# Generate the rsm service certs
cfssl gencert \
  -ca=ca.pem \
  -ca-key=ca-key.pem \
  -config=ca-config.json \
  -profile=server \
  localhost-csr.json | cfssljson -bare localhost

# Generate PKCS8 versions for loading in Java
openssl pkcs8 -topk8 -nocrypt -in localhost-key.pem -out localhost-key.pkcs8
