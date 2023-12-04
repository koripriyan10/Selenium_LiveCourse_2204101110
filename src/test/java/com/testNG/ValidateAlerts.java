package com.testNG;

import org.testng.annotations.Test;

import com.pages.MultipleWindowsPage;
import com.pages.PracticeFormPage;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlerts extends Library {
	
// public WebDriver driver; 
// public Properties objProperties;
  
  @Test(priority=1)
  public void ValidateAlertPageLoadedSuccessfully() throws InterruptedException
  {
	  System.out.println("ValidateAlertPageLoadedSuccessfully");
	  driver.get(objProperties.getProperty("Alerts"));
	  PageLoadTimeOut();
	  String TitleOfAlertPage =  driver.getTitle();
	  System.out.println("TitleOfAlertPage-"+TitleOfAlertPage);
	  Assert.assertEquals(TitleOfAlertPage, "DEMOQA");
	  	      
  }
  
  @Test(priority=2)
  public void ValidateNormalAlert()
  {
	  driver.findElement(By.id("alertButton")).click();
	  Alert objAlert = driver.switchTo().alert();
	  String AlertText = objAlert.getText();
	  Assert.assertEquals(AlertText, "You clicked a butto");
	  objAlert.accept();	     
  }
  
  @Test(priority=3)
  public void ValidateTimerAlert()
  {
	  driver.findElement(By.id("timerAlertButton")).click();
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert = driver.switchTo().alert();
	  String TimerAlertText = objAlert.getText();
	  System.out.println("TimerAlertText-"+TimerAlertText);
	  Assert.assertEquals(TimerAlertText, "This alert appeared after 5 seconds");
	  objAlert.accept();	     
  }
  
  @Test(priority=4)
  public void ValidateConfirmAlert()
  {
	  driver.findElement(By.id("confirmButton")).click();
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert = driver.switchTo().alert();
	  String ConfirmAlertText = objAlert.getText();
	  System.out.println("ConfirmAlertText-"+ConfirmAlertText);
	  Assert.assertEquals(ConfirmAlertText, "Do you confirm action?");
	  objAlert.dismiss();
	  String TextResult = driver.findElement(By.id("confirmResult")).getText();
	  System.out.println("TextResult:"+ TextResult);
	  Assert.assertEquals(TextResult, "You selected Cancel");
  }
  
  
  @Test(priority=5)
  public void ValidatePromptAlert() throws InterruptedException
  {
	  Thread.sleep(3000);
	  driver.findElement(By.id("promtButton")).click();
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert = driver.switchTo().alert();
	  objAlert.sendKeys("Hi Iam Learning Selenium");
	  objAlert.accept();
	  String PromptAlertResult = driver.findElement(By.id("promptResult")).getText();
	  Assert.assertEquals(PromptAlertResult, "You entered Hi Iam Learning Selenium");
	  System.out.println("PromptAlertResult:"+ PromptAlertResult);
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
