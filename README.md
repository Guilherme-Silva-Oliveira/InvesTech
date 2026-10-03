# InvesTech

Sistema de gestão de investimentos desenvolvido em Java com Spring Boot, focado em cadastro de usuários, contas, carteiras, ativos, movimentações, decisões, parâmetros e propostas de investimento.

## Visão geral

O InvesTech centraliza o fluxo de operações financeiras e análise de ativos em uma API REST, com integração de mensageria via RabbitMQ para processamento assíncrono de propostas e decisões. A solução foi pensada para apoiar operações de controle de saldo, acompanhamento de carteira e regras de investimento.

## Principais funcionalidades

- Cadastro de usuários
- Gestão de contas e carteiras
- Cadastro de ativos e parâmetros de investimento
- Registro de movimentações financeiras
- Geração e processamento de propostas de compra/venda
- Publicação de eventos em RabbitMQ para integração com fluxos assíncronos
- Documentação automática da API com Swagger/OpenAPI
- Persistência em banco MySQL

## Stack tecnológica

- Java 21
- Spring Boot 3 / Spring Web / Spring Data JPA / Validation
- MySQL
- RabbitMQ
- Maven
- Swagger OpenAPI
- Lombok

## Estrutura do projeto

```text
InvesTech/
├── src/
│   ├── main/
│   │   ├── java/com/web/investech/
│   │   │   ├── adapter/
│   │   │   │   ├── input/
│   │   │   │   │   ├── controller/
│   │   │   │   │   └── dto/
│   │   │   │   └── output/
│   │   │   │       ├── adapter/
│   │   │   │       ├── mq/
│   │   │   │       └── repository/
│   │   │   ├── application/
│   │   │   │   ├── domain/
│   │   │   │   ├── exception/
│   │   │   │   ├── port/
│   │   │   │   └── service/
│   │   │   └── config/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

## Requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- Java 21+
- Maven ou Maven Wrapper (já incluído)
- MySQL
- RabbitMQ

## Configuração do ambiente

O projeto usa variáveis de ambiente para conexão com banco e servidor. No arquivo `src/main/resources/application.properties`, já existem defaults para:

- Porta do servidor: `8081`
- Banco: `investech`
- Usuário do banco: `root`
- Host do MySQL: `localhost`
- Porta do MySQL: `3306`

Você pode sobrescrever essas configurações usando variáveis de ambiente, por exemplo:

```bash
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=investech
export DB_USERNAME=root
export DB_PASSWORD=sua_senha
export SERVER_PORT=8081
```

Além disso, o RabbitMQ deve estar rodando localmente com os parâmetros padrão configurados em `RabbitMQConfig`.

## Como executar

### Opção 1: usando Maven Wrapper

```bash
./mvnw spring-boot:run
```

No Windows:

```powershell
mvnw.cmd spring-boot:run
```

### Opção 2: compilando o projeto

```bash
./mvnw clean package
java -jar target/investech-0.0.1-SNAPSHOT.jar
```

## Endpoints principais

A API principal está organizada por versão e segue o padrão:

- `POST /v1/usuarios`
- `POST /v1/contas`
- `POST /v1/carteiras`
- `POST /v1/ativos`
- `POST /v1/movimentacoes`
- `POST /v1/parametros`
- `POST /v1/decisoes`

A documentação interativa fica disponível em:

```text
http://localhost:8081/swagger-ui/index.html
```

## Exemplos de uso

### 1) Cadastrar um usuário

```bash
curl -X POST http://localhost:8081/v1/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Souza",
    "email": "maria@email.com",
    "senha": "123456"
  }'
```

### 2) Cadastrar uma conta

```bash
curl -X POST http://localhost:8081/v1/contas \
  -H "Content-Type: application/json" \
  -d '{
    "moedaBase": "BRL",
    "centroOperacao": "São Paulo",
    "usuarioId": 1
  }'
```

### 3) Cadastrar um ativo

```bash
curl -X POST http://localhost:8081/v1/ativos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "PETR4",
    "tipoAtivo": "ACAO",
    "precoAtual": 32.75
  }'
```

### 4) Cadastrar uma carteira

```bash
curl -X POST http://localhost:8081/v1/carteiras \
  -H "Content-Type: application/json" \
  -d '{
    "saldoDisponivel": 5000.00,
    "saldoInvestido": 1500.00,
    "saldoTotal": 6500.00,
    "lucroRegistrado": 0.0,
    "prejuizoRegistrado": 0.0,
    "contaId": 1
  }'
```

### 5) Cadastrar um parâmetro

```bash
curl -X POST http://localhost:8081/v1/parametros \
  -H "Content-Type: application/json" \
  -d '{
    "quantidadeMaxima": 100.0,
    "precoMinimo": 20.0,
    "precoMaximo": 50.0,
    "ativoNome": "PETR4",
    "tipoAtivo": "ACAO",
    "carteiraId": 1
  }'
```

## Fluxo de mensageria

O projeto define exchanges e filas para eventos de proposta, parâmetro e decisão:

- `exchange_proposta`
- `queue_proposta`
- `exchange_parametro`
- `queue_parametro`
- `exchange_decisao`
- `queue_decisao`

Esse fluxo permite desacoplar a criação de propostas e decisões do processamento principal da API, tornando a aplicação mais escalável e preparada para integrações futuras.

## Observações importantes

- O projeto está estruturado em camadas: controller, service, ports, adapters e repositories.
- A aplicação usa JPA para persistência e integrações via mensageria para eventos de negócio.
- O arquivo `application.properties` deve ser ajustado conforme o ambiente em que a aplicação será executada.
- Para produção, recomenda-se usar credentials e configurações de banco/rabbit fora do código-fonte.

## Contribuição

Para contribuir com o projeto:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção.
3. Realize as alterações e teste localmente.
4. Abra um pull request descrevendo a mudança.

## Licença

Este projeto não possui licença definida no repositório. Verifique a política do projeto antes de distribuir ou reutilizar o código em outros contextos.
