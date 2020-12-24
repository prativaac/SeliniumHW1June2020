package practicehw1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenumHw1 {
	WebDriver driver;

	/*
	 * 1: Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 2.
	 * Enter username: demo@techfios.com 3. Enter password: abc123 4. Click login
	 * button 5. Click on Bank & Cash button 6. Click on New Account button 7. Fill
	 * out the Add New Account form 8. Click on submit button 9. Visually check if
	 * the account has been created Visually check to make sure the deposit posted
	 */
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		WebElement USER_NAME = driver.findElement(By.xpath("//input[@id='username']"));
		USER_NAME.sendKeys("demo@techfios.com ");

		WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']"));
		PASSWORD.sendKeys("abc123");

		WebElement LOGIN = driver.findElement(By.xpath("//button[@name='login']"));
		LOGIN.click();

		WebElement BANKCASH = driver.findElement(By.xpath("//i[@class='fa fa-university']"));
		BANKCASH.click();

		WebElement NEWACCOUNT = driver.findElement(By.xpath("//a[contains(text(),'New Account')]"));
		NEWACCOUNT.click();

		WebElement ACCOUNT_TITLE = driver.findElement(By.xpath("//input[@id='account']"));
		ACCOUNT_TITLE.sendKeys("PQR2");

		WebElement DESCRIPTION = driver.findElement(By.xpath("//input[@id='description']"));
		DESCRIPTION.sendKeys("Checking account");

		WebElement INITIAL_BALANCE = driver.findElement(By.xpath("//input[@id='balance']"));
		INITIAL_BALANCE.sendKeys("5000");

		WebElement ACCOUNT_NUMBER = driver.findElement(By.xpath("//input[@id='account_number']"));
		ACCOUNT_NUMBER.sendKeys("123ABXC256");

		WebElement CONTACT_PERSON = driver.findElement(By.xpath("//input[@id='contact_person']"));
		CONTACT_PERSON.sendKeys("Naresh");

		WebElement PHONE_NUMBER = driver.findElement(By.xpath("//input[@id='contact_phone']"));
		PHONE_NUMBER.sendKeys("1234567890");

		WebElement URL = driver.findElement(By.xpath("//input[@id='ib_url']"));
		URL.sendKeys("ABCDF");

		WebElement SUBMIT = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		SUBMIT.click();

		Thread.sleep(4000);
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
