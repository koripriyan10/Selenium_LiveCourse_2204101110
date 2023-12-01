package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class ValidateMouseOperations {
  public WebDriver driver; 
  
  @Test(priority=1)
  public void ValidateJQueryPageLoadedSuccessfully() throws InterruptedException
  {
	  System.out.println("ValidateJQueryPageLoadedSuccessfully");
	  String TitleOfJqueryPage =  driver.getTitle();
	  Assert.assertEquals(TitleOfJqueryPage,"jQuery contextMenu (2.x)");
	  
	  //Thread.sleep(2000);
	  Actions objActions = new Actions(driver);	  
	  WebElement element =  driver.findElement(By.xpath("//span[contains(text(),'right')]"));
	  objActions.contextClick(element).build().perform();
	  
	  
	  WebElement Paste = driver.findElement(By.xpath("//li/span[contains(text(),'Paste')]"));
	  
	  
	  objActions.click(Paste).build().perform();
	  Alert objAlert = driver.switchTo().alert();	  
	  String AlertText = objAlert.getText();
	  System.out.println("Alert Text:"+AlertText);
	  Assert.assertEquals(AlertText, "clicked: paste");
	  objAlert.accept();	  
  }
  
  @Test(priority=2,enabled=false)
  public void VerifyRightClickOperation() 
  {
	  System.out.println("Inside verify right click operation");

	  
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
	    System.setProperty("webdriver.chrome.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\chromedriver-v119\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside After Suite");
  }

}
