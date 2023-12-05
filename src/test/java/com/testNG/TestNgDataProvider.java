package com.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNgDataProvider {
  @Test(dataProvider = "dp")
  public void mul(int a, int b) 
  {
	  System.out.println(a*b);
  }
  
  @Test(dataProvider = "ragu")
  public void add(String User, String Password, String Email, String Hobby) 
  {
	  System.out.println("User:"+User);
	  System.out.println("Password:"+Password);
	  System.out.println("Email:"+Email);
	  System.out.println("Hobby:"+Hobby);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 4, 5 },
      new Object[] { 6, 7 },
    };
  }
  
  @Test(priority =3)
  public void testcase3() 
  {
     System.out.println("inside testcase 3");
  }
  
  @DataProvider
  public Object[][] ragu() {
    return new Object[][] {
      new Object[] { "User1", "Pwd1","abc1@gmail.com","cricket" },
      new Object[] { "User2", "Pwd2","abc2@gmail.com","tennis" },
      new Object[] { "User3", "Pwd3","abc3@gmail.com","basket" },
    };
  }
}
