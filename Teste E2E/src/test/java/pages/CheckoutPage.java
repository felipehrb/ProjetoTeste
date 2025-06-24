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

    private String firstNameInput = "first-name";
    private String lastNameInput = "last-name";
    private String postalCodeInput = "postal-code";
    private String continueButton = "continue";
    private String finishButton = "finish";
    private String mensagemCheckout = "//h2[@class='complete-header']";
    private String itemCard = "//div[@class='cart_item']";
    private String summaryTotal = "div[class='summary_total_label']";
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void efetuarCheckout(String firstName, String lastName, String postalCode) { 
    	Common.waitForPageLoad(driver, 30); 
    	Common.WaitBeClickable(driver, "ID", "continue", 5);
    	preencheCheckout(firstName, lastName, postalCode);
    	assertTrue(validaCheckou(firstName, lastName, postalCode, 4));
    	assertTrue(Common.clickJsElement(driver, "ID", continueButton, 5, true));
    }
    
    private void preencheCheckout(String firstName, String lastName, String postalCode) {
    	assertTrue(Common.typeElement(driver, "ID", firstNameInput, 5, firstName, true));
    	assertTrue(Common.typeElement(driver, "ID", lastNameInput, 5, lastName, true));
    	assertTrue(Common.typeElement(driver, "ID", postalCodeInput, 5, postalCode, true));
    }
    
    private boolean validaCheckou(String firstName, String lastName, String postalCode, int tentativas) {
    	if(tentativas > 0 && (!Common.getValue(driver, "ID", firstNameInput, 5).equals(firstName)
    		|| !Common.getValue(driver, "ID", lastNameInput, 5).equals(lastName)
    		|| !Common.getValue(driver, "ID", postalCodeInput, 5).equals(postalCode)))
    	{
        	preencheCheckout(firstName, lastName, postalCode);
    		return validaCheckou(firstName, lastName, postalCode, tentativas-1);
    	}
    	
    	return tentativas > 0;
    }
    
    public void validarPreco(String price) {
    	WebElement element = Common.findElement(driver, "CSS", summaryTotal, 5);
        assertNotNull(element);
        assertTrue(element.getText().contains(price));
    }

    public void finalizarCheckout() {
    	assertTrue(Common.clickElement(driver, "ID", finishButton, 10, true));
    	WebElement element = Common.findElement(driver, "XPATH", mensagemCheckout, 5);
        assertNotNull(element);
        assertTrue(element.getText().contains("Thank you for your order!"));
    }
    
    public void ValidoQuantidade(int qntd) {
    	assertEquals(Common.countElements(driver, "XPATH", itemCard, 60), qntd);    	
    }
}
