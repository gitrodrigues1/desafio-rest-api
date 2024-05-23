FROM openjdk:17
COPY /target/*.jar /app/desafio-rest-api.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "desafio-rest-api.jar"]