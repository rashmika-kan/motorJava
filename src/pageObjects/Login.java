package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login {
	private WebDriver driver;
	By user=By.id("email");
	By pwd=By.id("password");
	By lgnBtn=By.id("login");
	By errorMessage=By.xpath("/html/body/app-root/app-login/main/div/div/div/div[2]/div/form/div[3]");
	By vehicleInfoTitle=By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/h1/b");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String signUp(String username,String password,String name) throws InterruptedException {
		driver.findElement(user).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(lgnBtn).click();
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		//System.out.println("Text in the alert: "+alertText);
		alert.sendKeys(name);
		alert.accept();
		WebElement title=driver.findElement(vehicleInfoTitle);
		String text=title.getText();
		return text;
		
		
	}
	
	public boolean invalidCredentials(String username,String password) throws InterruptedException {
		driver.findElement(user).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(lgnBtn).click();
		WebElement error=driver.findElement(errorMessage);
		boolean isDisplayed=error.isDisplayed();
//		Alert alert=driver.switchTo().alert();
//		String text=alert.getText();
//		alert.accept();
		return isDisplayed;
		
	}
	
//	public String checkUser(String username,String password) {
//		
//	}
	
	

}
