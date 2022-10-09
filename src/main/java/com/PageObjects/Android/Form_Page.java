package com.PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Android.Utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Form_Page extends AndroidActions {

	AndroidDriver driver;

	public Form_Page(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Page Locaters

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleRadio;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleRadio;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement dropdownButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;

	// Page Actions

	public void setNameField(String name) throws InterruptedException {
		Thread.sleep(5000);
		nameField.sendKeys(name);
		driver.hideKeyboard();

	}

	public void selectRadioButton(String gender) {
		if (gender.contains("female"))

			femaleRadio.click();

		else

			maleRadio.click();

	}

	public void setCountrySelection(String countryName) {
		dropdownButton.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
	}

	public void submitForm() {
		letsShopButton.click();
	}

}
