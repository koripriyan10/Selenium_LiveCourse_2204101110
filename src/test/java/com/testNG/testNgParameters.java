package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class testNgParameters {
  
  // Parameters are case sensitive
  @Parameters({"BrowserName"})	
  @Test
  public void OpenBrowser(String BrowserName) {
	  
	  System.out.println("inside test method");
	  System.out.println("browser passed as: -" + BrowserName );
	  WebDriver driver = null;
	  
	  if(BrowserName.equalsIgnoreCase("chrome"))
	  {
	  
		  System.setProperty("webdriver.chrome.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\chromedriver-v119\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  
	  else if(BrowserName.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
	      driver = new FirefoxDriver();
	  }
	  
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  @Parameters({"Username","Passcode"})
  @Test
  public void FillLoginForm(String user, String Password) {
	  System.out.println("parameter for username passed as"+user);
	  System.out.println("parameter for password passed as"+Password);
  }
  
  @Parameters({"email"})
  @Test
  public void testCaseforEmail(String email) {
	  System.out.println(email);
  }
  
  @Test
  public void testCaseWithoutParameter() {
	  System.out.println("inside test case without parameter");
  }
  
  @Parameters({"BrowserName"})
  @BeforeSuite
  public void beforeSuite(String browser) {
	  System.out.println("inside before suite");
	  System.out.println("browser passed as "+browser);
  }

}
