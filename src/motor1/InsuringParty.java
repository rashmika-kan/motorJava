package motor1;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsuringParty {
      
	WebDriver driver;
	
	
	  @Test(priority=0)
	  public void insuringPartyValid() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  WebElement email=driver.findElement(By.id("email"));
		  email.sendKeys("admin");
		  
		  WebElement password=driver.findElement(By.id("password"));
		  password.sendKeys("admin");
		  
		  Thread.sleep(5000);
		  
		  WebElement lgnBtn=driver.findElement(By.id("login"));
		  lgnBtn.click();
		  
		  //Vehicle-Info
		  
		  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
		  regNo.sendKeys("12345678");
		  
		  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
		  certNo.sendKeys("123456789");
		  
		  WebElement dropdown=driver.findElement(By.cssSelector("select[formControlName=purpose]"));
		  Select select=new Select(dropdown);
		  select.selectByValue("personal");
		  
		  WebElement radio=driver.findElement(By.cssSelector("input[value=Yes]"));
		  radio.click();
		  
		  Thread.sleep(5000);
		  
		  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
		  
		  btn.click();
		  Thread.sleep(5000);
		  
		  //Insuring Party
		  
		  WebElement egn=driver.findElement(By.cssSelector("input[formControlName=egn]"));
		  egn.sendKeys("random");
		  
		  WebElement residence=driver.findElement(By.cssSelector("select[formControlName=address]"));
		  Select select1=new Select(residence);
		  select1.selectByValue("mumbai");
		  
		  WebElement insureEmail=driver.findElement(By.cssSelector("input[formControlName=email]"));
		  insureEmail.sendKeys("random@gmail.com");
		  
		  Thread.sleep(5000);
		  
		  WebElement insurebtn=driver.findElement(By.cssSelector("button[type=button]"));
		  Boolean value=insurebtn.isEnabled();
		  
		  insurebtn.click();
		  Thread.sleep(5000);
		  
		  WebElement title=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[3]/app-policy-details/h1"));
		  String text= title.getText();
		  
		  
		  System.out.println("Is button enabled: "+value);
		  System.out.println("Submit successful.Moves to the Policy Details page.");
		  
		  System.out.println("The title of next page : "+text);
		  Assert.assertEquals("Policy Details", text);
	  }
	  
	  
	  
	  
	  @Test(priority=1)
	  public void insuringPartyInvalidEmptyValue() throws InterruptedException {
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  WebElement email=driver.findElement(By.id("email"));
		  email.sendKeys("admin");
		  
		  WebElement password=driver.findElement(By.id("password"));
		  password.sendKeys("admin");
		  
		  //Thread.sleep(5000);
		  
		  WebElement lgnBtn=driver.findElement(By.id("login"));
		  lgnBtn.click();
		  
		  //Vehicle-Info
		  
		  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
		  regNo.sendKeys("12345678");
		  
		  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
		  certNo.sendKeys("123456789");
		  
		  WebElement dropdown=driver.findElement(By.cssSelector("select[formControlName=purpose]"));
		  Select select=new Select(dropdown);
		  select.selectByValue("personal");
		  
		  WebElement radio=driver.findElement(By.cssSelector("input[value=Yes]"));
		  radio.click();
		  
		  //Thread.sleep(5000);
		  
		  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
		  
		  btn.click();
		  Thread.sleep(5000);
		  
		  //Insuring Party
		  
		  WebElement egn=driver.findElement(By.cssSelector("input[formControlName=egn]"));
		  egn.click();
		  
		  WebElement residence=driver.findElement(By.cssSelector("select[formControlName=address]"));
		  Select select1=new Select(residence);
		  select1.selectByValue("mumbai");
		  
		  WebElement insureEmail=driver.findElement(By.cssSelector("input[formControlName=email]"));
		  insureEmail.sendKeys("random@gmail.com");
		  
		  Thread.sleep(5000);
		  
		  WebElement insurebtn=driver.findElement(By.cssSelector("button[type=button]"));
		  Boolean value=insurebtn.isEnabled();
		  
		  WebElement error=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/div/form/div[1]/div[2]/div/div"));
		  String errorMessage=error.getText();
		  
		  System.out.println("No value entered in EGN/EIK/LNCH after clicking the textbox");
		  System.out.println("Is button enabled: "+value);
		  System.out.println("Error message found: "+errorMessage);
		  
		  Assert.assertEquals("EGN/EIK/LNCH is required", errorMessage);
	  }
	  
	  
	  @Test(priority=2)
	  public void insuringPartyInvalidIncorrectValue() throws InterruptedException {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  WebElement email=driver.findElement(By.id("email"));
		  email.sendKeys("admin");
		  
		  WebElement password=driver.findElement(By.id("password"));
		  password.sendKeys("admin");
		  
		  //Thread.sleep(5000);
		  
		  WebElement lgnBtn=driver.findElement(By.id("login"));
		  lgnBtn.click();
		  
		  //Vehicle-Info
		  
		  WebElement regNo=driver.findElement(By.cssSelector("input[formControlName=registrationNumber]"));
		  regNo.sendKeys("12345678");
		  
		  WebElement certNo=driver.findElement(By.cssSelector("input[formControlName=certificateNumber]"));
		  certNo.sendKeys("123456789");
		  
		  WebElement dropdown=driver.findElement(By.cssSelector("select[formControlName=purpose]"));
		  Select select=new Select(dropdown);
		  select.selectByValue("personal");
		  
		  WebElement radio=driver.findElement(By.cssSelector("input[value=Yes]"));
		  radio.click();
		  
		  //Thread.sleep(5000);
		  
		  WebElement btn=driver.findElement(By.cssSelector("button[type=submit]"));
		  
		  btn.click();
		  Thread.sleep(5000);
		  
		  //Insuring Party
		  
		  WebElement egn=driver.findElement(By.cssSelector("input[formControlName=egn]"));
		  egn.sendKeys("random");
		  
		  WebElement insureEmail=driver.findElement(By.cssSelector("input[formControlName=email]"));
		  insureEmail.sendKeys("randomgmailcom");
		  
		  WebElement residence=driver.findElement(By.cssSelector("select[formControlName=address]"));
		  Select select1=new Select(residence);
		  select1.selectByValue("mumbai");
		  
		  
		  Thread.sleep(10000);
		  
		  WebElement insurebtn=driver.findElement(By.cssSelector("button[type=button]"));
		  Boolean value=insurebtn.isEnabled();
		  
		  WebElement error=driver.findElement(By.xpath("/html/body/app-root/app-tab/mat-tab-group/div/mat-tab-body[1]/div/app-mtpl-calculator/mat-horizontal-stepper/div[2]/div[2]/app-insuring-party/div/form/div[3]/div[2]/div/div"));
		  String errorMessage=error.getText();
		  
		  System.out.println("Incorrect value entered in email");
		  System.out.println("Is button enabled: "+value);
		  System.out.println("Error message found: "+errorMessage);
		  
		  Assert.assertEquals("Please enter a valid email", errorMessage);
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

	
}
