#!/usr/bin/env bash
if [ "$1" == "minikube" || "$1" == "cloud" ]; then
  kubectl port-forward service/grafana 3000:3000 &
  kubectl port-forward service/memory-demo-j8 8080:8080 &
  kubectl port-forward service/memory-demo-j8u181 8181:8080 &
  kubectl port-forward service/memory-demo-j11 8081:8080 &
elif [ "$1" == "microk8s" ]; then
  microk8s kubectl port-forward service/grafana 3000:3000 &
  microk8s kubectl port-forward service/memory-demo-j8 8080:8080 &
  microk8s kubectl port-forward service/memory-demo-j8u181 8181:8080 &
  microk8s kubectl port-forward service/memory-demo-j11 8081:8080 &
fi
