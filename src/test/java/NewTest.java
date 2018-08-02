import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.WebDriverFactory;

public class NewTest {
	private WebDriver driver;
  @Test (priority=2)
  public void Register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.name("firstName")).sendKeys("abcd1234");
	  driver.findElement(By.name("lastName")).sendKeys("xyz");
	  driver.findElement(By.name("phone")).sendKeys("321456987");
	  driver.findElement(By.id("userName")).sendKeys("abc123@gmail.com");
	  driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Accenture Phursungi");
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  driver.findElement(By.name("state")).sendKeys("Maharastra");
	  driver.findElement(By.name("postalCode")).sendKeys("500055");
	  
	  Select country = new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("user123");
	  
	  driver.findElement(By.name("password")).sendKeys("ravi1234");
	  driver.findElement(By.name("confirmPassword")).sendKeys("ravi1234");
	  driver.findElement(By.name("register")).click();	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = WebDriverFactory.createDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  PageFactory.initElements(driver, LoginPage.class);
  }
  @Test(dataProvider="usernameandpassword")
  public void login(String username,String password) {
  	//driver.findElement(By.linkText("sign-in")).click();
    LoginPage.uname.clear();
    LoginPage.uname.sendKeys(username);
    LoginPage.pass.sendKeys(password);
  	LoginPage.login_button.click();
  	driver.navigate().forward();
  	driver.navigate().back();
  	//Assert.assertEquals("Find a Flight", driver.getTitle());
  }

  
  @DataProvider(name = "usernameandpassword")
   public String [][] credentials(){
	  return new String [][]{
		  new String []{ "invalidUN","invalidPW"},
		  new String [] {"username1","password1"},
	  };
  }
  
  
  
   @Test(priority=3)
   public void BookFlight(){
	   
	   
   }
   

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}


