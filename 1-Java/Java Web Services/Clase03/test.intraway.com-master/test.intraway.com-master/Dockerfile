FROM       openjdk:8
MAINTAINER Raul Peña (raul.pena@gmail.com)
WORKDIR    /opt/workspace
RUN        apt-get update && apt-get upgrade -y \
           && apt-get install -y vim
RUN        mkdir -p /opt/workspace/logs
ADD        target/*.jar /opt/workspace/app.jar
RUN        sh -c 'touch /opt/workspace/app.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /opt/workspace/app.jar" ]