Feature: Login and navigate

  Scenario: Logar com sucesso e validar pagina incial
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauce"
    Then Devo ser direcionado para pagina de produtos
    
  Scenario: Logar com falha usuario incorreto
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_userd" e senha "secret_sauce"
    Then Devo receber mensagem "Username and password do not match any user in this service"
    
    
  Scenario: Logar com falha senha incorreto
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauc"
    Then Devo receber mensagem "Username and password do not match any user in this service"