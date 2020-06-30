package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InsuringParty {
   private WebDriver driver;
   
   By egnEik=By.id("egn");
   By address=By.cssSelector("select[formControlName=address]");
   By em=By.id("email");
   By insurebtn=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/form/button");
   By title=By.xpath("//*[@id=\"cdk-step-content-0-2\"]/app-policy-details/h1");
   By emptyEmailError=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/form/div[3]/div[2]/div/div");
   By incorrectEGNError=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/form/div[1]/div[2]/div");
   
   public InsuringParty(WebDriver driver) {
	   this.driver=driver;
   }
   
   public void validInsuringParty(String EGN,int index,String Email) {
	   driver.findElement(egnEik).sendKeys(EGN);
	   WebElement dropdown=driver.findElement(address);
	   Select select=new Select(dropdown);
	   select.selectByIndex(index);
	   driver.findElement(em).sendKeys(Email);
	   driver.findElement(insurebtn).click();
   }
   
  public WebElement setEgn(String EGN) {
	  WebElement egn=driver.findElement(egnEik);
	  if(EGN!=null) {
	  egn.sendKeys(EGN);}
	  return egn;
  }
  
  public WebElement setAddress(int index) {
	  WebElement dropdown=driver.findElement(address);
  	  Select select=new Select(dropdown);
  	  if(index>=0) {
  	  select.selectByIndex(index);}
  	  return dropdown;
  	
  }
  
  public String getEmptyValueErrorMessage() {
  	String text=driver.findElement(emptyEmailError).getText();
  	return text;
  }
  
  public String getIncorrectValueErrorMessage() {
  	String text=driver.findElement(incorrectEGNError).getText();
  	return text; 
  }
  
  public WebElement setEmail(String Email) {
	  WebElement email=driver.findElement(em);
	  if(Email!=null) {
	  email.sendKeys(Email);}
	  return email;
  }
  
  public boolean setButton(boolean value) {
  	boolean enabled;
  	WebElement submit=driver.findElement(insurebtn);
  	JavascriptExecutor executor = (JavascriptExecutor)driver;
  	if(value) {
  	 enabled=submit.isEnabled();
  	 //executor.executeScript("arguments[0].click();",submit);
  	 submit.click();
  	 return enabled;
  	}
  	else {enabled=submit.isEnabled();
  	return enabled;}
  	
  }
  
  public String getTitle() {
  	String text=driver.findElement(title).getText();
  	return text;
  }
  
}
