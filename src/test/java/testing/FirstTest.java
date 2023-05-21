package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
	private WebDriver driver;
	By verifyregisterLocator = By.xpath("//html/body/section/section/main/section/div/div/header/h1");
	By loginLocatorbutton = By.xpath("//html/body/div/div[5]/div[3]/header/div[1]/div/div/div[3]/button[1]");
	By username = By.id("username");
	By password = By.id("password");
	By login = By.name("action");
	By logueado = By.xpath("//html/body/div[1]/div[5]/div[3]/header/div[2]/div/div/div/div[2]/ul/li[1]/a");

	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromewebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://lanacion.com.ar");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		Thread.sleep(8000);
		driver.findElement(loginLocatorbutton).click();
		if (driver.findElement(verifyregisterLocator).isDisplayed()) {
			driver.findElement(username).sendKeys("rodrigo.testing.java@gmail.com");
			driver.findElement(password).sendKeys("Montevideo47");
			driver.findElement(login).click();
			Thread.sleep(12000);
			assertTrue(driver.findElement(logueado).isDisplayed());
			
		}
		else
		fail("Not yet implemented");
	}

}