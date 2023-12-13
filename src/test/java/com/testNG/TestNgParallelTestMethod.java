package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class TestNgParallelTestMethod {
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside Before Method is:"+ id);
  } 
	
	
  @Test
  public void testMethodsOne()  
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside testMethodOne is:"+ id); 
  }
  
  @Test
  public void testMethodsTwo()  
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside testMethodTwo is:"+ id); 
  }
  
  @Test
  public void testMethodsThree()  
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside testMethodThree is:"+ id); 
  }
  
  @Test
  public void testMethodsFour()  
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside testMethodFour is:"+ id); 
  }
  
  @Test
  public void testMethodsFive()  
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside testMethodFive is:"+ id); 
  }

 

}
