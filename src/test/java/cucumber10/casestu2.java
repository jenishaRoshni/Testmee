package cucumber10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber10.mercury.Credentials;

public class casestu2 {
	WebDriver driver;
	public class Credentials {
		public String username;
		public String password;
		
	}
	
	@Given("^enter into home page$")
	public void enter_into_home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGenTesting\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
		driver.manage().window().maximize();
	}
	@When("^user valid credential$")
	public void user_valid_credential(List<Credentials> userdata) throws Throwable {
		for(Credentials credentials:userdata){

	          driver.findElement(By.name("userName")).sendKeys(credentials.username);
	          driver.findElement(By.name("password")).sendKeys(credentials.password);
	          driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	          driver.navigate().back();
	}
	  
	}

	@Then("^succesful$")
	public void succesful() throws Throwable {
	    System.out.println("end");
	    driver.close();
	}

}