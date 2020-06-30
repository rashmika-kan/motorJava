package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InstallmentOptions {
	WebDriver driver;
 
	By fourpay=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[4]/app-installment/form/div[1]/div[3]/div[1]/div[1]/label/input");
	By twopay=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[4]/app-installment/form/div[1]/div[2]/div[1]/div[1]/label/input");
	By onepay=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[4]/app-installment/form/div[1]/div[1]/div/div[1]/label/input");
	By btn=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[4]/app-installment/form/button");
	By title=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[5]/app-additional-covers/h1");
  public InstallmentOptions(WebDriver driver) {
	  this.driver=driver;
  }
  
	 public void validInstallmentOptions() {
		 WebElement four=driver.findElement(this.fourpay);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",four);
		  WebElement submit=driver.findElement(this.btn);
		  executor.executeScript("arguments[0].click();",submit);
		  }
	
  public WebElement setPaymentFour(boolean value) {
	  WebElement four=driver.findElement(this.fourpay);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  if(value) {
		  executor.executeScript("arguments[0].click();",four);
		  //four.click();
		  }
	  return four;
  }
  
  public WebElement setPaymentTwo(boolean value) {
	  WebElement two=driver.findElement(this.twopay);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  if(value) {
		  executor.executeScript("arguments[0].click();",two);
		  //two.click();
		  }
	  return two;
  }
  
  public WebElement setPaymentOne(boolean value) {
	  WebElement one=driver.findElement(this.onepay);
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  if(value) {
		  executor.executeScript("arguments[0].click();",one);
		  //one.click();
		  }
	  return one;
  }
  
  public boolean setButton(boolean value) {
	  	boolean enabled;
	  	WebElement submit=driver.findElement(this.btn);
	  	JavascriptExecutor executor = (JavascriptExecutor)driver;
	  	if(value) {
	  	 enabled=submit.isEnabled();
		  executor.executeScript("arguments[0].click();",submit);
	  	 //submit.click();
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
