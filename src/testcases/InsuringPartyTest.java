package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.InsuringParty;
import pageObjects.Login;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class InsuringPartyTest extends BasePage{
	
  @Test(priority=0)
  public void insuringPartyValid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1);
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.setEgn("1234567899");
	  
	  insurePty.setAddress(1);
	  insurePty.setEmail("random@gmail.com");
	  
	  Thread.sleep(2000);
	  
	  Boolean value=insurePty.setButton(true);
	  Thread.sleep(2000);
	  String text=insurePty.getTitle();
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the Policy Details page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Policy Details", text);
	  
  }
  
  @Test(priority=1)
  public void insuringPartyEmptyValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1);
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  WebElement email=insurePty.setEmail(null);
	  email.click();
	  
	  insurePty.setEgn("1234567890");
	  insurePty.setAddress(1);
	 
	  
	  Thread.sleep(2000);
	  Boolean value=insurePty.setButton(false);
	  
	  //Thread.sleep(5000);
	  String errorMessage=insurePty.getEmptyValueErrorMessage();
	  
	  System.out.println("No value entered in Email after clicking the textbox");
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals("This field is mandatory", errorMessage);
	  
  }
  
  @Test(priority=2)
  public void insuringPartyIncorrectValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1);
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.setEgn("1234567");
	  
	  insurePty.setAddress(1);
	  insurePty.setEmail("random@gmail.com");
	  
	  Thread.sleep(2000);
	  
	  Boolean value=insurePty.setButton(false);
	  //Thread.sleep(5000);
	  
      String errorMessage=insurePty.getIncorrectValueErrorMessage();
	  System.out.println("Incorrect value entered in EGN/EIK textbox");
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  Assert.assertEquals("Only 10 digit numerical value allowed", errorMessage);
	  
  }
}
