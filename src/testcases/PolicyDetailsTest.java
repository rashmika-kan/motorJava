package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.InsuringParty;
import pageObjects.Login;
import pageObjects.PolicyDetails;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class PolicyDetailsTest extends BasePage{
	
	
  @Test(priority=0)
  public void policyDetailsValid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.setDate("07/30/2020");
	  
	  polDetails.setLength(2);
	  polDetails.setInsureDoc(true);
	  
	  polDetails.setProtectInfo(true);
	  Boolean value=polDetails.setButton(true);
	  
	  Thread.sleep(5000);
      String text=polDetails.getTitle();
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the Installment Options page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Instalment options", text);
  }
  
  @Test(priority=1)
  public void policyDetailsEmptyValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  WebElement startDate=polDetails.setDate(null);
	  startDate.click();
	  
	  polDetails.setLength(2);
	  polDetails.setInsureDoc(true);
	  
	  polDetails.setProtectInfo(true);
	  Boolean value=polDetails.setButton(true);
	  
	  Thread.sleep(5000);
	  
      String errorMessage=polDetails.getEmptyValueErrorMessage();
	  System.out.println("No value entered in Start Date after clicking the textbox");
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals("This field is mandatory", errorMessage);
	  
  }
  
  @Test(priority=2)
  public void policyDetailsIncorrectValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.setDate("07/30/2020");
	  
	  polDetails.setLength(2);
	  polDetails.setProtectInfo(false);
	  
	  polDetails.setInsureDoc(true);
	  
	  Thread.sleep(2000);
	  Boolean value=polDetails.setButton(false);
	  
      String errorMessage=polDetails.getIncorrectValueErrorMessage();
      
      System.out.println("Personal Data Protection Information is left unchecked after clicking on it");
	  System.out.println("Is button enabled: "+value);
	  
	  System.out.println("Error message found: "+errorMessage);
	  Assert.assertEquals("Please read and accept", errorMessage);
  }
}
