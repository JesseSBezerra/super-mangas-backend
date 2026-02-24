# Documentação da API - Super Mangas Backend

## 📁 Conteúdo

- `insomnia-collection.json` - Collection do Insomnia com todos os endpoints da API

## 🚀 Como Usar a Collection do Insomnia

### 1. Importar a Collection

1. Abra o **Insomnia**
2. Clique em `Application` → `Preferences` → `Data` → `Import Data`
3. Selecione `From File`
4. Navegue até `doc/insomnia-collection.json`
5. Clique em `Import`

### 2. Configurar o Ambiente

A collection já vem com um ambiente base configurado:

- **base_url**: `http://localhost:8080`

Se sua API estiver rodando em outra porta ou host, você pode editar:

1. Clique no dropdown de ambientes (canto superior esquerdo)
2. Selecione `Manage Environments`
3. Edite o valor de `base_url`

### 3. Estrutura da Collection

A collection está organizada em 5 grupos:

#### 📚 **Mangas**
- `GET /api/mangas` - Lista todos os mangás (paginado)
- `GET /api/mangas/{id}` - Busca mangá por ID
- `GET /api/mangas/search?title={title}` - Busca mangás por título

#### 📖 **Chapters**
- `GET /api/chapters/manga/{mangaId}` - Lista capítulos de um mangá (paginado)
- `GET /api/chapters/manga/{mangaId}/all` - Lista todos os capítulos de um mangá
- `GET /api/chapters/{id}` - Busca capítulo por ID

#### 📄 **Pages**
- `GET /api/pages/chapter/{chapterId}` - Lista páginas de um capítulo (paginado)
- `GET /api/pages/chapter/{chapterId}/all` - Lista todas as páginas de um capítulo
- `GET /api/pages/{id}` - Busca página por ID

#### 🏷️ **Genres**
- `GET /api/genres/manga/{mangaId}` - Lista gêneros de um mangá
- `GET /api/genres/search?genre={genre}` - Busca mangás por gênero

#### 📋 **Metadata**
- `GET /api/metadata/manga/{mangaId}` - Lista metadados de um mangá
- `GET /api/metadata/manga/{mangaId}/key/{metaKey}` - Busca metadado específico

## 📝 Exemplos de Uso

### Listar Mangás com Paginação

```
GET http://localhost:8080/api/mangas?page=0&size=20&sort=id,desc
```

**Parâmetros:**
- `page`: Número da página (começa em 0)
- `size`: Quantidade de itens por página (padrão: 20, máximo: 100)
- `sort`: Campo e direção de ordenação (ex: `id,desc`, `title,asc`)

**Resposta:**
```json
{
  "content": [
    {
      "id": 1,
      "title": "Naruto",
      "imageUrl": "https://...",
      "synopsis": "...",
      "genres": ["Ação", "Aventura"],
      "totalChapters": 700
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20
  },
  "totalPages": 50,
  "totalElements": 1000
}
```

### Buscar Mangá por Título

```
GET http://localhost:8080/api/mangas/search?title=naruto&page=0&size=10
```

### Listar Capítulos de um Mangá

```
GET http://localhost:8080/api/chapters/manga/1?page=0&size=20
```

### Listar Páginas de um Capítulo

```
GET http://localhost:8080/api/pages/chapter/1/all
```

### Buscar Mangás por Gênero

```
GET http://localhost:8080/api/genres/search?genre=Ação
```

## 🔧 Testando a API

1. Certifique-se de que a API está rodando:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```

2. Certifique-se de que o PostgreSQL está rodando:
   ```bash
   docker-compose up -d
   ```

3. Abra o Insomnia e execute as requisições

## 📊 Códigos de Resposta

- `200 OK` - Requisição bem-sucedida
- `404 Not Found` - Recurso não encontrado
- `500 Internal Server Error` - Erro no servidor

## 💡 Dicas

- Use os parâmetros de paginação para controlar a quantidade de dados retornados
- Todos os endpoints de listagem suportam paginação
- A busca por título é case-insensitive
- Os IDs nas URLs são exemplos, substitua pelos IDs reais do seu banco de dados

## 🔗 Links Úteis

- [Documentação Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Insomnia Documentation](https://docs.insomnia.rest/)
