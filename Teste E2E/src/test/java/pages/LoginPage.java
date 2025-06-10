package pages;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Common;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);        
        assertTrue(Common.clickElement(driver, "CSS", "input[type='submit']", 10));
    }    

    public void valida(String mensagem) {
        WebElement loggedMessage = Common.findElement(driver, "XPATH", "//h3[@data-test='error']", 5); 
        assertNotNull(loggedMessage);
        assertTrue(loggedMessage.getText().contains(mensagem));
    }
}
