# API de Gerenciamento de Tarefas

Uma API RESTful desenvolvida em Java com Spring Boot para gerenciar tarefas, permitindo operações CRUD completas.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **Spring Web**
- **MySQL**
- **Maven**
- **Bean Validation**

## 📋 Funcionalidades

- ✅ Criar tarefas
- 📋 Listar todas as tarefas
- 🔍 Buscar tarefa por ID
- ✏️ Atualizar tarefas existentes
- 🗑️ Remover tarefas

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/exemplo/tarefas/
│   │   ├── controller/          # Controllers REST
│   │   ├── model/              # Entidades JPA
│   │   ├── repository/         # Repositórios de dados
│   │   ├── service/            # Lógica de negócio
│   │   ├── exception/          # Tratamento de exceções
│   │   └── ApiTarefasApplication.java
│   └── resources/
│       ├── application.properties
│       └── application-test.properties
└── test/
    └── java/com/exemplo/tarefas/
        └── controller/         # Testes unitários
```

## 🛠️ Configuração e Instalação

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL 8.0+

### Passos para Configuração

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd api-tarefas
```

2. **Configure o banco de dados MySQL**
```sql
CREATE DATABASE tarefas_db;
```

3. **Configure as credenciais no application.properties**
```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

4. **Execute a aplicação**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Endpoints da API

### Tarefas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/tarefas` | Lista todas as tarefas |
| GET | `/api/tarefas/{id}` | Busca tarefa por ID |
| POST | `/api/tarefas` | Cria nova tarefa |
| PUT | `/api/tarefas/{id}` | Atualiza tarefa existente |
| DELETE | `/api/tarefas/{id}` | Remove tarefa |


### Exemplos de Uso

#### Criar uma tarefa
```http
POST /api/tarefas
Content-Type: application/json

{
  "nome": "Desenvolver API REST",
  "dataEntrega": "2025-07-09",
  "responsavel": "Danielle Delfino"
}
```

#### Atualizar uma tarefa
```http
PUT /api/tarefas/1
Content-Type: application/json

{
  "nome": "Desenvolver API REST",
  "dataEntrega": "2025-07-09",
  "responsavel": "Danielle Delfino"
}
```

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

Os testes utilizam o banco H2 em memória para isolamento completo.

## 📊 Modelo de Dados

### Entidade Tarefa

| Campo | Tipo | Obrigatório | Descrição |
|-------|------|-------------|-----------|
| id | Long | Sim (auto) | Identificador único |
| nome | String | Sim | Nome da tarefa |
| dataEntrega | LocalDate | Sim | Data de entrega |
| responsavel | String | Sim | Responsável pela tarefa |

## 🔧 Validações

- **Nome**: Obrigatório, não pode estar em branco
- **Data de Entrega**: Obrigatória, não pode ser anterior a 1 ano
- **Responsável**: Obrigatório, não pode estar em branco

## 🚨 Tratamento de Erros

A API retorna respostas padronizadas para erros:

```json
{
  "status": 404,
  "message": "Tarefa não encontrada com ID: 1",
  "timestamp": "2025-09-07T10:30:00"
}
```

Para erros de validação:
```json
{
  "status": 400,
  "message": "Erro de validação nos dados enviados",
  "timestamp": "2025-09-07T10:30:00",
  "fieldErrors": {
    "nome": "Nome da tarefa é obrigatório",
    "dataEntrega": "Data de entrega é obrigatória"
  }
}
```

## 📄 Coleção Postman

Uma coleção completa do Postman está incluída no projeto para facilitar os testes da API. Importe o arquivo JSON da coleção no Postman para ter acesso a todos os endpoints configurados.

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Autor

Desenvolvido como parte do trabalho de Desenvolvimento Web Back-end do Curso de Engenharia de Softaware
---

**Nota**: Certifique-se de ter o MySQL rodando e configurado corretamente antes de executar a aplicação em modo de produção.