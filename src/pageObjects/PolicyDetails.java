package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PolicyDetails {
	WebDriver driver;
	  
	By date=By.id("policydate");
	By length=By.cssSelector("select[formControlName=policyLength]");
	By protectInfo=By.cssSelector("input[formControlName=check1]");
	By insureDoc=By.cssSelector("input[formControlName=check2]");
	By btn=By.xpath("//*[@id=\"cdk-step-content-0-2\"]/app-policy-details/button");
	By title=By.xpath("//*[@id=\"cdk-step-content-0-3\"]/app-installment/h1");
	By emptydateError=By.xpath("//*[@id=\"cdk-step-content-0-2\"]/app-policy-details/form/div[1]/div[2]/div/div");
	By uncheckedInfoError=By.xpath("//*[@id=\"cdk-step-content-0-2\"]/app-policy-details/form/div[4]/div");
	
	 public PolicyDetails(WebDriver driver) {
		   this.driver=driver;
	   }
	 public void policyDetailsValid(String date,int length) {
		 driver.findElement(this.date).sendKeys(date);
		 WebElement policyLen=driver.findElement(this.length);
		 Select select=new Select(policyLen);
		 select.selectByIndex(length);
		 driver.findElement(this.protectInfo).click();
		 driver.findElement(this.insureDoc).click();
		 driver.findElement(btn).click();
	 }
	
	
	public WebElement setDate(String date) {
		WebElement startdate = driver.findElement(this.date);
		if(date!=null) {
		startdate.sendKeys(date);}
		return startdate;
	}
	public WebElement setLength(int length) {
		WebElement policyLen=driver.findElement(this.length);
		Select select=new Select(policyLen);
		if(length>=0) {
		select.selectByIndex(length);}
		return policyLen;
	}
	public void setProtectInfo(boolean protectInfo) {
		WebElement info=driver.findElement(this.protectInfo);
		if(protectInfo) {
		info.click();}
		else {info.click();
		info.click();}
		
	}
	public void setInsureDoc(boolean insureDoc) {
		WebElement doc=driver.findElement(this.insureDoc);
		if(insureDoc) {
			doc.click();}
			else {doc.click();
			doc.click();}
	}
	
	public boolean setButton(boolean value) {
	  	boolean enabled;
	  	WebElement submit=driver.findElement(btn);
	  	if(value) {
	  	 enabled=submit.isEnabled();
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
	 public String getEmptyValueErrorMessage() {
		  	String text=driver.findElement(this.emptydateError).getText();
		  	return text;
		  }
		  
	 public String getIncorrectValueErrorMessage() {
		  	String text=driver.findElement(this.uncheckedInfoError).getText();
		  	return text; 
		  }	
}
