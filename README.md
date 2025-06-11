# ProjetoTeste

#API Server
Mock para simular Servidor de API







#Teste API
######################################################
Testes de API utiliza servidor API para execução

Foi Utilizado Cypress para rodar os testes.

Para iniciar a API:
cd "Projeto Teste\API Server\"
node server.js

Para executar o teste utilize o seguinte comando:
npx cypress run

Para gerar o relatório:
Relatório é gerado automaticamente na pasta Teste "API\cypress\reports"

Dependências:
Node.js
cypress
Express
cypress-mochawesome-reporter
######################################################





######################################################
#Teste E2E

Foi utilizado Selenium Webdriver em Java e cucumber

Para executar basta executar mvn test ou rodar o junit

Dependências no pom:
Java
Selenium
Cucumber
######################################################





######################################################
#Teste de Performance

Foi utilizado k6 para teste de performance

Para iniciar a API:
cd "Projeto Teste\API Server\"
node server.js

Para executar o teste utilize o seguinte comando:
k6 run load-test.js

Para gerar o relatório:
node generate-report.js

Dependências:
Node.js
k6
Express




######################################################
#Teste CI

configuração git ci.

Teste executado no repositório disponibilizado.

name: Run Selenium Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up Java 19
        uses: actions/setup-java@v3
        with:
          java-version: '19'
          distribution: 'temurin'

      - name: Build with Maven
        run: mvn clean install
        working-directory: ./Teste E2E

      - name: Run Tests
        run: mvn test
        working-directory: ./Teste E2E
######################################################
