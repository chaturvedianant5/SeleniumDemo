/**
 * 
 */
package com.seleniumdemo.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumdemo.model.User;

/**
 * @author Anant
 *
 */
public class WindowController {
	
	private static final String BASE_URL = "https://www.google.co.in";

	public static void openWindowForUser(User user, WebDriver chromeDriver) {

		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(BASE_URL);
		WebElement usernameField = chromeDriver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div[2]/form/div[1]/div/input"));
		WebElement passwordField = chromeDriver.findElement(By.xpath("//*[@id=\"Pass\"]"));
		WebElement loginButton = chromeDriver.findElement(By.cssSelector(
				"body > app-root > app-login > div > div > div.right-col > form > div.form-actions > button"));
		usernameField.sendKeys(user.getUsername());
		passwordField.sendKeys(user.getPassword());
		loginButton.click();
	}

}
