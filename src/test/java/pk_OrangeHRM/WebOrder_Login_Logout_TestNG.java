package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebOrder_Login_Logout_TestNG {
	
	 @Test
	  public void Login_Test() {
		  
			// 1. Launch the Chrome browser
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
			// 2. Enter the URL
			driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
			// 3. Enter the valid user name
			driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
			// 4. Enter the valid valid password
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
			// 5. Click on Login button
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();
			 
			// Exp Result : Verify that user is on Dashboard page
			driver.findElement(By.linkText("Order")).isDisplayed();
			//Click on Logout button
			driver.findElement(By.linkText("Logout")).click();
			// Close the Browser
			driver.quit();
	  }

}
