package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Common;
import utils.Hooks;

public class CheckoutSteps {
    WebDriver driver = Hooks.driver;
    ProdutosPage ProdutosPage = new ProdutosPage(driver);
    CheckoutPage CheckoutPage = new CheckoutPage(driver);

    @When("Adiciono os produtos no carrinho:")
    public void adicionoOsProdutosNoCarrinho(DataTable produtos) {
        List<String> listaDeProdutos = produtos.asList();

        for (String produto : listaDeProdutos) {
        	if(produto == null) {
        		continue;
        	}
            ProdutosPage.adicionarCarrinho(produto);
        }
    }

    @When("Clico em ir para carrinho")
    public void Clico_em_ir_para_carrinho() {
    	ProdutosPage.irCarrinho();
    }
    
    @When("Clico em checkout")
    public void Clico_em_ir_para_checkouto() {
    	ProdutosPage.irCheckout();
    }

    @When("Valido carrinho com {int} items")
    public void Valido_carrinho_com_items(int qntd) {
    	CheckoutPage.ValidoQuantidade(qntd);
    }

    @When("Preencho as informacoes de checkout com {string}, {string}, {string}")
    public void Preencho_as_informacoes_de_checkout_com(String firstName, String lastName, String zip) {
    	CheckoutPage.efetuarCheckout(firstName, lastName, zip);
    }

    @Then("Valido o preco total {string}")
    public void Valido_o_preco_total(String price) {
    	CheckoutPage.validarPreco(price);
    }
    
    @Then("Finalizo o checkout")
    public void Finalizo_o_checkout() {
    	CheckoutPage.finalizarCheckout();
    }
}
