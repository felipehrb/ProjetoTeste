package pages;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Common;

public class LoginPage {
    WebDriver driver;

    private String userName = "user-name";
    private String password = "password";
    private String submitButton = "input[type='submit']";
    private String mensagemErro = "//h3[@data-test='error']";
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
    	assertTrue(Common.typeElement(driver, "ID", userName, 5, user, true));
    	assertTrue(Common.typeElement(driver, "ID", password, 5, pass, true));
        assertTrue(Common.clickElement(driver, "CSS", submitButton, 10));
    }    

    public void valida(String mensagem) {
        WebElement loggedMessage = Common.findElement(driver, "XPATH", mensagemErro, 5); 
        assertNotNull(loggedMessage);
        assertTrue(loggedMessage.getText().contains(mensagem));
    }
}
