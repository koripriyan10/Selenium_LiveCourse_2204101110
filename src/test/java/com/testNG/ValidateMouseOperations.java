package com.testNG;

import org.testng.annotations.Test;

import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Properties;
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

public class ValidateMouseOperations extends Library {
	
// public WebDriver driver; 
// public Properties objProperties;
  
  @Test(priority=1)
  public void ValidateJQueryPageLoadedSuccessfully() throws InterruptedException
  {

	  driver.get(objProperties.getProperty("mouseOpeartionRightClickURL"));
	  PageLoadTimeOut();
	  System.out.println("ValidateJQueryPageLoadedSuccessfully");
	  String TitleOfJqueryPage =  driver.getTitle();
	  Assert.assertEquals(TitleOfJqueryPage,"jQuery contextMenu (2.x)");
	  
	  //Thread.sleep(2000);	    
  }
  
  @Test(priority=2)
  public void VerifyRightClickOperation() throws InterruptedException 
  {
	  System.out.println("Inside verify right click operation");     
	  
	  Actions objActions = new Actions(driver);	  
	  WebElement element =  driver.findElement(By.xpath("//span[contains(text(),'right')]"));
	  objActions.contextClick(element).build().perform();	  
	  
	  WebElement Paste = driver.findElement(By.xpath("//span[text()='Paste']")); 
	  objActions.click(Paste).build().perform();
	  Thread.sleep(2000);
	  Alert objAlert = driver.switchTo().alert();	  
	  String AlertText = objAlert.getText();
	  System.out.println("Alert Text:"+AlertText);
	  Assert.assertEquals(AlertText, "clicked: paste");
	  objAlert.accept();		  
  }
  
  
  @Test(priority=3)
  public void VerifyDoubleClickOperation() throws InterruptedException 
  {
	  System.out.println("Inside Verify Double Click Operation");
	  driver.navigate().to(objProperties.getProperty("mouseOpeartionDoubleClick"));
	  PageLoadTimeOut();	 
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  WebElement frame = driver.findElement(By.xpath("//iframe"));
	  js.executeScript("arguments[0].scrollIntoView(true);",frame);
	  driver.switchTo().frame(frame);
	  
	  WebElement DoubleClicBox = driver.findElement(By.xpath("//span[contains(text(),'Double')]/preceding-sibling::div"));	  
	  Actions objActions = new Actions(driver);
	  objActions.doubleClick(DoubleClicBox).build().perform();
	  driver.switchTo().defaultContent();
	  
  }
  
  @Test(priority=4)
  public void VerifyDragAndDrop() throws InterruptedException 
  {
	  System.out.println("Inside Verify Drag and Drop Operation");
	  driver.navigate().to(objProperties.getProperty("mouseOperationDragAndDrop"));
	  PageLoadTimeOut();	 
	  
	  WebElement frame = driver.findElement(By.xpath("//iframe"));
	  driver.switchTo().frame(frame);
	  WebElement source = driver.findElement(By.id("draggable"));
	  WebElement destination = driver.findElement(By.id("droppable"));
	  
	  Actions objActions = new Actions(driver);
	  objActions.dragAndDrop(source, destination).build().perform();
	  	  
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
