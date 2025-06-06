# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o .jar
COPY --from=builder /app/target/*.jar app.jar

# Cria pasta /data com permissão para escrita
RUN mkdir -p /data && chmod 777 /data

# Executa com usuário sem privilégios (mais seguro)
USER nobody

# Expõe porta da aplicação
EXPOSE 8080

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
