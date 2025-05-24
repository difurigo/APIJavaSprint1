
# 🛵 API Java + DevOps + IoT – Mottu Challenge 2025

Sistema completo, escalável e inovador para mapeamento e gestão de pátios da Mottu. Desenvolvido com **Java (Spring Boot)**, containerizado com **Docker**, implantado em **Azure** e integrado com solução de **IoT via Bluetooth (BLE)**.

---

## 🔍 Visão Geral

A solução é dividida em **3 módulos principais**:

### 1. Organização do Pátio
- Divisão do espaço físico em zonas (A1, B2...)
- Fixação de QR Codes em zonas para facilitar localização
- Interface digital e interativa para gestão

### 2. Localização por Bluetooth (BLE)
- ESP32 como receptor de sinais BLE
- Estimativa de zonas baseada na força do sinal (RSSI)
- MVP utiliza celulares simulando motos

### 3. IoT Embarcado nas Motos (futuro)
- ESP32 instalado em cada moto, transmitindo ID e zona
- Dispositivo alimentado por bateria ou energia da moto

---

## 🎯 Objetivo da API

A API Java permite o gerenciamento de **colaboradores** e **logs de movimentação**, integrando-se ao sistema físico dos pátios. Ela fornece rastreabilidade digital, segurança e controle.

---

## 🧩 Funcionalidades da API

- Cadastro e login de colaboradores com autenticação HTTP Basic
- Registro de movimentações com hora e colaborador responsável
- Consulta de logs com filtros, paginação e ordenação
- Documentação via Swagger
- Banco de dados H2 persistente com cache
- Validações, DTOs e tratamento de erros centralizado

---

## 🔑 Endpoints principais

### 👥 Colaboradores
- `POST /colaboradores/cadastro` – Cadastro
- `POST /colaboradores/login` – Autenticação

### 📑 Logs de movimentação
- `POST /logs` – Registro de movimentação
- `GET /logs` – Listagem com filtros

---

## 🔐 Autenticação

A API usa HTTP Basic. Para testes:

```properties
spring.security.user.name=admin
spring.security.user.password=1234
```

---

## 🐳 Deploy via Docker + Azure

### Etapas completas:

1. Subir o arquivo `deploy.sh`  
2. Dar permissão:  
   `chmod +x deploy.sh`  
3. Executar:  
   `./deploy.sh`  

4. Acessar a VM:  
   `ssh usuario@<IP_DA_VM>`  
   - Dar `yes`
   - Senha: `Senha123!DevOps`

5. Instalar Docker e Git:
```bash
sudo apt update
sudo apt install docker.io git -y
sudo usermod -aG docker $USER
newgrp docker
```

6. Clonar o repositório:
```bash
mkdir app
cd app
git clone https://github.com/difurigo/APIJavaSprint1.git
cd APIJavaSprint1
mkdir -p ~/app/APIJavaSprint1/data
chmod 777 ~/app/APIJavaSprint1/data
```

7. Buildar e rodar com Docker:
```bash
docker build -t api-java .
docker run -d   -p 8080:8080   -v ~/app/APIJavaSprint1/data:/app/data   --name api-java   api-java
```

8. Verificar o container:
```bash
docker ps
```

---

## 🌐 Acesso à API

- Swagger: [http://<IP_DA_VM>:8080/swagger-ui/index.html](http://<IP_DA_VM>:8080/swagger-ui/index.html)  
- Console H2: [http://<IP_DA_VM>:8080/h2-console](http://<IP_DA_VM>:8080/h2-console)  
  - JDBC URL: `jdbc:h2:file:/app/data/demo`

Exemplos SQL:
```sql
SELECT * FROM LOGS_MOVIMENTACAO;
SELECT * FROM COLABORADORES;
```

---

## 📽️ MVP da Solução IoT

- Utilizamos celulares como simulação de dispositivos BLE
- ESP32 detecta e estima zona com base em RSSI
- API armazena movimentações e exibe dados na interface web

---

## 🧠 Stack Utilizada

- Java 17
- Spring Boot 3
- H2 Database (modo file)
- Docker
- Azure VM (Linux)
- Swagger (OpenAPI)
- ESP32 + RSSI (Bluetooth BLE)
- GitHub + Git

---

## 🧑‍💻 Equipe

- **Lu Vieira Santos** – RM: 558935  
- **Melissa Perreira** – RM: 555656  
- **Diego Furigo do Nascimento** – RM: 555656  

---

> Projeto acadêmico interdisciplinar com foco em Java Backend, DevOps e IoT. Entregue para a FIAP e Mottu como solução escalável e funcional.
