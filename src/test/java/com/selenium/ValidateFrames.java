package com.selenium;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.utility.Library;

public class ValidateFrames extends Library {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.out.println("Hello");
        ReadPropertiesFile();
        LaunchBrowser();
        driver.get(objProperties.getProperty("FramesURL"));
        WebElement element = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Iam inside Single Frame");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.quit();
	}

}
