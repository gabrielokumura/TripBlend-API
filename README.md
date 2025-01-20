# Depoimentos API

## Descrição
A **Depoimentos API** é uma API RESTful que permite gerenciar depoimentos de usuários. A aplicação oferece funcionalidades para criar, listar, atualizar e excluir depoimentos, com suporte à paginação e retorno no formato DTO (Data Transfer Object).

## Funcionalidades
- **Criar depoimentos:** Adicione novos depoimentos de usuários.
- **Listar depoimentos:** Liste os depoimentos cadastrados com suporte à paginação.
- **Atualizar depoimentos:** Atualize informações de depoimentos existentes.
- **Excluir depoimentos:** Remova depoimentos do sistema.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Hibernate**
- **JPA**
- **H2 Database** (ou outro banco de dados configurável)
- **Maven**

## Estrutura dos Dados
### Modelo de Dados (Entidade `Depoimento`):
- `id` (Long): Identificador único do depoimento (auto-incrementado).
- `foto` (String): URL da foto do usuário.
- `depoimento` (String): Texto do depoimento.
- `nome` (String): Nome do usuário que fez o depoimento.

### DTO (Data Transfer Object):
```java
public record DepoimentosDTO(Long id, String foto, String depoimento, String nome) {
    public static DepoimentosDTO fromEntity(Depoimento depoimento) {
        return new DepoimentosDTO(
            depoimento.getId(),
            depoimento.getFoto(),
            depoimento.getDepoimento(),
            depoimento.getNome()
        );
    }
}
```

## Endpoints
### **/depoimentos**

#### **POST /depoimentos**
Adiciona um novo depoimento.
- **Request Body:**
```json
{
  "foto": "http://exemplo.com/foto.jpg",
  "depoimento": "Este é um depoimento exemplo.",
  "nome": "João da Silva"
}
```
- **Response:** 201 Created

#### **GET /depoimentos?page={page}&size={size}**
Lista os depoimentos com paginação.
- **Response:**
```json
{
  "content": [
    {
      "id": 1,
      "foto": "http://exemplo.com/foto.jpg",
      "depoimento": "Este é um depoimento exemplo.",
      "nome": "João da Silva"
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "size": 10,
  "number": 0
}
```

#### **PUT /depoimentos/{id}**
Atualiza um depoimento existente.
- **Request Body:**
```json
{
  "foto": "http://exemplo.com/foto_atualizada.jpg",
  "depoimento": "Este depoimento foi atualizado.",
  "nome": "Maria Souza"
}
```
- **Response:** 200 OK

#### **DELETE /depoimentos/{id}**
Remove um depoimento.
- **Response:** 204 No Content

## Configuração do Projeto
### **Requisitos**
- **Java 17** ou superior.
- **Maven**.

### **Como Executar**
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/depoimentos-api.git
   cd depoimentos-api
   ```
2. Instale as dependências:
   ```bash
   mvn clean install
   ```
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a aplicação em `http://localhost:8080`.

## Testes
Para rodar os testes:
```bash
mvn test
```

## Contribuição
1. Faça um fork do repositório.
2. Crie uma branch para sua feature:
   ```bash
   git checkout -b minha-feature
   ```
3. Realize suas modificações e faça o commit:
   ```bash
   git commit -m "Minha nova feature"
   ```
4. Faça um push para a branch:
   ```bash
   git push origin minha-feature
   ```
5. Abra um Pull Request.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).

