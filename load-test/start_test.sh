#!/usr/bin/env bash
if [ "$1" == "accumulate" ]; then
  newman run memory-demo-accumulate.postman_collection.json --iteration-count 100000 --delay-request 10 --env-var nIntegers="$2"
elif [ "$1" == "consume" ]; then
  newman run memory-demo-consume.postman_collection.json --iteration-count 100000 --delay-request 10 --env-var nIntegers="$2"
fi


