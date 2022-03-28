FROM openjdk:12-jdk-alpine
MAINTAINER alesia
VOLUME /tmp
EXPOSE 8080
ADD build/libs/sick-0.1.0.jar sick.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/sick.jar"]