package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PersonalDetails {
	WebDriver driver;
	
	public PersonalDetails(WebDriver driver) {
		  this.driver=driver;
	  }
  
	By lnch=By.id("lnch");
	By fname=By.id("firstname");
	By mname=By.id("lastname");
	By lname=By.id("surname");
	By fnameEng=By.id("firstnameeng");
	By mnameEng=By.id("lastnameeng");
	By lnameEng=By.id("surnameeng");
	By citi=By.id("citizen");
	By bdate=By.id("birth");
	By btn=By.cssSelector("button[type=submit]");
	By incorrectValue=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[2]/div/app-mtpl-policy/div/mat-horizontal-stepper/div[2]/div[1]/app-personal/form/div[1]/div/div");
	By emptyValue=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[2]/div/app-mtpl-policy/div/mat-horizontal-stepper/div[2]/div[1]/app-personal/form/div[2]/div/div[3]/div");
	By title=By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[2]/div/app-mtpl-policy/div/mat-horizontal-stepper/div[2]/div[2]/app-contact/h1/b");
	
	public void personalDetailsValid(String lnch,String  fname,String  mname,String  lname,String  fnameEng,String  mnameEng,String  lnameEng,int citi,String  bdate) {
		    WebElement lnchEmnt=driver.findElement(this.lnch);
			lnchEmnt.sendKeys(lnch);
			WebElement fnameEmnt=driver.findElement(this.fname);
		    fnameEmnt.sendKeys(fname);
		    WebElement mnameEmnt=driver.findElement(this.mname);
			mnameEmnt.sendKeys(mname);
			WebElement lnameEmnt=driver.findElement(this.lname);
			lnameEmnt.sendKeys(lname);
			WebElement fnameEngEmnt=driver.findElement(this.fnameEng);
			fnameEngEmnt.sendKeys(fnameEng);
			WebElement mnameEngEmnt=driver.findElement(this.mnameEng);
			mnameEngEmnt.sendKeys(mnameEng);
			WebElement lnameEngEmnt=driver.findElement(this.lnameEng);
			lnameEngEmnt.sendKeys(lnameEng);
			WebElement citizen=driver.findElement(this.citi);
			Select citiSelect=new Select(citizen);
			citiSelect.selectByIndex(citi);
			WebElement birthdate=driver.findElement(this.bdate);
			birthdate.sendKeys(bdate);
			WebElement submit=driver.findElement(this.btn);
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();",submit);
	}
	
	
	public WebElement setLnch(String lnch) {
		WebElement lnchEmnt=driver.findElement(this.lnch);
		if(lnch!=null) {
			lnchEmnt.sendKeys(lnch);
		}
		else {lnchEmnt.click();}
		return lnchEmnt;
	}
	public WebElement setFname(String  fname) {
		WebElement fnameEmnt=driver.findElement(this.fname);
		if(fnameEmnt!=null) {
			fnameEmnt.sendKeys(fname);
		}
		else {fnameEmnt.click();}
		return fnameEmnt;
	}
	public WebElement setMname(String  mname) {
		WebElement mnameEmnt=driver.findElement(this.mname);
		if(mname!=null) {
			mnameEmnt.sendKeys(mname);
		}
		else {mnameEmnt.click();}
		return mnameEmnt;
	}
	public WebElement setLname(String  lname) {
		WebElement lnameEmnt=driver.findElement(this.lname);
		if(lname!=null) {
			lnameEmnt.sendKeys(lname);
		}
		else {lnameEmnt.click();}
		return lnameEmnt;
	}
	public WebElement setFnameEng(String  fnameEng) {
		WebElement fnameEngEmnt=driver.findElement(this.fnameEng);
		if(fnameEng!=null) {
			fnameEngEmnt.sendKeys(fnameEng);
		}
		else {fnameEngEmnt.click();}
		return fnameEngEmnt;
	}
	public WebElement setMnameEng(String  mnameEng) {
		WebElement mnameEngEmnt=driver.findElement(this.mnameEng);
		if(mnameEng!=null) {
			mnameEngEmnt.sendKeys(mnameEng);
		}
		else {mnameEngEmnt.click();}
		return mnameEngEmnt;
	}
	public WebElement setLnameEng(String  lnameEng) {
		WebElement lnameEngEmnt=driver.findElement(this.lnameEng);
		if(lnameEng!=null) {
			lnameEngEmnt.sendKeys(lnameEng);
		}
		else {lnameEngEmnt.click();}
		return lnameEngEmnt;
	}
	public Select setCiti(int citi) {
		WebElement citizen=driver.findElement(this.citi);
		Select citiSelect=new Select(citizen);
		if(citi>=0) {
			citiSelect.selectByIndex(citi);
		}
		else {citizen.click();}
		return citiSelect;
	}
	public WebElement setBdate(String  bdate) {
		WebElement birthdate=driver.findElement(this.bdate);
		if(birthdate!=null) {
			birthdate.sendKeys(bdate);
		}
		else {birthdate.click();}
		return birthdate;
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
	
	public String getIncorrectValueErrorMessage() {
	  	String text=driver.findElement(this.incorrectValue).getText();
	  	return text; 
	  }	
	
	public String getEmptyValueErrorMessage() {
	  	String text=driver.findElement(this.emptyValue).getText();
	  	return text;
	  }
  
  public String getTitle() {
	  	String text=driver.findElement(title).getText();
	  	return text;
	  }
	
	
}
