package com.testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pages.WebTablePage;
import com.utility.Library;

public class ValidateWebTable extends Library {
  
	
  @Test(priority=1)
  public void ValidateWebTablePageSuccessfully() {
	    ReadPropertiesFile();
	    LaunchBrowser();    
		driver.get(objProperties.getProperty("WebTableURL"));
		PageLoadTimeOut();
		System.out.println("Inside ValidateWebTablePageSuccessfully");
		String TitleOfJqueryPage = driver.getTitle();
		System.out.println("TitleOfJqueryPage:"+TitleOfJqueryPage);
  }
  
  @Test(priority=2)
  public void VerifytableInformation() throws InterruptedException {
	
	  System.out.println("Inside Verify Table Information");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,400)"); // scroll vertically down	
//	  js.executeScript("window.scrollBy(0,-300)"); // scroll vertically up	
//	  js.executeScript("window.scrollBy(300,0)"); // scroll Horizontally right	
//	  js.executeScript("window.scrollBy(-500,0)"); // scroll Horzontally left	
	  List<WebElement> AllLastNames = driver.findElements(WebTablePage.AllLastNames);
	  
	  int NumberOfRows = AllLastNames.size();
	  
	  System.out.println(NumberOfRows);
	  
	  for(int row=0; row <= NumberOfRows; row++)
	  {
		  String LastName = AllLastNames.get(row).getText();
		  //System.out.println(LastName);
		  int RowNumber = row+1;
		  if(LastName.equals(objProperties.getProperty("WebTableLastName")))
		  {
			 String FirstName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[2]")).getText();
			 String Last_Name = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[3]")).getText();
			 String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[4]")).getText();
			 String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[5]")).getText();
			 String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[6]")).getText();
			 String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+RowNumber+"]/td[7]")).getText();			
			 
			 System.out.println(FirstName);
			 System.out.println(Last_Name);
			 System.out.println(Position);
			 System.out.println(Office);
			 System.out.println(StartDate);
			 System.out.println(Salary);
			 
			 break; 	 
		  }
		  
		  
	  }
  }
}
