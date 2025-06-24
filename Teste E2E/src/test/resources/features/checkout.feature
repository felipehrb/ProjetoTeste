Feature: Login and navigate

  Scenario Outline: Validar compra de produtos
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauce"
    And Devo ser direcionado para pagina de produtos
    And Adiciono os produtos no carrinho:
      | <produto1> |
      | <produto2> |
    And Clico em ir para carrinho
    And Valido carrinho com <quantidade> items
    And Clico em checkout
    And Preencho as informacoes de checkout com "<nome>", "<sobrenome>", "<cep>"
    Then Valido o preco total "<preco>"
    Then Finalizo o checkout

    Examples:
      | produto1                  | produto2               | quantidade | nome   | sobrenome | cep      | preco   |
      | Sauce Labs Bolt T-Shirt   |                        | 1          | Fulano | Silva     | 00898656 | $32.39  |
      | Sauce Labs Bolt T-Shirt   | Sauce Labs Backpack    | 2          | Fulano | Silva     | 00898656 | $43.18  |

      
  Scenario Outline: Validar compra de produtos Exibicão massa dinamica
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauce"
    And Devo ser direcionado para pagina de produtos
    And Adiciono os produtos no carrinho:
      | <produto1> |
      | <produto2> |
    And Clico em ir para carrinho
    And Valido carrinho com <quantidade> items
    And Clico em checkout
    And Preencho as informacoes de checkout com massa dinamica
    Then Valido o preco total "<preco>"
    Then Finalizo o checkout

    Examples:
      | produto1                  | produto2               | quantidade | preco   |
      | Sauce Labs Bolt T-Shirt   |                        | 1          | $32.39  |
      | Sauce Labs Bolt T-Shirt   | Sauce Labs Backpack    | 2          | $43.18  |