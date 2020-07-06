package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdditionalCovers;
import pageObjects.InstallmentOptions;
import pageObjects.InsuringParty;
import pageObjects.Login;
import pageObjects.PersonalDetails;
import pageObjects.PolicyDetails;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class PersonalDetailsTest extends BasePage{
  @Test(priority=0)
  public void personalDetailsValid() throws InterruptedException{ 
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.policyDetailsValid("07/29/2020", 2);
	  
	  InstallmentOptions option=new InstallmentOptions(driver);
	  option.validInstallmentOptions();
	  
	  AdditionalCovers cover=new AdditionalCovers(driver);
	  cover.validAdditionalCovers();
	  
	  PersonalDetails details=new PersonalDetails(driver);
	  details.setLnch("1234567899");
	  
	  details.setFname("first");
	  details.setMname("middle");
	  
	  details.setLname("last");
	  details.setFnameEng("first");
	  
	  details.setMnameEng("middle");
	  details.setLnameEng("last");
	  
	  details.setCiti(1);
	  details.setBdate("02/26/1997");
	  
	  Thread.sleep(5000);
	  boolean value=details.setButton(true);
	  
      String text= details.getTitle();
	  Thread.sleep(5000);
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the contact details page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Contact Details", text);
  }
  
  @Test(priority=1)
  public void personalDetailsEmptyValue() throws InterruptedException{ 
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.policyDetailsValid("07/29/2020", 2);
	  
	  InstallmentOptions option=new InstallmentOptions(driver);
	  option.validInstallmentOptions();
	  
	  AdditionalCovers cover=new AdditionalCovers(driver);
	  cover.validAdditionalCovers();
	  
	  PersonalDetails details=new PersonalDetails(driver);
	  details.setLnch("1234567899");
	  
	  details.setFname("first");
	  details.setMname("middle");
	  
	  details.setLname(null);
	  details.setFnameEng("first");
	  
	  details.setMnameEng("middle");
	  details.setLnameEng("last");
	  
	  details.setCiti(1);
	  details.setBdate("02/26/1997");
	  
	  Thread.sleep(5000);
	  boolean value=details.setButton(false);
	  String errorMessage=details.getEmptyValueErrorMessage();
	  
	  System.out.println("No value entered in last name after clicking the textbox");
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals(errorMessage, "This field is mandatory");
	  
  }
  

  @Test(priority=2)
  public void personalDetailsIncorrectValue() throws InterruptedException{
	
	  Login login=new Login(driver);
	  login.signUp("rashmika@infy.com", "rashmika123","rashmika");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.VehicleInfoValid("12345678", "123456789", 1,"Yes");
	  
	  InsuringParty insurePty=new InsuringParty(driver);
	  insurePty.validInsuringParty("1234567899", 1, "random@gmail.com");
	  
	  PolicyDetails polDetails=new PolicyDetails(driver);
	  polDetails.policyDetailsValid("07/29/2020", 2);
	  
	  InstallmentOptions option=new InstallmentOptions(driver);
	  option.validInstallmentOptions();
	  
	  AdditionalCovers cover=new AdditionalCovers(driver);
	  cover.validAdditionalCovers();
	  
	  PersonalDetails details=new PersonalDetails(driver);
      details.setLnch("12345678");
	  
	  details.setFname("first");
	  details.setMname("middle");
	  
	  details.setLname("last");
	  details.setFnameEng("first");
	  
	  details.setMnameEng("middle");
	  details.setLnameEng("last");
	  
	  details.setCiti(1);
	  details.setBdate("02/26/1997");
	  
	  Thread.sleep(5000);
	  boolean value=details.setButton(false);
	  
     String errorMessage=details.getIncorrectValueErrorMessage();
	  
	  System.out.println("Incorrect value entered in LNCH");
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals(errorMessage, "Only 10 digit numerical value allowed");
	  
	  
  }
}
