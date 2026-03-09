#!/bin/bash

dockerd-rootless-setuptool.sh install

docker pull postgres

docker run --name pg-spring \
  -e POSTGRES_PASSWORD=coisarada \
  -d \
  -p 5432:5432 \
  postgres

sleep 5

docker exec pg-spring psql -U postgres -c "CREATE DATABASE pbe;"