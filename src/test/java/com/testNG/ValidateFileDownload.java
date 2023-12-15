package com.testNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.FileDownload;
import com.pages.FileUpload;
import com.utility.Library;

public class ValidateFileDownload extends Library {
	
	
  @Test(priority=1)
  public void ValidateFileDownloadPageSuccessfully() {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get(objProperties.getProperty("FileDownload"));
	  PageLoadTimeOut();
	  System.out.println("Inside Validate Page Download Successfully");
	  String TitleOfJqueryPage = driver.getTitle();
	  System.out.println("TitleOfJqueryPage:"+TitleOfJqueryPage);
	  Assert.assertEquals(TitleOfJqueryPage, objProperties.getProperty("titleOfFileDownloadPage"));	
  }
  
  @Test(priority=2)
  public void ValidateFileUpload() throws InterruptedException {

	  System.out.println("Inside ValidFileDownload");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,500)");
	  driver.findElement(FileDownload.FileDownload500Kb).click();
	  Thread.sleep(10000);
	  
	  File objFile = new File(System.getProperty("user.dir"));
	  File[] AllFiles = objFile.listFiles();
	  
	  for(File individualFile:AllFiles)
	  {
		  String FileName = individualFile.getName();
		  System.out.println("FileName"+FileName);
		  Boolean FileFound = false;
		  if(FileName.contains(objProperties.getProperty("TypeOfDownloadedFile")))
		  {
			  FileFound = true;
			  Assert.assertTrue(FileFound,"File Downloaded is not recognized");
			  individualFile.deleteOnExit();
		  }
	  }
	  

  }
}
