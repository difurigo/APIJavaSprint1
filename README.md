# 🛵 API Java - Mottu Challenge 2025

Sistema RESTful desenvolvido em Java com Spring Boot como parte do Challenge da FIAP em parceria com a **Mottu**. A API gerencia **colaboradores e logs de movimentações de motos nos pátios físicos**, integrando com a solução de rastreamento por zonas.

---

## 🎯 Objetivo

Facilitar o controle de entrada e saída de motos nos pátios da Mottu, garantindo rastreabilidade digital e segurança.

---

## 📦 Funcionalidades

- Cadastro e login de colaboradores
- Registro de movimentações com vínculo a colaborador
- Consulta com paginação e filtros
- Documentação Swagger
- Segurança com autenticação HTTP Basic
- Validações com Bean Validation
- Tratamento centralizado de erros
- Cache para performance

---

## 🧪 Endpoints principais

### Colaboradores
- `POST /colaboradores/cadastro` – Cadastrar
- `POST /colaboradores/login` – Login

### Logs de Movimentação
- `POST /logs` – Criar log
- `GET /logs?colaboradorId=1&page=0&size=10` – Listar logs

---

## 🔐 Autenticação

Utilize HTTP Basic Authentication após criar um colaborador.  
Você pode configurar um usuário padrão via:

```properties
spring.security.user.name=admin
spring.security.user.password=1234
```

---

## 🚀 Como rodar o projeto

### 💻 Modo local (com Maven)

```bash
git clone https://github.com/difurigo/APIJavaSprint1.git
cd APIJavaSprint1
./mvnw spring-boot:run
```

Acesse: http://localhost:8080/swagger-ui/index.html

---

### 🐳 Modo Docker (recomendado)

1. Construa a imagem:

```bash
docker build -t api-java .
```

2. Rode o container:

```bash
docker run -d -p 8080:8080 api-java
```

3. Acesse:

- http://localhost:8080/swagger-ui/index.html  
- http://localhost:8080/h2-console

---

## ☁️ Deploy em Nuvem (Azure)

Use o script `deploy.sh` para:

- Criar grupo e VM no Azure
- Abrir porta 8080

```bash
chmod +x deploy.sh
./deploy.sh
```

---

## 🖼️ Diagrama da Arquitetura

(Insira o link ou imagem do Draw.io com os componentes: usuário → VM → container Docker → API → banco H2 interno)

---

## 📽️ Vídeo de Demonstração

🔗 Link para o vídeo no YouTube: **[inserir aqui]**

---

## 👨‍💻 Equipe

- **Lu Vieira Santos** – RM: 558935  
- **Melissa Perreira** – RM: 555656  
- **Diego Furigo do Nascimento** – RM: 555656  

---

> Projeto acadêmico entregue com foco em DevOps, inovação e execução profissional.
