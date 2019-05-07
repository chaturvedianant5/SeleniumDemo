/**
 * 
 */
package com.seleniumdemo.handlers;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.seleniumdemo.model.User;

/**
 * @author Anant
 *
 */
public class WorkFlowController {

	private static final String BROWSER_WINDOW_MODE = "incognito";
	private static final String DRIVER_TYPE = "webdriver.chrome.driver";
	private static final String DRIVER_EXECUTABLE = "chromedriver.exe";
	
	private static final DesiredCapabilities CAPABILITIES = DesiredCapabilities.chrome();
	private static final ChromeOptions OPTIONS = new ChromeOptions();
	
	private static final ArrayList<User> USERS_LIST = CredentialsController.getInstance().getCredentialsList();

	public static void init() {
		WorkFlowController controller = new WorkFlowController();
		controller.startWorkFlow();
	}
	
	private static void setWindowOptions() {
		OPTIONS.addArguments(BROWSER_WINDOW_MODE);
		CAPABILITIES.setCapability(ChromeOptions.CAPABILITY, OPTIONS);
		System.setProperty(DRIVER_TYPE, DRIVER_EXECUTABLE);
	}
	
	private void startWorkFlow() {
		for(int i=0; i<WorkFlowController.USERS_LIST.size(); i++) {
			final User currentUser = WorkFlowController.USERS_LIST.get(i);
			final WebDriver chromeDriver = createDriver();

			new Thread(new Runnable() {
				public void run() {
					WindowController.openWindowForUser(currentUser, chromeDriver);
				}
			}).start();
		}
	}
	
	private WebDriver createDriver() {
		WorkFlowController.setWindowOptions();
		return new ChromeDriver(CAPABILITIES);
	}

}
