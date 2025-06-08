# Dismoto Desafio

Este projeto é voltado para ser entregue a Dismoto Honda, a cópia desses arquivos não estão autorizados sem permissão.

### Requisitos
Java 21 instalado em sua máquina.
Não é necessário estar com o Docker instalado, mas se estiver irá facilitar o processo de utilização e se possuir o Docker Desktop será ainda mais fácil.
A API está configurada para utilizar o PostgreSQL, caso queira utilizar outro banco de dados é necessário modificações.
É necessário que o banco de dados possua senha.

### 1 - Faça a clonagem do repositório
Clone o repositório e sua máquina

### 2 - Criar o arquivo .env
É necessário a criação de um arquivo .env e adicionar as variáveis requisitadas no arquivo .env.example.

```
SPRING_DATABASE_URL=jdbc:postgresql://localhost:5432/${USERNAME}
DATABASE_USERNAME=
DATABASE_PASSWORD=
DATABASE_NAME=
DOCKER_DATABASE_URL=jdbc:postgresql://db:5432/${USERNAME}
```

Não modifique, no DOCKER_DATABASE_URL o db:5432, pois está atrelado direto ao docker-compose da aplicação.

### 3 - Rodar o arquivo docker-compose
Se seu computador já possui o Docker e está rodando normalmente, após clonar o repositório e colocar as variáveis de ambiente basta rodar o arquivo utilizando esse comando:

```
docker-compose up --build
```

É importante deixar que o processo ocorra até o final, pois possa ser que demore a criar a imagem ou tenha algumas pequenas pausas, mas para garantir que vai estar rodando, 
basta conferir a última linha de código que vai estar parecido com algo assim:
```

**Não copiar esta linha, ela não possui nenhuma funcionalidade, serve apenas para fins demonstrativos

backend-1   | 2025-06-08T22:51:16.640Z  INFO 1 --- [product list] [           main] c.list.products.ProductListApplication  
 : Started ProductListApplication in 7.121 seconds (process running for 8.262)
```

Após isso, se tudo foi configurado da forma correta, então estará funcionando sem problemas.

### 4 - Acessar o site
Quando a aplicação estiver rodando, basta acessar esse link:
(http://localhost:4200/index.html)[http://localhost:4200/index.html]

Caso acesse direto pelo Docker Desktop, haverá um erro, direcionando direto para uma página do nginx, por isso é necessário colocar o /index.html, 
para que o site possa reconhecer a página original da aplicação.

## Utilizando sem o Docker

Aqui serve para mostrar como rodar de forma local, sem a utilização do Docker

### 1 - Baixe as dependências do Java e do Angular
No terminal execute o seguinte comando:

```
npm install
```

Em seguida, troque para a pasta onde o site está localizado:

```
cd site
```

Então rode o mesmo comando para instalar as dependências do site:

```
npm install
```

Depois volte para a pasta raiz com o comando:

```
cd ..
```

### 2 - Rode o site localmente
Então basta acessar tanto o site quanto a api rodando o comando:

```
npm run start
```

É o mesmo link para ambos os métodos: (http://localhost:4200/index.html)[http://localhost:4200/index.html]

### Considerações
As configurações do .env são necessárias para ambos os métodos, independente de qual seja é necessário configurá-lo corretamente.
Se for necessário rodar apenas a API, basta colocar esse comando no terminal:

```
./mvnw spring-boot:run
```

Os endpoints são:

- GET http://localhost:8080/products = Retorna a lista de todos os produtos.
- GET http://localhost:8080/products/<number> = Retorna um produto específico.
- POST http://localhost:8080/products = Cria um produto novo.
- PATCH http://localhost:8080/products/<number> = Atualiza um produto existente.
- DELETE http://localhost:8080/products/<number> = Deleta um produto existente

Ter em mente que é para substituir o <number> pelo número do ID do produto.


## Considerações finais
Caso haja algum tipo de dificuldade, basta entrar em contato e terei o prazer de ajudar.

