package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HDFC_Netbanking_Login_TestNG {

	@Test
    public void HDFCBrowserLaunch() throws InterruptedException {
 
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
        
        driver.switchTo().frame("login_page");
        driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
        driver.findElement(By.linkText("CONTINUE")).click();
        //driver.findElement(By.xpath("")).sendKeys("abc");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("")).click();
	
}
}