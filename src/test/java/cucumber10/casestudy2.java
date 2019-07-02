package cucumber10;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class casestudy2 {
	WebDriver driver;
	@Given("^login to the homepage$")
	public void login_to_the_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGenTesting\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		
	    
	}

	@When("^user enter with valid \"(.*?)\" and \"(.*?)\"$")
	public void user_enter_with_valid_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.linkText("SignIn")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.findElement(By.name("userName")).sendKeys("AlexUser");
	   driver.findElement(By.name("password")).sendKeys("Alex@123");
	   driver.findElement(By.name("Login")).click();
	}

	@Then("^successfully user login$")
	public void successfully_user_login() throws Throwable {
		String title=driver.getTitle();
		Assert.assertEquals("Home", title);
	
		System.out.println("Successfully login");
		driver.navigate().back();
		driver.close();
	   
	}



}
