package com.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

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
  public void VerifyDataDrivenFromExcel() throws IOException 
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
    	  
    	  for(int Row =1; Row <=NumberOfRows ; Row++)
    	  {
    		  System.out.println("-----------------------------");
    		  hmap = ReadExcelFile(Row,objXSSFSheet);
    		  System.out.println(hmap.get("FirstName"));
    		  System.out.println(hmap.get("LastName"));
    		  System.out.println(hmap.get("Address"));
    		  System.out.println(hmap.get("Email"));
    		  System.out.println(hmap.get("PhoneNumber"));  
    		  System.out.println("-----------------------------");
    	  }

    	  objXSSWorkBook.close(); 
    	  
      }

      catch(FileNotFoundException e)
      {
    	  e.printStackTrace();
      }
       
  }


}
