package com.nagarro.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ProgressBarTest 
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

		driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Show Progress Bar for a while')]")).click();
		
		Thread.sleep(5000);
		
        List<WebElement> inputFields = driver.findElements(By.className("android.widget.Input"));
        
		for(WebElement input : inputFields)
		{
            System.out.println(input.getText());
			System.out.println(input.isDisplayed());
		}

	}

}
