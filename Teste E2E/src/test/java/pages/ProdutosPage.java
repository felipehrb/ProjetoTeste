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

    public ProdutosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void valida() {
        WebElement loggedMessage = Common.findElement(driver, "XPATH", "//span[text()='Products']", 60); 
        assertNotNull(loggedMessage);
    }
    
    public void logout() {
    	assertTrue(Common.clickElement(driver, "XPATH", "//a[@href='/logout']", 60));
    }

    public void adicionarCarrinho(String produto) {
    	assertTrue(Common.clickElement(driver, "XPATH", "//div[.//div[text()='" + produto + "']]//button[contains(text(),'Add to cart')]", 60));
    }

    public void irCarrinho() {
    	assertTrue(Common.clickElement(driver, "ID", "shopping_cart_container", 60));
    }
    
    public void irCheckout() {
    	assertTrue(Common.clickElement(driver, "ID", "checkout", 60));
    }
}
