package motor1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class VehicleInfo {
	WebDriver driver;
	
	
  @Test
  public void VehicleInfoValid() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("admin");
	  
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("admin");
	  
	  Thread.sleep(5000);
	  
	  WebElement lgnBtn=driver.findElement(By.id("login"));
	  lgnBtn.click();
	  
	  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
	  regNo.sendKeys("12345678");
	  
	  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
	  certNo.sendKeys("123456789");
	  
	  WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/app-v-info/form/div[3]/div[2]/select"));
	  Select select=new Select(dropdown);
	  select.selectByIndex(0);
	  
	  WebElement radio=driver.findElement(By.cssSelector("input[value=Yes]"));
	  radio.click();
	  
	  Thread.sleep(10000);
	  
	  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
	  Boolean value=btn.isEnabled();
	  
	  btn.click();
	  Thread.sleep(5000);
	  
	  WebElement title=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/div/h1"));
	  String text= title.getText();
	  
	  Thread.sleep(5000);
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Submit successful.Moves to the insuring party page.");
	  
	  System.out.println("The title of next page : "+text);
	  Assert.assertEquals("Insuring Party", text);
  }
  
  //@Test
  public void VehicleInfoInvalidEmptyValue() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("admin");
	  
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("admin");
	  
	  WebElement lgnBtn=driver.findElement(By.id("login"));
	  lgnBtn.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
	  regNo.sendKeys("12345678");
	  
	  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
	  certNo.click();
	  
	  WebElement dropdown=driver.findElement(By.cssSelector("select[formControlName=purpose]"));
	  Select select=new Select(dropdown);
	  select.selectByIndex(0);
	  
	  Thread.sleep(10000);
	  
	  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
	  Boolean value=btn.isEnabled();
	  
	  WebElement error=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[1]/app-v-info/form/div[2]/div[2]/div/div"));
	  String errorMessage=error.getText();
	  
	  System.out.println("No value entered in Vehicle Certificate Number after clicking the textbox");
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals("Vehicle Certificate Number is required", errorMessage);
  }
  
  
  //@Test
  public void VehicleInfoInvalidIncorrectValue() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("admin");
	  
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys("admin");
	  
	  WebElement lgnBtn=driver.findElement(By.id("login"));
	  lgnBtn.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
	  regNo.sendKeys("1234567");
	  
	  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
	  certNo.sendKeys("123456789");
	  
	  WebElement dropdown=driver.findElement(By.cssSelector("select[formControlName=purpose]"));
	  Select select=new Select(dropdown);
	  select.selectByIndex(0);
	  
	  Thread.sleep(10000);
	  
	  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
	  Boolean value=btn.isEnabled();
	  
	  WebElement error=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[1]/app-v-info/form/div[1]/div[2]/div/div"));
	  String errorMessage=error.getText();
	  
	  System.out.println("Incorrect value entered in Vehicle Certificate Number");
	  System.out.println("Is button enabled: "+value);
	  System.out.println("Error message found: "+errorMessage);
	  
	  Assert.assertEquals("Vehicle Registartion Number Should be 8 characters", errorMessage);
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

  @BeforeClass
  public void beforeClass() {
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
