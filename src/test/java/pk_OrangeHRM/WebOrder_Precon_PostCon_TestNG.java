package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrder_Precon_PostCon_TestNG {

	//Global Variable Declaration
	ChromeDriver driver;

	@Test
	public void Login_Test() {

		// 3. Enter the valid user name
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		// 4. Enter the valid valid password
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		// 5. Click on Login button
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		// Exp Result : Verify that user is on Dashboard page
		driver.findElement(By.linkText("Order")).isDisplayed();
		// Click on Logout button
		driver.findElement(By.linkText("Logout")).click();
	}

	@BeforeTest
   public void LaunchChromeBrowser() {
		// 1. Launch the Chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 2. Enter the URL
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

	}

	@AfterTest
   public void CloseBrowser() {
		
		// Close the Browser
					driver.quit();
	}
}
