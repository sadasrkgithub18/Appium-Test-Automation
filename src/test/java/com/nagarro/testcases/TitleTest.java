package com.nagarro.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TitleTest 
{

	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String actTitle = driver.getTitle();
		
		// Title Verification
		Assert.assertEquals(actTitle, "selendroid-test-app");
		
		
		List<WebElement> button = driver.findElements(By.className("android.widget.Button"));
        
		for(WebElement widButton : button)
		{
            System.out.println(widButton.getText());
			System.out.println(widButton.isDisplayed());
		}
		

	}


}
