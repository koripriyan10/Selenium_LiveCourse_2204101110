package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;

public class TestNgFactory {
  
  private String param ="";	
  
  public TestNgFactory(String param) {
	  this.param = param;
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Before Class Executed");	  
  }
  
  @Test
  public void testmethod1() {
	  System.out.println("Test Method1 parameter value is:"+ param);
  }
  
  @Test
  public void testmethod2() {
	  System.out.println("Test Method2 is not accepting parameters");
  }	
  
  
  @Test
  public void testmethod3() {
	  System.out.println("Test Method3 parameter value is:"+ param);
  }

  @Factory
  public Object[] Ragu() {
	  return new Object[] {
			  new TestNgFactory("hello"),
			  new TestNgFactory("raguveer"),
			  new TestNgFactory("selenium")};
  }
}
