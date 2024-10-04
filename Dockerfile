FROM openjdk:17-jdk-alpine
LABEL authors="gui"
WORKDIR /app
COPY target/meu-projeto.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]