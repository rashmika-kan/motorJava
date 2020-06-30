package testcases;

import org.testng.annotations.Test;

import pageObjects.Login;
import setup.BasePage;
import org.junit.Assert;

public class LoginTest extends BasePage{
	
	
  @Test
  public void loginValid() throws InterruptedException {
	 Login login=new Login(driver);
	 String text=login.signUp("rashmika@infy.com","rashmika123","user");
	 Thread.sleep(5000);
	 
	 System.out.println("Login successful.Moves to the vehicle info page.");
	 System.out.println("The title of next page : "+text);
	 Assert.assertEquals("Vehicle Information", text);
  }

  
  @Test
  public void loginInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  boolean display=login.invalidCredentials("admin123", "admin123");
	  Thread.sleep(5000);
	  
	  System.out.println("Login unsuccessful.Error Message displayed");
//	  System.out.println("Alert message  : "+ text);
//	  Assert.assertEquals("Invalid credentials", text);
	  System.out.println("Is error message displayed? "+display);
	  Assert.assertTrue(display);
  }
  
}
