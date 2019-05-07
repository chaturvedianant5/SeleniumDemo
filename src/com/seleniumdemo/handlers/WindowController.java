/**
 * 
 */
package com.seleniumdemo.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumdemo.model.User;

/**
 * @author Anant
 *
 */
public class WindowController {
	
	private static final String BASE_URL = 
	"https://accounts.google.com/signin/v2/identifier"
	+ "?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

	public static void openWindowForUser(User user, WebDriver chromeDriver) {

		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(BASE_URL);
		WebElement usernameField = chromeDriver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		usernameField.sendKeys(user.getUsername());
		WebElement userNextButton = chromeDriver.findElement(By.cssSelector("#identifierNext > content > span"));
		userNextButton.click();
		
		// Password field to be used
		// Wait added here as the page would reload.
		WebElement passwordField = new WebDriverWait(chromeDriver, 10).
				until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		passwordField.sendKeys(user.getPassword());
		WebElement passwordNextButton = chromeDriver.findElement(By.cssSelector("#passwordNext > content > span"));
		passwordNextButton.click();
	}

}
