Feature: Login and navigate

  Scenario Outline: Realizar login e validar resultado
    Given Eu abro a pagina de login
    When Eu logo com usuario "<usuario>" e senha "<senha>"
    Then <resultado>

    Examples:
      | usuario         | senha         | resultado                                                                 |
      | standard_user   | secret_sauce  | Devo ser direcionado para pagina de produtos                              |
      | standard_userd  | secret_sauce  | Devo receber mensagem "Username and password do not match any user in this service" |
      | standard_user   | secret_sauc   | Devo receber mensagem "Username and password do not match any user in this service" |