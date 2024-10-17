FROM openjdk:17-jdk-alphine

LABEL authors="Guilherme Lopes, Matheus da Cunha & Bernardo Gondim"

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]



