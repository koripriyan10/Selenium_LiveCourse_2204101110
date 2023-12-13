package com.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class TestNGParallelClass2 {

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Inside before class thread Id is" + id);
		
		System.setProperty("webdriver.gecko.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
	    WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
	}

	@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Inside test method one thread Id is" + id);
		
	}
	
	@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Inside test method two thread Id is" + id);
		
	}
	
	@Test
	public void testMethodThree() {
		long id = Thread.currentThread().getId();
		System.out.println("Inside test method three thread Id is" + id);
		
	}

}
