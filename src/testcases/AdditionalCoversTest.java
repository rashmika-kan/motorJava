package testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.AdditionalCovers;
import pageObjects.InstallmentOptions;
import pageObjects.InsuringParty;
import pageObjects.Login;
import pageObjects.PolicyDetails;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class AdditionalCoversTest extends BasePage{
  @Test
  public void validAdditionalCovers() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.policyDetailsValid("07/30/2020", 2);
	  
	  InstallmentOptions option=new InstallmentOptions(driver);
	  option.validInstallmentOptions();
	  
	  AdditionalCovers cover=new AdditionalCovers(driver);
	  cover.setPremium(true);
	  
	  Thread.sleep(2000);
	  Boolean value=cover.setButton(true);
	  
	  Thread.sleep(2000);
      String text=cover.getTitle();
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the Personal Details page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Personal Details", text);
  }
}
