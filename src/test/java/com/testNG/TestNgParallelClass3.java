package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class TestNgParallelClass3 {

  @BeforeClass
  public void beforeClass() 
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside Before Class Thread is:"+ id); 
	  System.out.println("Inside before class");
  }
  
  @Test
  public void test() 
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside Before Class Thread is:"+ id); 
	  System.out.println("Inside test");
  }
  
  @Test
  public void afterClass() 
  {
	  long id = Thread.currentThread().getId();
	  System.out.println("Inside Before Class Thread is:"+ id); 
	  System.out.println("Inside after class");
  }
}
