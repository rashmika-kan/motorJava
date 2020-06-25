package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasePage {
  
protected WebDriver driver;
	
    @BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RASHMIKA\\Desktop\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://localhost:4200/");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}
	
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
}
