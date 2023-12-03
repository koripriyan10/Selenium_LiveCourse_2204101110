package com.pages;

import org.openqa.selenium.By;

public class PracticeFormPage {
  
	public static By DateOfBirth = By.id("dateOfBirthInput");
	public static By SelectMonth = By.xpath("//select[@class='react-datepicker__month-select']");
	public static By SelectYear = By.xpath("//select[@class='react-datepicker__year-select']");	
	public static By AllDays = By.xpath("//div[@class='react-datepicker__month']/div/div");
	
}
