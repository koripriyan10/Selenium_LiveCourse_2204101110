package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {
	WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenChromeBrowser obj = new OpenChromeBrowser();
		WebDriverManager.chromedriver().setup();
		obj.driver = new ChromeDriver(); 
		obj.driver.get("https://www.amazon.com/");
		obj.driver.manage().window().maximize();
		obj.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

}
