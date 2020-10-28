#!/usr/bin/env bash
eval $(minikube -p minikube docker-env)
docker build -t memory-demo-j8 -f ../../../../Dockerfile-j8 ../../../../.
docker build -t memory-demo-j8u181 -f ../../../../Dockerfile-j8u181 ../../../../.
docker build -t memory-demo-j11 -f ../../../../Dockerfile-j11 ../../../../.
