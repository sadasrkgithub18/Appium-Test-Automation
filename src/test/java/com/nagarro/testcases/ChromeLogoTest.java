package com.nagarro.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeLogoTest 
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

		driver.findElement(MobileBy.xpath("//android.widget.Button[@name='chrome')]")).click();

		String actTitle = driver.getTitle();
		
		// Title Verification
		Assert.assertEquals(actTitle, "selendroid-test-app");
				
		
		String welText = driver.findElement(MobileBy.xpath("//android.widget.text[contains(@text,'Hello, can you')]")).getText();

		// Text Verification
		Assert.assertEquals(welText, "Hello, can you please tell me your name?");
	
	
	    // Enter Name in text-box
		driver.findElement(MobileBy.id("text-box")).clear();
		driver.findElement(MobileBy.id("text-box")).sendKeys("MS Dhoni");

	    // Select Car
		WebElement carDrop = driver.findElement(MobileBy.id("preferred-car"));
        Select select = new Select(carDrop);
        select.selectByVisibleText("Mercedes");
	
	
        // Click on send me your name button
        driver.findElement(MobileBy.xpath("//android.widget.Button[contains(@text,'Send me your name!')]")).click();
		
        
        
        String YourName = driver.findElement(MobileBy.name("your-name")).getText();
        String preferredCar = driver.findElement(MobileBy.name("selected-car")).getText();

        // Verify the selected name and car
        Assert.assertEquals(YourName, "MS Dhoni");
        Assert.assertEquals(preferredCar, "Mercedes");
    	
	
        driver.findElement(MobileBy.linkText("here")).click();
        
	    WebElement firstOp = select.getFirstSelectedOption();
	   
	    String defValue = firstOp.getText();
	    
	    // Verifying Default Value
	    Assert.assertEquals(defValue, "Volvo");
    	
	}

}
