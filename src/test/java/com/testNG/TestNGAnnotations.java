package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations {
  @Test
  public void TestCase1() {
	  System.out.println("inside testcase1");
  }
  
  @Test
  public void TestCase2() {
	  System.out.println("inside testcase2");
  }
  
  @Test
  public void TestCase3() {
	  System.out.println("inside testcase3");
  }
  
  @Test
  public void TestCase4() {
	  System.out.println("inside testcase4");
  }
  
  @Test
  public void TestCase5() {
	  System.out.println("inside testcase5");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforemethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside aftermethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterclass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforetest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside aftertest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforesuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside aftersuite");
  }

}
