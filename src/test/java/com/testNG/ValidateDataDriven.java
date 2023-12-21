package com.testNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DataDrivenRegisterPage;
import com.utility.Library;

public class ValidateDataDriven extends Library {
	
  
  @Test(priority=1)
  public void ValidateDataDrivenPageLoadedSuccessfully() 
  {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get((objProperties.getProperty("AutomationRegister")));
	  PageLoadTimeOut();
	  System.out.println("Inside Validate Data Driven Page Loaded Successfully");
	  String DataDrivenPageTitle = driver.getTitle();
	  System.out.println("DataDrivenPageTitle-"+DataDrivenPageTitle);
	  Assert.assertEquals(DataDrivenPageTitle, objProperties.getProperty("TitleOfRegisterPage"));
	  
  }
  
  @Test(priority=2)
  public void VerifyDataDrivenFromExcel() throws IOException, AWTException, InterruptedException 
  {
	  System.out.println("Inside Verify Data Driven From Excel");
      File objFile = new File(System.getProperty("user.dir") +"//src//test//resources//AutomationDemoSIte.xlsx");
      
      try
      {
    	  FileInputStream objFis = new FileInputStream(objFile);
    	  //note: XSSFWorkbook This class is used if extension of file is .xlsx
          //note: HSSFWorkBook This class is used if extension of file is .xls
    	  XSSFWorkbook objXSSWorkBook = new XSSFWorkbook(objFis);
    	  XSSFSheet objXSSFSheet = objXSSWorkBook.getSheet("TestData");
    	  int NumberOfRows = objXSSFSheet.getLastRowNum();		  
    	  
    	  for(int Row=1; Row <=NumberOfRows ; Row++)
    	  {
    		  hmap = ReadExcelFile(Row,objXSSFSheet);    		  
    		  driver.findElement(DataDrivenRegisterPage.FirstName).clear();
    		  driver.findElement(DataDrivenRegisterPage.FirstName).sendKeys(hmap.get("FirstName"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.LastName).clear();
    		  driver.findElement(DataDrivenRegisterPage.LastName).sendKeys(hmap.get("LastName"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.Address).clear();
    		  driver.findElement(DataDrivenRegisterPage.Address).sendKeys(hmap.get("Address"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.Email).clear();
    		  driver.findElement(DataDrivenRegisterPage.Email).sendKeys(hmap.get("Email"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.PhoneNumber).clear();
    		  driver.findElement(DataDrivenRegisterPage.PhoneNumber).sendKeys(hmap.get("PhoneNumber"));
    		  
    		  if(hmap.get("Gender").equalsIgnoreCase("Male"))
    		  {
    			  driver.findElement(DataDrivenRegisterPage.GenderMale).click();
    		  }
    		  
    		  else
    		  {
    			  driver.findElement(DataDrivenRegisterPage.GenderFemale).click();  
    		  }
    		  
    		  if(hmap.get("Hobbies").equalsIgnoreCase("Cricket"))
    		  {
    			  driver.findElement(DataDrivenRegisterPage.HobbiesCricket).click();
    		  }
    		  
    		  else if(hmap.get("Hobbies").equalsIgnoreCase("Movies"))
    		  {
    			  driver.findElement(DataDrivenRegisterPage.HobbiesMovies).click();
    		  }
    		  
    		  else if(hmap.get("Hobbies").equalsIgnoreCase("Hockey"))
    		  {
    			  driver.findElement(DataDrivenRegisterPage.HobbiesHockey).click();
    		  }
    		  
    		  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0,500)");
			  


    		  //Languages
			  //System.out.println(hmap.get("Hobbies")); 
    		  //driver.findElement(DataDrivenRegisterPage.Languages).click();
			  
			  if(Row>1) {
					driver.findElement(DataDrivenRegisterPage.CloseIconOfLanguage).click();
				}
			  

    
			  driver.findElement(DataDrivenRegisterPage.Languages).click();
    		  List<WebElement> AllLanguages = driver.findElements(DataDrivenRegisterPage.AllLanguages);       		     		  
    		  SelectValueFromDropdown(AllLanguages, hmap.get("Languages"));
    		   		  
			  driver.findElement(By.xpath("//label[(contains(text(),'Skills'))]")).click();  		  
    		  
    		  //Skills
    		  driver.findElement(DataDrivenRegisterPage.Skills).click();
    		  List<WebElement> AllSkills = driver.findElements(DataDrivenRegisterPage.AllSkills); 		  
    		  SelectValueFromDropdown(AllSkills, hmap.get("Skills"));
    		  driver.findElement(By.xpath("//label[(contains(text(),'Skills'))]")).click();

    		  
    		  driver.findElement(DataDrivenRegisterPage.Country).click();
    		  driver.findElement(DataDrivenRegisterPage.SearchBox).sendKeys(hmap.get("SelectCountry"));
    		  
    		  try {
					Robot objRobot = new Robot();
					objRobot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(3000);
					objRobot.keyRelease(KeyEvent.VK_ENTER);
				} catch (AWTException e) {
					e.printStackTrace();
				}
    		  
    		  driver.findElement(DataDrivenRegisterPage.Year).click();
    		  List<WebElement> AllYears = driver.findElements(DataDrivenRegisterPage.AllYears); 		  
    		  SelectValueFromDropdown(AllYears, hmap.get("DOB_YY"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.Month).click();
    		  List<WebElement> AllMonths = driver.findElements(DataDrivenRegisterPage.AllMonths); 		  
    		  SelectValueFromDropdown(AllMonths, hmap.get("DOB_MM"));
    		  
    		  driver.findElement(DataDrivenRegisterPage.Year).click();
    		  List<WebElement> AllDays = driver.findElements(DataDrivenRegisterPage.AllDays); 		  
    		  SelectValueFromDropdown(AllDays, hmap.get("DOB_DD"));
    		      		
              driver.findElement(DataDrivenRegisterPage.Password).sendKeys(hmap.get("Password"));
              driver.findElement(DataDrivenRegisterPage.ConfirmPassword).sendKeys(hmap.get("confirm Password"));
    		
    		  
    	  }

    	  objXSSWorkBook.close(); 
    	  
      }

      catch(FileNotFoundException e)
      {
    	  e.printStackTrace();
      }
       
  }




}
