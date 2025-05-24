# Etapa de build (com Maven + JDK 17)
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução (imagem final leve e segura)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Executa com usuário sem privilégios
USER nobody

ENTRYPOINT ["java", "-jar", "app.jar"]
