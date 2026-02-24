# Troubleshooting - Erros de Compilação Lombok

## Problema Reportado

```
ChapterPageController.java:19:38
java: variable chapterPageService not initialized in the default constructor

ChapterPageService.java:43:30
java: cannot find symbol
  symbol:   method getChapterId()
  location: variable page of type ChapterPage
```

## Causa

Esses erros ocorrem porque o Lombok não processou as anotações antes da IDE tentar compilar o código. O Lombok precisa gerar:
- Construtores via `@RequiredArgsConstructor`
- Getters/Setters via `@Getter` e `@Setter`

## Soluções

### Solução 1: Habilitar Annotation Processing na IDE

**IntelliJ IDEA:**
1. Vá em `File` → `Settings` (ou `Ctrl+Alt+S`)
2. Navegue para `Build, Execution, Deployment` → `Compiler` → `Annotation Processors`
3. Marque a opção `Enable annotation processing`
4. Clique em `Apply` e `OK`
5. Faça um `Build` → `Rebuild Project`

**Eclipse:**
1. Instale o plugin Lombok: https://projectlombok.org/setup/eclipse
2. Execute o instalador do Lombok e aponte para o executável do Eclipse
3. Reinicie o Eclipse
4. Limpe e reconstrua o projeto

**VS Code:**
1. Instale a extensão "Language Support for Java(TM) by Red Hat"
2. Instale a extensão "Lombok Annotations Support for VS Code"
3. Recarregue a janela (`Ctrl+Shift+P` → "Reload Window")

### Solução 2: Rebuild do Projeto Maven

Se você tem o Java configurado no PATH, execute:

```bash
# Windows
.\mvnw.cmd clean install -DskipTests

# Linux/Mac
./mvnw clean install -DskipTests
```

### Solução 3: Invalidar Cache da IDE (IntelliJ)

1. `File` → `Invalidate Caches...`
2. Selecione `Invalidate and Restart`
3. Aguarde a IDE reiniciar e reindexar o projeto

### Solução 4: Verificar Configuração do Lombok

O arquivo `pom.xml` já está configurado corretamente com:
- Dependência do Lombok
- Annotation processor configurado no maven-compiler-plugin
- Versão explícita do Lombok (1.18.30)

O arquivo `lombok.config` também foi criado na raiz do projeto.

## Verificação

Após aplicar as soluções, verifique se:
1. A IDE reconhece os métodos gerados pelo Lombok (autocomplete funciona)
2. Não há mais erros de compilação nos arquivos
3. O projeto compila com sucesso via Maven

## Nota Importante

Esses erros são **apenas de IDE** e não impedem a execução do projeto via Maven. Se você conseguir executar:

```bash
.\mvnw.cmd spring-boot:run
```

O projeto funcionará corretamente, pois o Maven processa as anotações Lombok durante a compilação.
