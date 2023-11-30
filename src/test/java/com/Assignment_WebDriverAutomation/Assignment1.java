package com.Assignment_WebDriverAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\chromedriver-v119\\chromedriver.exe");
	    WebDriver chromedriver = new ChromeDriver();
	    chromedriver.get("https://www.facebook.com");
	    
	    System.setProperty("webdriver.gecko.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
	    WebDriver firefoxdriver = new FirefoxDriver();
	    firefoxdriver.get("https://www.facebook.com");
	    
	    System.setProperty("webdriver.ie.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\IEDriver-4.14.0\\IEDriverServer.exe");
	    WebDriver iedriver = new InternetExplorerDriver();
	    iedriver.get("https://www.facebook.com");
	    
	    Thread.sleep(5000);
	    
	    chromedriver.quit();
	    firefoxdriver.quit();
	    iedriver.quit();
	}

}
