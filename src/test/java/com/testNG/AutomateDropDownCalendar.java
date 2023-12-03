package com.testNG;

import org.testng.annotations.Test;

import com.pages.MultipleWindowsPage;
import com.pages.PracticeFormPage;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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

public class AutomateDropDownCalendar extends Library {
	
// public WebDriver driver; 
// public Properties objProperties;
  
  @Test(priority=1)
  public void ValidatePracticeFormPageLoadedSuccessfully() throws InterruptedException
  {
	  System.out.println("ValidatePracticeFormPageLoadedSuccessfully");
	  driver.get(objProperties.getProperty("CalenderAndDropDownPage"));
	  PageLoadTimeOut();
	  String TitleOfValidatePracticeFormPage =  driver.getTitle();
	  Assert.assertEquals(TitleOfValidatePracticeFormPage,objProperties.getProperty("TitleOfPracticeFormPage"));	      
  }
  
  @Test(priority=2)
  public void ValidateDropDownCalendar()
  {
    System.out.println("Inside Validate Drop Down and Calendar");
    driver.findElement(PracticeFormPage.DateOfBirth).click();
    WebElement Month =  driver.findElement(PracticeFormPage.SelectMonth);
    WebElement Year =  driver.findElement(PracticeFormPage.SelectYear);
    
    Select objSelectMonth =  new Select(Month);    
    objSelectMonth.selectByVisibleText(objProperties.getProperty("DOB_Month"));
    
    driver.findElement(PracticeFormPage.SelectYear).click();
    Select objSelectYear =  new Select(Year);
    objSelectYear.selectByValue(objProperties.getProperty("DOB_YY"));
    //driver.findElement(PracticeFormPage.SelectYear).click();
   
    List<WebElement> AllDays =  driver.findElements(PracticeFormPage.AllDays); 


    int NumberOfDays = AllDays.size();
    
    System.out.println(NumberOfDays);
    
    for(int i =0; i<=NumberOfDays-1;i++)
    {
    	String Day = AllDays.get(i).getText();
    	if(Day.equals(objProperties.getProperty("DOB_DD")))
    	{
    		AllDays.get(i).click();
    	}
    }
    
    String ValueChoosen = driver.findElement(PracticeFormPage.DateOfBirth).getAttribute("value");
    Assert.assertEquals(ValueChoosen,objProperties.getProperty("dateOfBirth"));
    
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
