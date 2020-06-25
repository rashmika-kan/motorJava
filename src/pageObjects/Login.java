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
	By vehicleInfoTitle=By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/h1/b");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String signUp(String username,String password) {
		driver.findElement(user).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(lgnBtn).click();
		WebElement title=driver.findElement(vehicleInfoTitle);
		String text=title.getText();
		return text;
		
		
	}
	
	public String invalidCredentials(String username,String password) {
		driver.findElement(user).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(lgnBtn).click();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		return text;
		
	}
	
	

}
