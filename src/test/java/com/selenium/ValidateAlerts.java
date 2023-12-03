package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AlertsPage;
import com.utility.Library;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateAlerts extends Library{
	static Alert objAlert;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		ReadPropertiesFile();
		LaunchBrowser();
		
		driver.get(objProperties.getProperty("Alerts"));
		driver.findElement(AlertsPage.Alerts).click();
		objAlert = driver.switchTo().alert();	
		String AlertButtonText = objAlert.getText();
		
		if(AlertButtonText.equalsIgnoreCase("You clicked a button"))
		{
			objAlert.accept();
		}
		
		else
		{
			System.out.println("AlertButtonText not validated");
		}
		
		System.out.println("AlertButtonText:"+AlertButtonText );
		
		driver.findElement(AlertsPage.timerAlert).click();	
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		String TimerAlertText = objAlert.getText();
		
		System.out.println("TimerAlertText:"+TimerAlertText );
		
		if(TimerAlertText.equalsIgnoreCase("This alert appeared after 5 seconds")){
			objAlert.accept();
		}
		
		else{
			System.out.println("TimerAlert text is not validated" );
		}
		
		
		driver.findElement(AlertsPage.ConfirmAlert).click();
		objAlert = driver.switchTo().alert();		
		String ConfirmAlertText = objAlert.getText();
	    		
		if(ConfirmAlertText.equalsIgnoreCase("Do you confirm action?")){
			objAlert.accept();
		}
		
		else{
			System.out.println("Confirm Button text is not validated");
		}
			
		String ConfirmResult = driver.findElement(AlertsPage.ConfirmResult).getText();
		System.out.println("ConfirmResult:"+ConfirmResult);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(AlertsPage.PromptAlert).click();
		objAlert = driver.switchTo().alert();		
		objAlert.sendKeys("Hi iam Learning Selenium");			
		objAlert.accept();
		String PromptResult = driver.findElement(AlertsPage.promptResult).getText();
		System.out.println("PromptResult:"+PromptResult);
		
	}

}
