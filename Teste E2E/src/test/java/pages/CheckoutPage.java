package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Common;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void efetuarCheckout(String firstName, String lastName, String postalCode) { 
    	Common.waitForPageLoad(driver, 30);  	
    	assertTrue(Common.typeElement(driver, "ID", "first-name", 5, firstName, true));
    	assertTrue(Common.typeElement(driver, "ID", "last-name", 5, lastName, true));
    	assertTrue(Common.typeElement(driver, "ID", "postal-code", 5, postalCode, true));  
    	assertTrue(Common.clickJsElement(driver, "ID", "continue", 5, true));  	
    }
    
    public void validarPreco(String price) {
    	WebElement element = Common.findElement(driver, "CSS", "div[class='summary_total_label']", 5);
        assertNotNull(element);
        assertTrue(element.getText().contains(price));
    }

    public void finalizarCheckout() {
    	assertTrue(Common.clickElement(driver, "ID", "finish", 10, true));
    	WebElement element = Common.findElement(driver, "XPATH", "//h2[@class='complete-header']", 5);
        assertNotNull(element);
        assertTrue(element.getText().contains("Thank you for your order!"));
    }
    
    public void ValidoQuantidade(int qntd) {
    	assertEquals(Common.countElements(driver, "XPATH", "//div[@class='cart_item']", 60), qntd);    	
    }
}
