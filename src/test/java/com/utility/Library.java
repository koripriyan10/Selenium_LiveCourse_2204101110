package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	public static WebDriver driver;
	public static Properties objProperties;
	public static HashMap<String, String> hmap = new HashMap<String, String>();
	
	public static void ReadPropertiesFile() {
		System.out.println("location of project:" + System.getProperty("user.dir"));
		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//Config.Properties");
		FileInputStream ObjInputStream;
		try {
			ObjInputStream = new FileInputStream(objFile);
			objProperties = new Properties();
			// objProperties.lo
			objProperties.load(ObjInputStream);
			System.out.println(objProperties.getProperty("browser"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String browserFromPropertiesFile = objProperties.getProperty("browser");
		switch (browserFromPropertiesFile) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\firefoxdriver-v33\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\IEDriver-4.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "chrome":		
			System.setProperty("webdriver.chrome.driver","D:\\JavaWorkSpace\\Selenium_LiveCourse_2204101110\\src\\test\\resources\\chromedriver-v119\\chromedriver.exe");	    
			ChromeOptions objChromeOptions = new ChromeOptions();
			Map<String, Object> chromePreferences = new HashMap<String, Object>();
			chromePreferences.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePreferences);
			driver = new ChromeDriver(objChromeOptions);
			
			break;
		}

		driver.manage().window().maximize();
		// Implicit Wait : Global waiting mechanism applicable for all webElements in a
		// web page //All Pages
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
}
