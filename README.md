
# 🛵 API Java - Mottu Challenge 2025

Sistema RESTful desenvolvido em Java com Spring Boot como parte do Challenge da FIAP em parceria com a **Mottu**. A solução é responsável pela **gestão de colaboradores e controle de movimentações de motos nos pátios das filiais**, integrando-se com as tecnologias de mapeamento e localização propostas no projeto principal.

---

## 🎯 Objetivo do Projeto

A Mottu enfrenta desafios de desorganização nos pátios físicos, dificultando o controle de entrada e saída das motos. Essa API oferece suporte ao sistema digital proposto no MVP, organizando os cadastros de colaboradores e os logs de movimentações por zona.

---

## 📦 Módulo 1 do Sistema - API RESTful

### Funcionalidades:

- Cadastro e login de colaboradores
- Registro de movimentações com vínculo ao colaborador
- Consulta de movimentações com paginação e filtro
- Segurança com autenticação básica
- Validações via Bean Validation
- Documentação automática com Swagger
- Cache configurado para ganho de performance
- Tratamento centralizado de erros
- Boas práticas REST

---

## 🧰 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web / Spring Security
- Spring Data JPA
- Oracle Database
- Spring Cache
- Swagger OpenAPI v3 (springdoc)
- Bean Validation

---

## 🔁 Endpoints

### 🧍 Colaboradores
- `POST /colaboradores/cadastro` – Cadastrar novo colaborador
- `POST /colaboradores/login` – Login com e-mail e senha

### 🧾 Logs de Movimentação
- `POST /logs` – Criar movimentação (associada a um colaborador)
- `GET /logs?page=0&size=10&colaboradorId=1` – Listar logs com filtro e paginação

---

## 🔐 Autenticação

A API utiliza autenticação HTTP Basic. Após cadastrar um colaborador, use as credenciais de e-mail e senha para autenticar-se nos endpoints protegidos.

Para ambiente local, você pode usar o login padrão do Spring:

```txt
Usuário: user
Senha: (a gerada no console ao iniciar o projeto)
```

Ou definir no `application.properties`:
```properties
spring.security.user.name=admin
spring.security.user.password=1234
```

---

## 📄 Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/difurigo/APIJavaSprint1.git/
cd APIJavaSprint1
```

2. Configure o `application.properties` com as credenciais do Oracle:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

4. Acesse a documentação Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🖼️ Prints da Solução

### ✅ Swagger UI funcionando:
![Swagger funcionando](![image](https://github.com/user-attachments/assets/60b1a841-7912-4299-93a6-6460998059ff)
)

### ✅ Estrutura visual da API:
- POST /colaboradores/cadastro
- POST /colaboradores/login
- POST /logs
- GET /logs?page=0&size=10&colaboradorId=1

---

## 🧠 Conexão com a Solução Completa (Frontend + IoT)

Essa API se integra ao restante da solução apresentada no challenge, incluindo:
- 📱 Interface mobile com React Native para leitura de QR Codes nas zonas do pátio.
- 💻 Painel web com React + TailwindCSS para visualização do pátio e motos.
- 📡 ESP32 simulando BLE (RSSI) como localização local das motos.
- 🛠 Supabase e FastAPI como camadas adicionais de persistência (visão futura).

---

## 📚 Requisitos atendidos

- [x] Spring Web
- [x] Spring Data JPA
- [x] Banco Oracle
- [x] CRUD completo (Colaborador, LogMovimentacao)
- [x] Relacionamento entre entidades
- [x] Bean Validation
- [x] Paginação e filtros
- [x] Cache configurado
- [x] Boas práticas REST
- [x] DTOs
- [x] Tratamento centralizado de erros

---

## 👥 Equipe

Integrantes do Grupo:
- Lu Vieira Santos - RM: 558935
- Melissa Perreira - RM: 555656
- Diego Furigo do Nascimento - RM: 555656
---

> Projeto acadêmico desenvolvido com foco em inovação, boas práticas e solução real para o desafio da Mottu.
