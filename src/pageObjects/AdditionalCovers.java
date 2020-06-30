package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AdditionalCovers {
	WebDriver driver;

	By none=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[5]/app-additional-covers/form/div[2]/div/div/label/input");
	By premium=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[5]/app-additional-covers/form/div[3]/div/div[1]/label/input");
	By vip=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[5]/app-additional-covers/form/div[4]/div[1]/div[1]/label/input");
	By btn=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/div/mat-horizontal-stepper/div[2]/div[5]/app-additional-covers/form/button");
	By title=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[2]/div/app-mtpl-policy/div/mat-horizontal-stepper/div[2]/div[1]/app-personal/h1/b");
	
	 public AdditionalCovers(WebDriver driver) {
		  this.driver=driver;
	  }
	 
	 public void validAdditionalCovers() {
		 WebElement vipCover=driver.findElement(this.vip);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();",vipCover);
		  WebElement submit=driver.findElement(this.btn);
		  executor.executeScript("arguments[0].click();",submit);
		  }
	 
	 public WebElement setNone(boolean value) {
		 WebElement noneCover=driver.findElement(this.none);
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  if(value) {
			  executor.executeScript("arguments[0].click();",noneCover);
			  //four.click();
			  }
		  return noneCover;
		}

		public WebElement setPremium(boolean value) {
			 WebElement premiumCover=driver.findElement(this.premium);
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  if(value) {
				  executor.executeScript("arguments[0].click();",premiumCover);
				  //four.click();
				  }
			  return premiumCover;
		}

		public WebElement setVip(boolean value) {
			 WebElement vipCover=driver.findElement(this.vip);
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  if(value) {
				  executor.executeScript("arguments[0].click();",vipCover);
				  //four.click();
				  }
			  return vipCover;
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
