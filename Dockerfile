FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

# Cria usuário sem privilégios administrativos
RUN addgroup --system appuser && adduser --system --ingroup appuser appuser

# Cria o diretório de dados com permissão para o usuário
RUN mkdir -p /app/data && chown appuser:appuser /app/data

USER appuser

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]