package com.org.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.Android.Form_Page;
import com.PageObjects.Android.Products_Page;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_HybridApp extends BaseTest {
	@Test
	public void eCommerce_TC_01() throws InterruptedException

	{

		Form_Page formpage = new Form_Page(driver);
		formpage.setNameField("Mayur");
		formpage.selectRadioButton("Male");
		formpage.setCountrySelection("Argentina");
		formpage.submitForm();
		
		
		Products_Page pg=new Products_Page(driver);
		pg.addToCartByIndex(0);
		pg.addToCartByIndex(0);
		pg.addToCartClick();

		// Launch App, Select dropdown, Enter text, Select dropdown,Click on Add to cart
		// icon
		// Click on add to cart icon on top right, Wait until cart Page is loaded,
		// Verify Whether product is added to cart.
		// Note for Add to cart icon properties are same.

		// Click on lets shop button




		// Wait until the cart page is visible

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

		wait.until(ExpectedConditions.attributeContains(
				driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		List<WebElement> productprice = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

		int count = productprice.size();

		double totalsum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productprice.get(i).getText();

			double price = Double.parseDouble(amountString.substring(1));
			totalsum = totalsum + price; // 160.97+120.0=280

		}

		String totalPurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
				.getText();

		double displayformatedamout = getFormatedAmount(totalPurchaseAmount);

		Assert.assertEquals(totalsum, displayformatedamout);

		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		longpressAction(ele);

		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(3000);

		Set<String> contexts = driver.getContextHandles();

		for (String Contextnames : contexts) {
			System.out.println(Contextnames);
		}

		driver.context("WEBVIEW_com.androidsample.generalstore");

		driver.findElement(By.name("q")).sendKeys("Mayur Automation Labs");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");

	}

}
