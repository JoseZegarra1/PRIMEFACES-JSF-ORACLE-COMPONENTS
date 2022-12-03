#!/bin/sh
mvn clean package && docker build -t com.mycompany/demoPrimefaces .
docker rm -f demoPrimefaces || true && docker run -d -p 9080:9080 -p 9443:9443 --name demoPrimefaces com.mycompany/demoPrimefaces