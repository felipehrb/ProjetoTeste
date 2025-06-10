Feature: Login and navigate

  Scenario: Validar compra de 1 produto
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauce"
    And Devo ser direcionado para pagina de produtos
    And Adiciono o produto "Sauce Labs Bolt T-Shirt" no carrinho
    And Clico em ir para carrinho
    And Valido carrinho com 1 items
    And Clico em checkout
    And Preencho as informacoes de checkout com "Fulano", "Silva", "00898656"
    Then Valido o preco total "$32.39"
    Then Finalizo o checkout
    
  Scenario: Validar compra de 2 produtos
    Given Eu abro a pagina de login
    When Eu logo com usuario "standard_user" e senha "secret_sauce"
    And Devo ser direcionado para pagina de produtos
    And Adiciono o produto "Sauce Labs Bolt T-Shirt" no carrinho
    And Adiciono o produto "Sauce Labs Backpack" no carrinho
    And Clico em ir para carrinho
    And Valido carrinho com 2 items
    And Clico em checkout
    And Preencho as informacoes de checkout com "Fulano", "Silva", "00898656"
    Then Valido o preco total "$43.18"
    Then Finalizo o checkout