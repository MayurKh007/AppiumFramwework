package com.Android.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions
{
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public double getFormatedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void longpressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public void swipeDemo(WebElement ele, String direction)
	{

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), 
				"direction", direction, 
				"percent", 0.75));
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}

}
