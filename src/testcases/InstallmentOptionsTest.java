package testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.InstallmentOptions;
import pageObjects.InsuringParty;
import pageObjects.Login;
import pageObjects.PolicyDetails;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class InstallmentOptionsTest extends BasePage{
  @Test
  public void installmentOptionsValid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1);
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.policyDetailsValid("06/29/2020", 2);
	  
	  InstallmentOptions option=new InstallmentOptions(driver);
	  option.setPaymentFour(true);
	  
	  Thread.sleep(5000);
	  Boolean value=option.setButton(true);
	  
	  Thread.sleep(5000);
      String text=option.getTitle();
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the Additional Covers page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Additional covers", text);
  }
}
