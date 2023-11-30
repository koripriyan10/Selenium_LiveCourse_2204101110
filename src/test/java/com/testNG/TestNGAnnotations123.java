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

public class TestNGAnnotations123 {
  @Test(priority=1)
  public void ValidateFlipKartApplicationLoadedSuccessfully() {
	  System.out.println("inside flipkart application test");
  }
  
  @Test(priority=5)
  public void ValidateLoginFunctionalty() {
	  System.out.println("inside ValidateLogin");
  }
  
  @Test(priority=-4)
  public void TestCase3() {
	  System.out.println("inside testcase3");
  }
  
  // Executed first because - with highest number
  // Invocation count will execute n number of times the number specified
  @Test(priority=-9,invocationCount=5)
  public void TestCase4() {
	  System.out.println("inside testcase4");
  }
  
  // If both test case have same priority then order of execution will be in alphabetical order.
  // If both test case doesnot have same priority then test case with upper case will be executed.
  
  @Test
  public void TestCase5() {
	  System.out.println("inside testcase5");
  }
  
  @Test
  public void testCase6() {
	  System.out.println("inside testcase6");
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
