package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.VehicleInfo;
import setup.BasePage;

public class VehicleInfoTest extends BasePage{
  @Test
  public void vehicleInfoValid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.setRegistrationNumber("12345678");
	  
	  vInfo.setCertificationNumber("123456789");
	  vInfo.setPurpose(1);
	  
	  Boolean value=vInfo.setButton(true);
	  String text=vInfo.getTitle();
	  
	  Thread.sleep(5000);
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the insuring party page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Insuring Party", text);
	  
  }
  
  @Test
  public void vehicleInfoEmptyValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.setRegistrationNumber("12345678");
	  
	  WebElement certNo=vInfo.setCertificationNumber(null);
	  certNo.click();
	  
	  vInfo.setPurpose(1);
	  String errorMessage=vInfo.getEmptyValueErrorMessage();
	  
	  Boolean value=vInfo.setButton(false);
	  System.out.println("No value entered in Vehicle Certificate Number after clicking the textbox");
	  
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals("Vehicle Certificate Number is required", errorMessage);
	  
  }
  
  @Test
  public void vehicleInfoIncorrectValueInvalid() throws InterruptedException {
	  Login login=new Login(driver);
	  login.signUp("admin", "admin");
	  
	  VehicleInfo vInfo=new VehicleInfo(driver);
	  vInfo.setRegistrationNumber("1234567");
	  
	  vInfo.setCertificationNumber("123456789");
	  vInfo.setPurpose(1);
	  
	  Boolean value=vInfo.setButton(false);
	  String errorMessage=vInfo.getIncorrectValueErrorMessage();
	  
	  System.out.println("Incorrect value entered in Vehicle Registration Number");
	  System.out.println("Is button enabled: "+value);
	  
	  System.out.println("Error message found: "+errorMessage);
	  Assert.assertEquals("Vehicle Registartion Number Should be 8 characters", errorMessage);
  }
}
