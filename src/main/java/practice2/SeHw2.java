package practice2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeHw2 {
	WebDriver driver;

	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		
		Random rnd = new Random();
	int random = 	rnd.nextInt(999);
		
		WebElement USER_NAME = driver.findElement(By.xpath("//input[@id='username']"));
		USER_NAME.sendKeys("demo@techfios.com ");

		WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']"));
		PASSWORD.sendKeys("abc123");

		Actions action = new Actions(driver);// login using keyboard event-Enter
		action.sendKeys(Keys.ENTER).build().perform();

		WebElement CUSTOMERS = driver.findElement(By.linkText("Customers"));
		CUSTOMERS.click();

		WebElement ADD_CUSTOMER = driver.findElement(By.linkText("Add Customer"));
		ADD_CUSTOMER.click();

		//WebElement FIRST_NAME = driver.findElement(By.cssSelector("input#account"));
		//FIRST_NAME.sendKeys("Naresh");
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("prativa"+ random);

		// DROP DOWN
		WebElement COMPANY = driver.findElement(By.xpath("//select[@id='cid']"));
		Select sel = new Select(COMPANY);
		sel.selectByVisibleText("Techfios");

		// WebElement EMAIL = driver.findElement(By.xpath("//input[@id='email']"));
		// EMAIL.sendKeys("demo@techfios.com");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(random +"abc@techfios.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567891");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("3317 Finley RD. STE# 242"+random);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(random +" Irving");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys(random +"TX");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys(random +" 75062");
		
		//DropDown
		WebElement COUNTRY = driver.findElement(By.id("country"));
		Select sel1 = new Select(COUNTRY);
		sel1.selectByVisibleText("Nepal");
		
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ab12");
		
		//driver.findElement(By.xpath("//button[@id='submit']")).click();

	}

}
