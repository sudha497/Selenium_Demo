package pk_OrangeHRM;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class SmartBear_Delete_Order_TestNG {
	public class AddOrders_VerifyOrders_Weborders {
	ChromeDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
	driver.quit();
	}

	@Test
	// This is for Sign On Functionality
	public void AddUser_VerifyUser() throws InterruptedException

	{

	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
	driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	driver.findElement(By.linkText("Order")).click();
	// String Element = driver.findElement(By.linkText("Order")).getText();
	//System.out.println(Element);



	//WebElement orders = driver.findElement(By.id("Order"));

	// Actions action = new Actions(driver);
	// action.moveToElement(orders).build().perform();
	Select SelectPass = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
	//SelectPass.selectByValue("1");
	//SelectPass.selectByIndex(0);
	SelectPass.selectByVisibleText("MyMoney");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("10");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("100");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("2");

	driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Sudha");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("2 Mart ST");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Chennai");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Tamilnadu");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("600097");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("123456789012");
	 driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("06/27");
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	driver.findElement(By.linkText("View all orders")).click();
	String Customername = driver.findElement(
	By.xpath("//table/tbody/tr[2]/td[2]")).getText();
	System.out.println(Customername);
	String name="Sudha";
	driver.navigate().refresh();
	Thread.sleep(2000);
	WebElement cellIneed = driver.findElement(By.xpath("//*[text()='"+ name +"']"));
	String ActualUserName = cellIneed.getText();
	System.out.println("Cell value is : " + ActualUserName);
	Assert.assertEquals(name, ActualUserName);

	System.out.println("Order placed successfully with the name of : " + ActualUserName);



	//Delete User from Search List
	driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//preceding::input[1]")).click();
	// driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input")).click();
	//driver.findElementByXPath("//td/a[text()='"+ExpUserName+"']//parent::td/../td/input").click();
	//driver.findElementByXPath("//td/a[text()='"+ExpUserName+"']//parent::td/../td[text()='Admin']").isDisplayed();
	//driver.findElementByXPath("//a[text()='"+ExpUserName+"']/parent::td/../td[text()='Admin']/../td/input").click();;
	Thread.sleep(5000);
	// driver.findElement(By.id("")).click();
	driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
	Thread.sleep(5000);
	//Verify that user got deleted from the WebTable



	Boolean deleteduser = driver.getPageSource().contains(name);
	Assert.assertFalse(deleteduser);

	System.out.println("Order cancelled successfully with the name of : " + ActualUserName);
	driver.close();
	}
	}
	}

