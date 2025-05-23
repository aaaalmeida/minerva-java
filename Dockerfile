FROM openjdk:21-jdk
LABEL authors="aaalmeida"
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
