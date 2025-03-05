FROM openjdk:latest
LABEL authors="aaalmeida"
WORKDIR /app
COPY target/app.jar .
CMD ["java", "-jar", "app.jar"]