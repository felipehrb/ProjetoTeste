package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public static WebElement findElement(WebDriver driver, String selector, String selectorName, int time) {
		WebElement element = null;
		try {		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			
			switch (selector.toUpperCase()) {
				case "XPATH":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorName)));					
					break;
				case "ID":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selectorName)));					
					break;
				case "CSS":
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorName)));					
					break;
				default:
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selectorName)));
					break;
			}
			
		}catch (Exception e) {
			if(time == 0) {
				return null;
			}
			findElement(driver, selector, selectorName, time-1);
		}
		return element;
	}
	
	public static List<WebElement> findElements(WebDriver driver, String selector, String selectorName, int time) {
		List<WebElement> elements = new ArrayList<>();
		try {		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			
			switch (selector.toUpperCase()) {
				case "XPATH":
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selectorName)));					
					break;
				case "ID":
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(selectorName)));					
					break;
				case "CSS":
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(selectorName)));					
					break;
				default:
					elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(selectorName)));
					break;
			}
			
		}catch (Exception e) {
			if(time == 0) {
				return null;
			}
			findElement(driver, selector, selectorName, time-1);
		}
		return elements;
	}

	public static boolean clickElement(WebDriver driver, String selector, String selectorName, int time) {
		return clickElement(driver, selector, selectorName, time, false);
	}

	public static boolean clickElement(WebDriver driver, String selector, String selectorName, int time, boolean closeAlert) {
		try {		
			if(closeAlert) {Common.acceptAlertIfPresent(driver);}
			findElement(driver, selector, selectorName, time).click();
			return true;
		}catch (WebDriverException e) {
			if(time == 0) {
				return false;
			}
			clickElement(driver, selector, selectorName, time-1);
		}
		return false;
	}
	
	public static boolean clickJsElement(WebDriver driver, String selector, String selectorName, int time) {
		return clickJsElement(driver, selector, selectorName, time, false);
	}

	public static boolean clickJsElement(WebDriver driver, String selector, String selectorName, int time, boolean closeAlert) {
		try {		
			if(closeAlert) {Common.acceptAlertIfPresent(driver);}
			WebElement element = findElement(driver, selector, selectorName, time);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			return true;
		}catch (WebDriverException e) {
			if(time == 0) {
				return false;
			}
			clickJsElement(driver, selector, selectorName, time-1);
		}
		return false;
	}

	public static boolean typeElement(WebDriver driver, String selector, String selectorName, int time, String value) {
		return typeElement(driver, selector, selectorName, time, value, false);
	}
	
	public static boolean typeElement(WebDriver driver, String selector, String selectorName, int time, String value, boolean closeAlert) {
		try {		
			if(closeAlert) {Common.acceptAlertIfPresent(driver);}
			findElement(driver, selector, selectorName, time).sendKeys(value);
			return true;
		}catch (WebDriverException e) {
			if(time == 0) {
				return false;
			}
			typeElement(driver, selector, selectorName, time-1, value);
		}
		return false;
	}
	

	public static boolean typeJsElement(WebDriver driver, String selector, String selectorName, int time, String value) {
		return typeJsElement(driver, selector, selectorName, time, value, false);
	}
	
	public static boolean typeJsElement(WebDriver driver, String selector, String selectorName, int time, String value, boolean closeAlert) {
		try {		
			if(closeAlert) {Common.acceptAlertIfPresent(driver);}
			WebElement element = findElement(driver, selector, selectorName, time);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
				"arguments[0].focus();" +
			    "arguments[0].value = arguments[1];" +
			    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
			    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));" +
			    "arguments[0].blur();",
			     element, value
			);			
			return true;
		}catch (WebDriverException e) {
			if(time == 0) {
				return false;
			}
			typeJsElement(driver, selector, selectorName, time-1, value);
		}
		return false;
	}
	
	public static int countElements(WebDriver driver, String selector, String selectorName, int time) {
		try {		
			return findElements(driver, selector, selectorName, time).size();
		}catch (WebDriverException e) {
			if(time == 0) {
				return 0;
			}
			countElements(driver, selector, selectorName, time-1);
		}
		return 0;
	}
	
	public static void acceptAlertIfPresent(WebDriver driver) {
	    try {
	        Alert alert = driver.switchTo().alert();  
	        alert.accept();
	    } catch (NoAlertPresentException e) {
	    }
	}
	
	public static void waitForPageLoad(WebDriver driver, int timeoutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState")
	            .equals("complete")
	    );
	}
}
