@echo off
call mvn clean package
call docker build -t com.mycompany/demoPrimefaces .
call docker rm -f demoPrimefaces
call docker run -d -p 9080:9080 -p 9443:9443 --name demoPrimefaces com.mycompany/demoPrimefaces