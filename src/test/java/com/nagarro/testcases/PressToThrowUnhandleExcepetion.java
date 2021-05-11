package com.nagarro.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class PressToThrowUnhandleExcepetion 
{

	public static AndroidDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException 
	{
	
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		
        driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Press to throw unhandled exception')]")).click();

        
        // Verify Home screen Title => This will Fail
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, "selendroid-test-app");
		
	}

}
