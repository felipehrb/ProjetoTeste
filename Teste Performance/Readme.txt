K6 Teste de performance API login

Para iniciar a API:
cd "Projeto Teste\API Server\"
node server.js

Para executar o teste utilize o seguinte comando:
k6 run load-test.js

Para gerar o relatório:
node generate-report.js



Dependecias:
Node.js
k6
Express
