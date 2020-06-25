package motor1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login {
	WebDriver driver;
	  @Test(priority=0)
	  public void loginInvalid() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  WebElement email=driver.findElement(By.id("email"));
		  email.sendKeys("admin123");
		  
		  WebElement password=driver.findElement(By.id("password"));
		  password.sendKeys("admin123");
		  
		  WebElement lgnBtn=driver.findElement(By.id("login"));
		  lgnBtn.click();
		  
		  Thread.sleep(5000);
		  
		  Alert alert=driver.switchTo().alert();
		  String alertStr=alert.getText();
		  
		  System.out.println("Login unsuccessful.Recieving message of pop-up.");
		  System.out.println("Alert message  : "+ alertStr);
		  
		  Assert.assertEquals("Invalid credentials", alertStr);
		  Thread.sleep(5000);
		  
		  alert.accept();
		  Thread.sleep(5000);
		  
	  }
		
		  @Test(priority=1)
		  public void loginValid() throws InterruptedException {
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  
			  WebElement email=driver.findElement(By.id("email"));
			  email.sendKeys("admin");
			  
			  WebElement password=driver.findElement(By.id("password"));
			  password.sendKeys("admin");
			  
			  Thread.sleep(5000);
			  
			  WebElement lgnBtn=driver.findElement(By.id("login"));
			  lgnBtn.click();
			  
			  Thread.sleep(5000);
			  
			  WebElement vRegNo=driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/h1/b"));
			  String regLabel=vRegNo.getText();
			  
			  Thread.sleep(5000);
			  System.out.println("Login successful.Moves to the vehicle info page.");
			  
			  System.out.println("The title of next page : "+regLabel);
			  Assert.assertEquals("Vehicle Information", regLabel);
			  
		  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\RASHMIKA\\Desktop\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://localhost:4200/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
