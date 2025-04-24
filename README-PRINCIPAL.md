
# API de Consultório Médico

API REST para gerenciamento de médicos, pacientes e consultas, desenvolvida com Spring Boot e MySQL.

## 📋 Funcionalidades

- Autenticação com JWT
- Cadastro, listagem, atualização e exclusão de médicos e pacientes
- Agendamento de consultas
- Validação de dados
- Integração com banco de dados MySQL
- Migrações com Flyway
- Testes automatizados com JUnit

## 🚀 Tecnologias Utilizadas

- Java 23
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Flyway
- Lombok
- MySQL
- Maven

## ⚙️ Configuração do Projeto

### Pré-requisitos

- JDK 23
- Maven 3.8+
- MySQL rodando na porta `3306`
- Banco de dados `clinica_medica` e `clinica_medica_test` criados

### Instalação

```bash
git clone https://github.com/seuusuario/consultorio-api.git
cd consultorio-api
mvn clean install
```

Configure as propriedades em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinica_medica
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Executando

```bash
mvn spring-boot:run
```

Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 🔐 Autenticação

A autenticação é feita via token JWT. Para acessar os endpoints protegidos:

```bash
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"login":"admin", "senha":"123456"}'
```

Use o token retornado com o header:

```
Authorization: Bearer <token>
```

## 📬 Exemplos de Requisições

### 📌 Médicos

```bash
# Criar médico
curl -X POST http://localhost:8080/medicos -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{
  "nome": "Dr. Fulano",
  "email": "fulano@email.com",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua A",
    "bairro": "Centro",
    "cep": "12345678",
    "cidade": "São Paulo",
    "uf": "SP",
    "numero": "123",
    "complemento": "Apto 1"
  }
}'
```

```bash
# Listar médicos
http GET http://localhost:8080/medicos Authorization:"Bearer <token>"
```

### 📌 Pacientes

```bash
# Criar paciente
curl -X POST http://localhost:8080/pacientes -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "cpf": "12345678900",
  "telefone": "11999999999",
  "endereco": {
    "logradouro": "Av. B",
    "bairro": "Jardim",
    "cep": "87654321",
    "cidade": "Rio de Janeiro",
    "uf": "RJ",
    "numero": "456",
    "complemento": "Casa"
  }
}'
```

### 📌 Consultas

```bash
# Agendar consulta
curl -X POST http://localhost:8080/consultas -H "Authorization: Bearer <token>" -H "Content-Type: application/json" -d '{
  "idMedico": 1,
  "idPaciente": 2,
  "data": "2025-05-01T10:00:00"
}'
```

## 🧪 Testes

```bash
mvn test
```

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/dev/anderson/med/voll/api/
│   │   ├── controller/
│   │   ├── domain/
│   │   ├── infra/
│   │   └── user/
│   └── resources/
│       └── db/migration/
└── test/
```

## 📄 Licença

MIT.
