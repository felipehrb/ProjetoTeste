package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Hooks;

public class LoginSteps {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    ProdutosPage ProdutosPage = new ProdutosPage(driver);

    @Given("Eu abro a pagina de login")
    public void Eu_abro_a_pagina_de_login() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("Eu logo com usuario {string} e senha {string}")
    public void Eu_logo_com_credenciais_validas(String usuario, String senha) {
        loginPage.login(usuario, senha);
    }
    
    @When("Eu clico para efetuar logout")
    public void Eu_clico_para_efetuar_logout( ) {
    	ProdutosPage.logout();
    }
    
    @Then("Devo receber mensagem {string}")
    public void Devo_receber_mensagem(String mensagem) {
    	loginPage.valida(mensagem);
    }

    @Then("Devo ser direcionado para pagina de produtos")
    public void Devo_receber_mensagem() {
    	ProdutosPage.valida();
    }
}
