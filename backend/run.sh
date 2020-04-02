#!/bin/bash

./build.sh

docker build -t e-commerce-backend .

docker stop e-commerce-backend && \
docker rm e-commerce-backend && \

docker run -d --name e-commerce-backend -p 8181:8181 -v external-file:/root/config e-commerce-backend
