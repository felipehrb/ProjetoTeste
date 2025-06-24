package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Common;

public class ProdutosPage {
    WebDriver driver;

    private String productsLabel = "//span[text()='Products']";
    private String logoutBtn = "\"//a[@href='/logout']\"";
    private String carrinhoBtn = "shopping_cart_container";
    private String checkoutBtn = "checkout";
    
    public ProdutosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void valida() {
        WebElement loggedMessage = Common.findElement(driver, "XPATH", productsLabel, 60); 
        assertNotNull(loggedMessage);
    }
    
    public void logout() {
    	assertTrue(Common.clickElement(driver, "XPATH", logoutBtn, 60));
    }

    public void adicionarCarrinho(String produto) {
    	assertTrue(Common.clickElement(driver, "XPATH", "//div[.//div[text()='" + produto + "']]//button[contains(text(),'Add to cart')]", 60));
    }

    public void irCarrinho() {
    	assertTrue(Common.clickElement(driver, "ID", carrinhoBtn, 60));
    }
    
    public void irCheckout() {
    	assertTrue(Common.clickElement(driver, "ID", checkoutBtn, 60));
    }
}
