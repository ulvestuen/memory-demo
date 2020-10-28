# memory-demo

## Environment setup, build and deploy
### Docker Compose
```
cd setup/docker-compose
docker-compose --compatibility up --build -d
```
### Minikube
```
minikube start
cd setup/k8s/apps/minikube
./build_apps.sh
cd ../..
kubectl -- apply -k .
./portforward minikube
```

### Microk8s
```
minikube start
cd setup/k8s/apps/microk8s
./build_apps.sh
cd ../..
microk8s kubectl -- apply -k .
./portforward microk8s


## Test
```
cd load-test
./start-test [consume|accumulate]
```



https://www.oracle.com/java/technologies/javase/8u191-relnotes.html#JDK-8146115
