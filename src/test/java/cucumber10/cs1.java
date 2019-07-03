package cucumber10;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class cs1 {
	int flag=0;
	WebDriver driver;
	@Given("^user need to register to use the app$")
	public void user_need_to_register_to_use_the_app() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\\\NexGenTesting\\\\chromedriver_win32\\\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.navigate().to("http://10.232.237.143:443/TestMeApp/");
	    driver.manage().window().maximize();
	    
	    
	}

	@When("^user give the valid credentials \"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\" and some details$")
	public void user_give_the_valid_credentials_and_some_details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
		String username=arg1;
		String firstname=arg2;
		String lastname=arg3;
		String password=arg4;
		String confirmpassword=arg5;
		String email=arg6;
		String mob=arg7;
		String dob=arg8;
		String address=arg9;
	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	driver.findElement(By.name("userName")).sendKeys(username);
	driver.findElement(By.name("firstName")).sendKeys(firstname);
	driver.findElement(By.name("lastName")).sendKeys(lastname);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
	driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/span[2]")).click();
	driver.findElement(By.name("emailAddress")).sendKeys(email);
	driver.findElement(By.name("mobileNumber")).sendKeys(mob);
	driver.findElement(By.name("dob")).sendKeys(dob);
	driver.findElement(By.name("address")).sendKeys(address);
	driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
	
	WebElement category=driver.findElement(By.id("securityQuestion"));
	Select s=new Select(category);
	List<WebElement> userdata=s.getOptions();
	
	for(WebElement e:userdata) {
		String option=e.getText();
		if(option.equals("What is your Favor color"))
{
	s.selectByVisibleText(option);
	flag=1;
	break;
	
}
	}
	driver.findElement(By.name("answer")).sendKeys("yellow");
	driver.findElement(By.name("Submit")).click();
	
	
		
	}

	@Then("^successfully register$")
	public void successfully_register() throws Throwable {
	String expected=driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText();
	String actual="User Registered Succesfully!!! Please login";
	Assert.assertEquals(expected, actual);
	}


}
