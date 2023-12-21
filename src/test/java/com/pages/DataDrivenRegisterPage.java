package com.pages;

import org.openqa.selenium.By;

public class DataDrivenRegisterPage {

	public static By FirstName = By.xpath("//input[@placeholder=\"First Name\"]"); 
	public static By LastName = By.xpath("//input[@placeholder=\"Last Name\"]"); 
	public static By Address = By.xpath("//textarea[@ng-model=\"Adress\"]"); 
	public static By Email = By.xpath("//input[@ng-model=\"EmailAdress\"]"); 
	public static By PhoneNumber = By.xpath("//input[@ng-model=\"Phone\"]"); 
	public static By GenderMale = By.xpath("//input[@ng-model=\"radiovalue\" and @value=\"Male\"]"); 
	public static By GenderFemale = By.xpath("//input[@ng-model=\"radiovalue\" and @value=\"FeMale\"]"); 
	public static By HobbiesCricket	 = By.xpath("//input[@value=\"Cricket\"]"); 
	public static By HobbiesMovies = By.xpath("//input[@value=\"Movies\"]"); 
	public static By HobbiesHockey = By.xpath("//input[@value=\"Hockey\"]"); 
	public static By Languages = By.xpath("//div[@id='msdd']"); 
	public static By AllLanguages = By.xpath("//div[@id='msdd']/following-sibling::div/ul/li/a");
	public static By Skills = By.xpath("//select[@id=\"Skills\"]"); 
	public static By AllSkills = By.xpath("//select[@id=\"Skills\"]/option"); 
	
	public static By Country = By.xpath("//span[@class=\"select2-selection select2-selection--single\"]"); 
	public static By AllCountry = By.xpath("//span/ul[@id=\"select2-country-results\"]/li"); 
	public static By SearchBox = By.xpath("//input[@type='search']");
	public static By CloseIconOfLanguage = By.xpath("//span[@class='ui-icon ui-icon-close']");
	public static By Year = By.xpath("//select[@id='yearbox']");
	public static By Month = By.xpath("//select[@placeholder='Month']");
	public static By Day = By.xpath("//select[@id='daybox']");
	public static By AllYears = By.xpath("//select[@id='yearbox']/option");
	public static By AllMonths = By.xpath("//select[@placeholder='Month']/option");
	public static By AllDays = By.xpath("//select[@id='daybox']/option");
	public static By Password = By.xpath("//input[@id='firstpassword']"); 
	public static By ConfirmPassword = By.xpath("//input[@id='secondpassword']"); 
}
