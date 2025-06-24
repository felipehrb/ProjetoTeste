package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        
      ChromeOptions options = new ChromeOptions();
     // options.addArguments("--headless=new");
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--disable-gpu");
      options.addArguments("--window-size=1920,1080");    
      options.addArguments("--disable-save-password-bubble");
      options.addArguments("--incognito"); 
      
      driver = new ChromeDriver(options);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
