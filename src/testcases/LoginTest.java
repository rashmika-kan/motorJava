package testcases;

import org.testng.annotations.Test;

import pageObjects.Login;
import setup.BasePage;
import org.junit.Assert;

public class LoginTest extends BasePage{
	
	
  @Test
  public void loginValid() throws InterruptedException {
	 Login login=new Login(driver);
	 String text=login.signUp("admin","admin");
	 Thread.sleep(5000);
	 
	 System.out.println("Login successful.Moves to the vehicle info page.");
	 System.out.println("The title of next page : "+text);
	 Assert.assertEquals("Vehicle Information", text);
  }

  
  @Test
  public void loginInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  String text=login.invalidCredentials("admin123", "admin123");
	  Thread.sleep(5000);
	  
	  System.out.println("Login unsuccessful.Recieving message of pop-up.");
	  System.out.println("Alert message  : "+ text);
	  Assert.assertEquals("Invalid credentials", text);
  }
  
}
