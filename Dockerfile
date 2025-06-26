## build
#FROM maven:3.9.6-eclipse-temurin-21 AS builder
#WORKDIR /app
#COPY . .
#RUN mvn clean package

# runtime
FROM openjdk:21-jdk
WORKDIR /app
COPY ./target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]