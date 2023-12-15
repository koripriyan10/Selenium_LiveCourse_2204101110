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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.FileUpload;
import com.utility.Library;

public class ValidateFileUpload extends Library {
	
	
  @Test(priority=1)
  public void ValidateFileUploadPageSuccessfully() {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get(objProperties.getProperty("FileUpload"));
	  PageLoadTimeOut();
	  System.out.println("Inside Validate Page Upload Successfully");
	  String TitleOfJqueryPage = driver.getTitle();
	  System.out.println("TitleOfJqueryPage:"+TitleOfJqueryPage);
	  Assert.assertEquals(TitleOfJqueryPage, objProperties.getProperty("TiTleOfFileupload"));	
  }
  
  @Test(priority=2)
  public void ValidateFileUpload() throws InterruptedException {

	  System.out.println("Inside ValidFileUpload");
	  WebElement elm = driver.findElement(FileUpload.Browse);
	  Actions objActions = new Actions(driver);
	  objActions.click(elm).build().perform();
	  
	  File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//Sample.jpg");
	  StringSelection ObjStringSelection = new StringSelection(objFile.toString()); 
	  Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	  objClipboard.setContents(ObjStringSelection, null);
	  
	  Transferable objTransferable = objClipboard.getContents(null);
	  
	  if(objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor))
	  {
		  try
		  {
			  System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
		  }
		  
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	  }
	  
	  try
	  {
		  Thread.sleep(5000);
		  Robot objRoot = new Robot();
		  objRoot.keyPress(KeyEvent.VK_ENTER);
		  objRoot.keyRelease(KeyEvent.VK_ENTER);
		  objRoot.keyPress(KeyEvent.VK_CONTROL);
		  objRoot.keyPress(KeyEvent.VK_V);
		  
		  objRoot.keyRelease(KeyEvent.VK_V);
		  objRoot.keyRelease(KeyEvent.VK_CONTROL);

		  
		  objRoot.keyPress(KeyEvent.VK_ENTER);
		  objRoot.keyRelease(KeyEvent.VK_ENTER);

	  }
	  
	  catch(AWTException e)
	  {
		  e.printStackTrace();
	  }
  }
}
