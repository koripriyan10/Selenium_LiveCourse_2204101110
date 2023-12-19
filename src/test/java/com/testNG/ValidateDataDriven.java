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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
//    		  System.out.println("-----------------------------");
    		  hmap = ReadExcelFile(Row,objXSSFSheet);
//    		  System.out.println(hmap.get("FirstName"));
//    		  System.out.println(hmap.get("LastName"));
//    		  System.out.println(hmap.get("Address"));
//    		  System.out.println(hmap.get("Email"));
//    		  System.out.println(hmap.get("PhoneNumber"));  
//    		  System.out.println("-----------------------------");
//    		  
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
			  
			  if(Row>1) {
					driver.findElement(DataDrivenRegisterPage.CloseIconOfLanguage).click();
				}

    		  //Languages
			  System.out.println(hmap.get("Hobbies")); 
    		  driver.findElement(DataDrivenRegisterPage.Languages).click();
			  

			  

    		  //Thread.sleep(2000);
    		  List<WebElement> AllLanguages = driver.findElements(DataDrivenRegisterPage.AllLanguages);    
    		     		  
    		  SelectValueFromDropdown(AllLanguages, hmap.get("Languages"));
    		  
//    		  
//			  if(Row>1) {
//			  driver.findElement(DataDrivenRegisterPage.CloseIconOfLanguage).click();
//			  }
			  
			  Thread.sleep(3000);
    		  
    		  //Skills
//    		  driver.findElement(DataDrivenRegisterPage.Skills).click();
//    		  List<WebElement> AllSkills = driver.findElements(DataDrivenRegisterPage.Skills); 		  
//    		  SelectValueFromDropdown(AllSkills, hmap.get("Skills"));
//    		  
//    		  driver.findElement(DataDrivenRegisterPage.SearchBox).click();
    		  
//    		  try
//    		  {
//        		  Robot objRobot = new Robot();
//        		  objRobot.keyPress(KeyEvent.VK_ENTER);
//        		  objRobot.keyRelease(KeyEvent.VK_ENTER);
//    		  }
//    		  
//    		  catch(AWTException e)
//    		  {
//    			  e.printStackTrace();
//    		  }
    		  

    	  }

    	  objXSSWorkBook.close(); 
    	  
      }

      catch(FileNotFoundException e)
      {
    	  e.printStackTrace();
      }
       
  }




}
