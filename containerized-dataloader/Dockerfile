FROM openjdk
MAINTAINER Taner Diler <taner.diler@gmail.com>
ADD target/containerized-dataloader-0.0.1-SNAPSHOT.jar containerized-dataloader.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/containerized-dataloader.jar"]
EXPOSE 2222
