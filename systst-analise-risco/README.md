# Teste Sinistro :: Analise de risco
Este projeto é um teste de seleção. 

## Configurações de ambiente
**Spring Boot Standalone**  
**CONTEXTO / SWAGGER **: http://localhost:8080/sin/systst-analise-risco/swagger-ui.html

**FILE-NAME**: systst-analise-risco.jar  

**USUARIO DE BANCO DE DADOS**: **parte do teste**.  

## Orientações :

**1 - Criar a sua branch apartir da master com o código informando pela consultoria**

**2 - Criar a regra que classifica o risco do veiculo pelo ano :**

-- se ano form inferior a 2010 : risco alto

-- se o ano estiver entre 2010 (inclusivo) e 2015 (exclusivo): risco médio

-- se o ano for 2015 ou superior : risco baixo

**3 - Criar uma consulta para listar os veiculos pela classificação de risco;**

**4 - Criar uma interface gráfica ( preferência angular ) para listar todos os veiculos ;**

**5 - Implementar a persistência em base de dados ( mysql )**
