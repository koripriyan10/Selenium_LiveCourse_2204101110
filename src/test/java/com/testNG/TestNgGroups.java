package com.testNG;

import org.testng.annotations.Test;

public class TestNgGroups {
  
  @Test(groups = {"Sanity"})
  public void TestMethodOne() {
	  System.out.println("Test Method one belonging to sanity");
  }
  
  @Test(groups = {"Sanity","Regression"})
  public void TestMethodTwo() {
	  System.out.println("Test Method two belonging to sanity and Regression");
  }
  
  @Test(groups = {"Regression"})
  public void TestMethodThree() {
	  System.out.println("Test Method three belonging to Regression");
  }
  
  @Test(groups = {"Sanity"})
  public void TestMethodFour() {
	  System.out.println("Test Method four belonging to Sanity");
  }
  
  @Test(groups = {"Regression"})
  public void TestMethodFive() {
	  System.out.println("Test Method five belonging to Regression");
  }
  
  @Test(groups = {"Sanity"})
  public void TestMethodSix() {
	  System.out.println("Test Method six belonging to sanity");
  }
}
