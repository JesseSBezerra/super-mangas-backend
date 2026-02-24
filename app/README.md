# Super Mangas Backend - Read-Only API

API REST para leitura de dados do banco de dados Super Mangas, desenvolvida com Spring Boot 4.0.3 e Java 17.

## 🚀 Tecnologias

- Java 17
- Spring Boot 4.0.3
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- PostgreSQL (configurado conforme variáveis de ambiente)
- IDE com suporte a Lombok (IntelliJ IDEA, Eclipse, VS Code)

## ⚠️ Configuração do Lombok na IDE

**IMPORTANTE:** Este projeto usa Lombok para reduzir código boilerplate. Você precisa habilitar o processamento de anotações na sua IDE:

### IntelliJ IDEA
1. `File` → `Settings` → `Build, Execution, Deployment` → `Compiler` → `Annotation Processors`
2. Marque `Enable annotation processing`
3. `Build` → `Rebuild Project`

### Eclipse
1. Baixe e execute o instalador: https://projectlombok.org/setup/eclipse
2. Aponte para o executável do Eclipse
3. Reinicie e reconstrua o projeto

### VS Code
1. Instale "Language Support for Java(TM) by Red Hat"
2. Instale "Lombok Annotations Support for VS Code"
3. Recarregue a janela

**Se você ver erros de compilação relacionados ao Lombok**, consulte o arquivo `TROUBLESHOOTING.md`.

## ⚙️ Configuração

### Variáveis de Ambiente

Configure as seguintes variáveis de ambiente para conexão com o banco de dados:

```bash
DB_HOST=localhost
DB_PORT=5432
DB_NAME=hub_manga_db
DB_USER=manga_user
DB_PASSWORD=manga_password
```

Ou utilize os valores padrão já configurados no `application.properties`.

### Docker Compose (PostgreSQL)

Se você estiver usando o Docker Compose para o PostgreSQL, certifique-se de que o container está rodando:

```yaml
services:
  postgres:
    image: postgres:15-alpine
    container_name: hub-manga-postgres
    environment:
      POSTGRES_USER: manga_user
      POSTGRES_PASSWORD: manga_password
      POSTGRES_DB: hub_manga_db
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    restart: unless-stopped
```

Inicie o container:
```bash
docker-compose up -d
```

## 🏃 Como Executar

### Usando Maven

```bash
mvn clean install
mvn spring-boot:run
```

### Usando Maven Wrapper (Windows)

```bash
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Endpoints da API

### Mangas

- **GET** `/api/mangas` - Lista todos os mangás (paginado)
  - Parâmetros: `page`, `size`, `sort`
  - Exemplo: `/api/mangas?page=0&size=20&sort=id,desc`

- **GET** `/api/mangas/{id}` - Busca mangá por ID

- **GET** `/api/mangas/search?title={title}` - Busca mangás por título (paginado)
  - Exemplo: `/api/mangas/search?title=naruto&page=0&size=10`

### Capítulos

- **GET** `/api/chapters/manga/{mangaId}` - Lista capítulos de um mangá (paginado)
  - Exemplo: `/api/chapters/manga/1?page=0&size=20`

- **GET** `/api/chapters/manga/{mangaId}/all` - Lista todos os capítulos de um mangá

- **GET** `/api/chapters/{id}` - Busca capítulo por ID

### Páginas

- **GET** `/api/pages/chapter/{chapterId}` - Lista páginas de um capítulo (paginado)
  - Exemplo: `/api/pages/chapter/1?page=0&size=50`

- **GET** `/api/pages/chapter/{chapterId}/all` - Lista todas as páginas de um capítulo

- **GET** `/api/pages/{id}` - Busca página por ID

### Gêneros

- **GET** `/api/genres/manga/{mangaId}` - Lista gêneros de um mangá

- **GET** `/api/genres/search?genre={genre}` - Busca mangás por gênero
  - Exemplo: `/api/genres/search?genre=Ação`

### Metadados

- **GET** `/api/metadata/manga/{mangaId}` - Lista metadados de um mangá

- **GET** `/api/metadata/manga/{mangaId}/key/{metaKey}` - Busca metadado específico

## 📄 Estrutura do Projeto

```
src/main/java/br/com/jdsb/supermangasbackend/
├── controller/          # Controladores REST
├── dto/                 # Data Transfer Objects
├── entity/              # Entidades JPA
├── exception/           # Tratamento de exceções
├── repository/          # Repositórios JPA
└── service/             # Camada de serviço
```

## 🗃️ Estrutura do Banco de Dados

- **mangas** - Informações principais dos mangás
- **manga_chapters** - Capítulos dos mangás
- **chapter_pages** - Páginas dos capítulos
- **manga_genres** - Gêneros associados aos mangás
- **manga_metadata** - Metadados adicionais dos mangás

## 📝 Paginação

A API utiliza paginação padrão do Spring Data:

- **page**: Número da página (começa em 0)
- **size**: Quantidade de itens por página (padrão: 20, máximo: 100)
- **sort**: Campo e direção de ordenação (ex: `id,desc`)

Exemplo de resposta paginada:

```json
{
  "content": [...],
  "pageable": {...},
  "totalPages": 10,
  "totalElements": 200,
  "size": 20,
  "number": 0
}
```

## 🔒 Características

- **Read-Only**: API configurada apenas para leitura (sem operações de escrita)
- **Transações**: Todas as operações de serviço são transacionais com `readOnly=true`
- **Lazy Loading**: Relacionamentos configurados com carregamento lazy para otimização
- **Exception Handling**: Tratamento global de exceções com respostas padronizadas

## 📦 Build

Para gerar o JAR da aplicação:

```bash
mvn clean package
```

O arquivo JAR será gerado em: `target/super-mangas-backend-0.0.1-SNAPSHOT.jar`

## 🐳 Docker (Opcional)

Para executar com Docker, certifique-se de que o PostgreSQL está acessível e configure as variáveis de ambiente adequadamente.

## 📞 Suporte

Para questões e suporte, entre em contato com a equipe de desenvolvimento.
