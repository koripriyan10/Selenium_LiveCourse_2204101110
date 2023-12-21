package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    
	public static HashMap<String, String> ReadExcelFile(int row, XSSFSheet objXSSFSheet) {
		// TODO Auto-generated method stub
		
        DataFormatter objDataFormatter = new DataFormatter();
		
		hmap.put("RunMode", objXSSFSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objXSSFSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objXSSFSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objXSSFSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objXSSFSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("Email", objXSSFSheet.getRow(row).getCell(5).getStringCellValue());
		
		hmap.put("PhoneNumber",objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(6)));
		hmap.put("Gender", objXSSFSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objXSSFSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objXSSFSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills", objXSSFSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objXSSFSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objXSSFSheet.getRow(row).getCell(12).getStringCellValue());
		
		hmap.put("DOB_YY", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(13)));
		
		hmap.put("DOB_MM", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(14)));
		
		hmap.put("DOB_DD", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(15)));
		
		hmap.put("Password", objXSSFSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("confirm Password", objXSSFSheet.getRow(row).getCell(17).getStringCellValue());					 											
		return hmap;
	}
	
	public static void SelectValueFromDropdown(List<WebElement> AllElements, String DropDownValue) {
		// TODO Auto-generated method stub
		
		
		int TotalElements = AllElements.size();		
		
		for(int i=1; i <= TotalElements-1 ; i++ )
		{
			String DropDownFromScript = AllElements.get(i).getText();
						
			if(DropDownFromScript.equals(DropDownValue))
			{
				AllElements.get(i).click();
				break;
			}
			

		}
		
	}
	
	public static void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
}
