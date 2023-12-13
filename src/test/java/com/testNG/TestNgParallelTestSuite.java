package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;


public class TestNgParallelTestSuite {
	
  String testName = "";	
	
  @Test
  public void testMethodOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Sample test method one:"+ testName + "Thread Id is:"+ id);
  }
  @BeforeClass
  public void beforeClass() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Before Class:"+ testName + "Thread Id is:"+ id);
  }

  
  @BeforeTest
  @Parameters({"test-name"})
  public void beforeTest(String testname) {
	  this.testName = testname;
	  long id = Thread.currentThread().getId();
	  System.out.println("Before Test:"+ testName + "Thread Id is:"+ id);
	    
  }
  
  @AfterTest
  public void AfterTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("After Test:"+ testName + "Thread Id is:"+ id);
	    
  }
  
  @AfterClass
  public void AfterClass() {
	  long id = Thread.currentThread().getId();
	  System.out.println("After Class:"+ testName + "Thread Id is:"+ id);
	    
  }

}
