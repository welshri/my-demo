FROM ubuntu:16.04
MAINTAINER Richard Welsh <rich@welsh.net>
RUN apt-get update
RUN DEBIAN_FRONTEND=noninteractive apt-get install -yq default-jdk maven git
RUN git clone https://github.com/welshri/my-demo ./my-demo
WORKDIR ./my-demo/basic-rest-demonstrator
RUN pwd
RUN ls -al
RUN mvn clean install -Dmaven.test.skip=true
RUN mkdir -p data/persistence/employee
EXPOSE 8080
CMD ["java" ,"-jar","/root/.m2/repository/org/welshri/basic-rest-demonstrator/0.0.1-SNAPSHOT/basic-rest-demonstrator-0.0.1-SNAPSHOT.jar"]
#docker build . -t welshri/java_one
#docker run --rm -it -d -p8080:8080 welshri/java_one
#curl 0.0.0.0:8080/employee/Bob
#docker stop welshri/java_one
