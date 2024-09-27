FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/VeiculoServiceDocker-0.0.1-SNAPSHOT.jar veiculo-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "veiculo-service.jar"]