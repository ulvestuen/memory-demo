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
```

## Test
```
cd load-test
./start-test [consume|accumulate]
```
The container that runs with Java 8u181 is expected to have different memory behavior than the other two,
since 8u181 is the last version of Java 8 which do not enable by default the improved configuration for running in 
container environments. Ref. release notes for the following version (Java 8u191): 
https://www.oracle.com/java/technologies/javase/8u191-relnotes.html#JDK-8146115
