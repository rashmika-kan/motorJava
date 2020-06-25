package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class VehicleInfo {
	private WebDriver driver;
	
	By regNo=By.id("registrationNumber");
	By certNo=By.id("certificateNumber");
	By purpose=By.cssSelector("select[formControlName=purpose]");
	By btn=By.cssSelector("button[type=submit]");
	By title=By.xpath("//*[@id=\"cdk-step-content-0-1\"]/app-insuring-party/h1/b");
	By emptyCertificationError=By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/form/div[2]/div[2]/div/div");
	By incorrectRegistrationError=By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/form/div[1]/div[2]/div/div");
	
	public VehicleInfo(WebDriver driver) {
		this.driver=driver;
	}
	
	public void VehicleInfoValid(String registrationNumber,String certificationNumber,int index) {
		driver.findElement(regNo).sendKeys(registrationNumber);
		driver.findElement(certNo).sendKeys(certificationNumber);
		
		WebElement dropdown=driver.findElement(purpose);
    	Select select=new Select(dropdown);
    	
    	select.selectByIndex(index);
    	driver.findElement(btn).click();	
	}
 
    public WebElement setRegistrationNumber(String registrationNumber) {
    	WebElement rNo=driver.findElement(regNo);
    	if(registrationNumber!=null) {
    	rNo.sendKeys(registrationNumber);}
    	return rNo;
    }
    
    public WebElement setCertificationNumber(String certificationNumber) {
    	WebElement cNo=driver.findElement(certNo);
    	if(certificationNumber!=null) {
        	cNo.sendKeys(certificationNumber);}
        	return cNo;
    }
    
    public void setPurpose(int index) {
    	WebElement dropdown=driver.findElement(purpose);
    	Select select=new Select(dropdown);
    	if(index>=0) {
    	select.selectByIndex(index);}
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
    	String text=driver.findElement(emptyCertificationError).getText();
    	return text;
    }
    
    public String getIncorrectValueErrorMessage() {
    	String text=driver.findElement(incorrectRegistrationError).getText();
    	return text; 
    }
}
