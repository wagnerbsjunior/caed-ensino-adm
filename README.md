# Projeto JAVA + Spring Boot + Angular

Este repositório armazena o código fonte desenvolvido por mim, visando principalmente o desenvolvimento de um projeto RestFULL com Java e Angular.


## Descrição do projeto: :pencil2:

- Disponibilizar um endpoint para receber dados de professores, respeitando um contrato que especifica o formato da informação para que o dado seja processado pelo sistema. O dados enviado para o endping deve ser validado e a persistência deve ser realizada por um sistema de integração de forma assíncrona, composto por microserviços que tratam a informação recebida e faz a persistência em um banco de dados.


## Recursos Utilizados: :computer:

* Para o back-end (API)

    - **[IntelliJ IDEA Community Edition](https://www.jetbrains.com/pt-br/idea/download/#section=windows)**
    - **[Spring Framework](https://spring.io/projects/spring-framework)**
    - **[Maven](https://mvnrepository.com/)**
    - **[H2 Database](http://h2database.com/html/main.html)**
    - **[Lombok](https://projectlombok.org/)**
    - **[JUnit](https://junit.org/junit5/)**

* Para o front-end

    - **[Visual Studio Code](https://code.visualstudio.com/)**
    - **[Fira Code](https://github.com/tonsky/FiraCode)**
    - **[Node.JS](https://nodejs.org/en/)**
    - **[Angular CLI](https://cli.angular.io/)**
    - **[Start Bootstrap Template](https://startbootstrap.com/template/sb-admin)**

* Container para execução no Linux

    - **[Docker](https://www.docker.com/)**


## Implementações adicionais: :pencil2:

 * **< Feito > Criar um front end usando também VueJS para envio das requisições**
 * **< Feito > Criar testes unitários**
 * **< Feito > Executar os serviços em containers docker**
 * Usar alguma ferramenta para auxiliar na comunicação entre os serviços
    - Apache Kafka
    - ActiveMQ
    - RabbitMQ
 * Desenvolver algum micro serviço em GoLang
 * Monitoramento dos logs
    - Elasticsearch
    - Kibana


## Rodando o projeto em ambiente Linux: :computer:

Para este projeto foram criadas duas imagens indpependentes utilizando Docker:

    * Docker image ( 1 ) - Nome: java-api - Caminho: /Docker/Dockerfile
    * Docker image ( 2 ) - Nome: angular-app - Caminho: /ensino-adm-app/Dockerfile


Para configurar a API rodar os comandos abaixo na pasta /Docker:

```
$ docker build -t java-api .

$ docker run -p 8080:8080 --name javaapi java-api
```

Para configurar a aplicação, para acesso no navegador, executar os comandos abaixo na pasta /ensino-adm-app:

```
$ docker build -t angular-app .

$ docker run -p 4200:4200 --name angularapp angular-app
```


## Testando os endpoints via terminal:  :computer:

Na pasta Docker, enviar os métodos post e get:

### Post
```
$ curl -i -X POST -H "Content-Type: application/json" -d "{\"nome\":\"wagner\",\"cpf\":\"43236560177\",\"nascimento\":\"1978-09-12\",\"sexo\":\"M\",\"email\":\"wagnerjf@gmai.com\"}" http://localhost:8080/api/professores
```

### Get
```
$ curl -i -H "Accept: application/json" -H "Content-Type application/json" -X GET http://localhost:8080/api/professores/1
```


## Acesso a aplicação no navegador: :computer:

### Endpoints da API - http://localhost:8080

    - **[ GET ](http://localhost:8080/api/professores/1)**
    - **[ POST ](http://localhost:8080/api/professores)**
    - **[ PUT ](http://localhost:8080/api/professores/1)**
    - **[ DELETE ](http://localhost:8080/api/professores/1)**

### App Web (Interface Angular)

    - **[ Home ](http://localhost:4200)**
    - **[ Lista Professores ](http://localhost:4200/cadastros/professores-lista)**   
    - **[ Cadastra Professores ](http://localhost:4200/cadastros/professores)**


## Teste unitários :computer:

Para rodar os teste unitários pelo IntelliJ, executar a função Run 'AllTests' (botão direito na pasta test/java).

![picture](doc/img007_UnitTest.png)


## Screen Shots da Aplicação Feita:

### Página Principal:

![picture](doc/img001-app-angular-telaPrincipal.png)

### Lista de Professores

![picture](doc/img002-app-angular-telaProfessoresLista.png)

### Cadastro de Professores

![picture](doc/img003-app-angular-telaProfessoresCadastro.png)


### Cadastro de Professores - Mensagens

![picture](doc/img004-app-angular-telaProfessoresCadastro-mensagens.png)

### Cadastro de Professores - Edição

![picture](doc/img005-app-angular-telaProfessoresCadastro-edicao.png)

### Cadastro de Professores - Deleção

![picture](doc/img006-app-angular-telaProfessoresLista-delecao.png)