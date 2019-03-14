#!/usr/bin/env bash

set -eo pipefail

modules=( eureka zuul turbine order payment zipkin  )

for module in "${modules[@]}"; do
    docker build -t "medical/${module}:latest" ${module}
done
