#!/usr/bin/env bash
docker build -t memory-demo-j8 -f ../../../../Dockerfile-j8 ../../../../.
docker save memory-demo-j8 > memory-demo-j8.tar
microk8s ctr image import memory-demo-j8.tar
docker build -t memory-demo-j8u181 -f ../../../../Dockerfile-j8u181 ../../../../.
docker save memory-demo-j8u181 > memory-demo-j8u181.tar
microk8s ctr image import memory-demo-j8u181.tar
docker build -t memory-demo-j11 -f ../../../../Dockerfile-j11 ../../../../.
docker save memory-demo-j11 > memory-demo-j11.tar
microk8s ctr image import memory-demo-j11.tar
