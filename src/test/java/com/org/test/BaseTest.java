package com.org.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {

	public static AndroidDriver driver;

	@BeforeClass
	public static void testapp() throws MalformedURLException

	{

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Mayur-Emulator");
		options.setChromedriverExecutable("D:\\Appium\\chromedriverForAppium\\chromedriver_win32\\chromedriver.exe");
		options.setApp(
				"C:\\\\Users\\\\mayur\\\\eclipse-workspace\\\\Appium\\\\src\\\\test\\\\java\\\\resources\\\\General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		// URL url = new URL("http://127.0.0.1:4723/wd/hub");

		/*
		 * DesiredCapabilities Code to launch App DesiredCapabilities cap = new
		 * DesiredCapabilities();
		 * 
		 * cap.setCapability("deviceName", "Mayur-Emulator");
		 * cap.setCapability("platformName", "Android");
		 * cap.setCapability("platformVersion", "11.0"); cap.setCapability("udid",
		 * "emulator-5554");
		 * 
		 * // cap.setCapability(MobileCapabilityType.APP,
		 * "C:\\Users\\mayur\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk"
		 * );
		 * 
		 * cap.setCapability(MobileCapabilityType.APP,
		 * "C:\\Users\\mayur\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk"
		 * );
		 * 
		 * URL url = new URL("http://127.0.0.1:4723/wd/hub"); driver = new
		 * AndroidDriver(url, cap);
		 */

	}

	public double getFormatedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void longpressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
