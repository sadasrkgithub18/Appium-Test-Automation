package com.nagarro.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class FileLogoTest 
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

		driver.findElement(MobileBy.xpath("//android.widget.Button[@name='file')]")).click();

		
        String actTitle = driver.getTitle();
		
		// Title Verification
		Assert.assertEquals(actTitle, "selendroid-test-app");
		
		
		String welText = driver.findElement(MobileBy.id("welcome-text")).getText();
		
		// Text Verification
		Assert.assertEquals(welText, "Welcome to register a new user");
			
		List<WebElement> inputFields = driver.findElements(MobileBy.className("android.widget.text-box"));

		
		for(WebElement input : inputFields)
		{
            System.out.println(input.getText());
			System.out.println(input.isDisplayed());
		}
		
		
		String nameFieldDefaultText = driver.findElement(MobileBy.id("name")).getText();
		
		// Name Verification
		Assert.assertEquals(nameFieldDefaultText, "Mr. Burns");
	
		
		WebElement pl = driver.findElement(MobileBy.id("programming-language"));
        
		Select select = new Select(pl);
        
        WebElement firstOp = select.getFirstSelectedOption();
 	   
	    String defValue = firstOp.getText();
	    
	    // Verifying Default Value
	    Assert.assertEquals(defValue, "Ruby");
    	
	    
	    
	    
	    driver.findElement(MobileBy.id("username")).sendKeys("msdhoni999");
	    driver.findElement(MobileBy.id("email")).sendKeys("user@mydoamain.com");
	    driver.findElement(MobileBy.id("password")).sendKeys("pass12345");
	    driver.findElement(MobileBy.id("name")).clear();
	    driver.findElement(MobileBy.id("name")).sendKeys("MS Dhoni");
	    select.selectByVisibleText("Java");
	    driver.findElement(MobileBy.id("check-box")).click();
	    driver.findElement(MobileBy.id("register-user")).click();
	    
	    
	    String nameVerify  = driver.findElement(MobileBy.id("name-val")).getText();
	    Assert.assertEquals(nameVerify, "MS Dhoni");
    	
	    String userNameVerify  = driver.findElement(MobileBy.id("username-val")).getText();
	    Assert.assertEquals(userNameVerify, "msdhoni999");
    	
	    String passwordVerify  = driver.findElement(MobileBy.id("password-val")).getText();
	    Assert.assertEquals(passwordVerify, "pass12345");
    	
	    String emailVerify  = driver.findElement(MobileBy.id("email-val")).getText();
	    Assert.assertEquals(emailVerify, "user@mydoamain.com");
    	
	    String accept  = driver.findElement(MobileBy.id("accept-val")).getText();
	    Assert.assertEquals(accept, true);
	    
	    String plVerify  = driver.findElement(MobileBy.id("pl-val")).getText();
	    Assert.assertEquals(plVerify, "Java");
	    
	    driver.findElement(MobileBy.id("register-user-confirm")).click();
	    
	    
	    
        String actualTitle = driver.getTitle();
		
		// Title Verification for home page
		Assert.assertEquals(actualTitle, "selendroid-test-app");
		
	    
	    
    	
	}

}
