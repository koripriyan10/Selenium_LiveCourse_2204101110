package com.testNG;

import org.testng.annotations.Test;

import com.pages.MultipleWindowsPage;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMultipleWindows extends Library {
	
// public WebDriver driver; 
// public Properties objProperties;
  
  @Test(priority=1)
  public void ValidateMultipleWindowsPageLoadedSuccessfully() throws InterruptedException
  {
	  System.out.println("ValidateMultipleWindowsPageLoadedSuccessfully");
	  driver.get(objProperties.getProperty("nxtgenaiacademyURL"));
	  PageLoadTimeOut();
	  String TitleOfJqueryPage =  driver.getTitle();
	  Assert.assertEquals(TitleOfJqueryPage,objProperties.getProperty("nxtgenaiacademyTitle"));	      
  }
  
  @Test(priority=1)
  public void ValidateNewBrowserWindow() throws InterruptedException
  {
	 driver.findElement(MultipleWindowsPage.newbrowserwindow123).click();
	 Set<String> AllWindows = driver.getWindowHandles();
	 
	 for(String IndividualWindow :AllWindows)
	 {
		 
	 }
	 
  }
  
 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	    System.out.println("Inside Before Suite");
	    ReadPropertiesFile();
	    LaunchBrowser();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside After Suite");
  }

}
