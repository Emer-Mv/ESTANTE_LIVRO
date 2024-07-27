Documentação da API de Gerenciamento de Livros
Visão Geral
Esta API permite a gestão de livros, incluindo operações de criação, leitura, atualização e exclusão (CRUD). A API é construída usando Spring Boot e usa JPA para interação com um banco de dados MySQL.
Base URL
A base URL para todos os endpoints é:
bash
Copiar código
http://localhost:8080/livro
Endpoints da API
1. Listar Todos os Livros
•	Método: GET
•	Endpoint: /livro
•	Descrição: Retorna uma lista de todos os livros cadastrados.
Resposta:
•	Código de Sucesso: 200 OK
•	Corpo da Resposta:
json
Copiar código
[
  {
    "id": 1,
    "titulo": "O Senhor dos Anéis",
    "autor": "J.R.R. Tolkien",
    "isbn": "978-0-345-33968-3",
    "anoPublicacao": 1954
  },
  {
    "id": 2,
    "titulo": "1984",
    "autor": "George Orwell",
    "isbn": "978-0-452-28423-4",
    "anoPublicacao": 1949
  }
]
2. Obter Livro por ID
•	Método: GET
•	Endpoint: /livro/{id}
•	Descrição: Retorna os detalhes de um livro específico com base no ID fornecido.
Parâmetros de URL:
•	id (obrigatório): ID do livro.
Resposta:
•	Código de Sucesso: 200 OK
•	Código de Erro: 404 Not Found (se o livro não for encontrado)
•	Corpo da Resposta:
json
Copiar código
{
  "id": 1,
  "titulo": "O Senhor dos Anéis",
  "autor": "J.R.R. Tolkien",
  "isbn": "978-0-345-33968-3",
  "anoPublicacao": 1954
}
3. Adicionar Novo Livro
•	Método: POST
•	Endpoint: /livro
•	Descrição: Adiciona um novo livro ao banco de dados.
Corpo da Requisição:
json
Copiar código
{
  "titulo": "O Hobbit",
  "autor": "J.R.R. Tolkien",
  "isbn": "978-0-345-33968-3",
  "anoPublicacao": 1937
}
Resposta:
•	Código de Sucesso: 201 Created
•	Corpo da Resposta:
json
Copiar código
{
  "id": 3,
  "titulo": "O Hobbit",
  "autor": "J.R.R. Tolkien",
  "isbn": "978-0-345-33968-3",
  "anoPublicacao": 1937
}
4. Atualizar Livro
•	Método: PUT
•	Endpoint: /livro/{id}
•	Descrição: Atualiza os detalhes de um livro existente.
Parâmetros de URL:
•	id (obrigatório): ID do livro a ser atualizado.
Corpo da Requisição:
json
Copiar código
{
  "titulo": "O Hobbit - Edição Especial",
  "autor": "J.R.R. Tolkien",
  "isbn": "978-0-345-33968-3",
  "anoPublicacao": 1937
}
Resposta:
•	Código de Sucesso: 200 OK
•	Código de Erro: 404 Not Found (se o livro não for encontrado)
•	Corpo da Resposta:
json
Copiar código
{
  "id": 3,
  "titulo": "O Hobbit - Edição Especial",
  "autor": "J.R.R. Tolkien",
  "isbn": "978-0-345-33968-3",
  "anoPublicacao": 1937
}
5. Deletar Livro
•	Método: DELETE
•	Endpoint: /livro/{id}
•	Descrição: Remove um livro do banco de dados com base no ID fornecido.
Parâmetros de URL:
•	id (obrigatório): ID do livro a ser removido.
Resposta:
•	Código de Sucesso: 200 OK
•	Código de Erro: 404 Not Found (se o livro não for encontrado)
•	Corpo da Resposta:
json
Copiar código
"Livro removido com sucesso!"
Modelos de Dados
Livro
•	ID (Long): Identificador único do livro.
•	Título (String): Título do livro.
•	Autor (String): Autor do livro.
•	ISBN (String): Número ISBN do livro.
•	Ano de Publicação (int): Ano de publicação do livro.
Códigos de Resposta
•	200 OK: Solicitação bem-sucedida.
•	201 Created: Recurso criado com sucesso.
•	404 Not Found: Recurso não encontrado.
•	400 Bad Request: Solicitação malformada (não aplicável diretamente nesta API, mas útil para validação de entrada).
