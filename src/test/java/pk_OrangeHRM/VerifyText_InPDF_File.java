package pk_OrangeHRM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyText_InPDF_File {
	
	  ChromeDriver driver;
	  
	 	String strURL="file:///C:/Users/ssudh/Downloads/Account%200000491483%20Loan%201601.pdf";
	    //String strURL="file:///D:/F%20Drive/EItin_DIXIT_BLR-AUH_TLWMAW43.pdf";
	    //Launching PDF file from your local system
	    @Test(priority=1,enabled=true)
	    public void testVerifyPDFTextInBrowser() throws IOException {
	 
	        URL url = new URL(strURL);
	        InputStream is= url.openStream();
	        BufferedInputStream file = new BufferedInputStream(is);
	        PDDocument document =null;
	        document=PDDocument.load(file);
	        String pdfContent = new PDFTextStripper().getText(document);
	       // System.out.println(pdfContent);
	        
	        Assert.assertTrue(pdfContent.contains("MEMBER BUSINESS SECURED LINE"));
	        //Assert.assertTrue(pdfContent.contains("MR ABHINAYKUMAR DIXIT"));

	    }
	  /*  //Launching PDF in browser and verifying
	    @Test(priority=2,enabled=true)
	    public void testVerifyPDFTextUsing_Get() throws IOException {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
	        String CurrentURL=driver.getCurrentUrl();
	        URL url = new URL(CurrentURL);
	        InputStream is= url.openStream();
	        BufferedInputStream file = new BufferedInputStream(is);
	        PDDocument document =null;
	        document=PDDocument.load(file);
	        String pdfContent = new PDFTextStripper().getText(document);
	        System.out.println(pdfContent);
	        Assert.assertTrue(pdfContent.contains("Dummy PDF file"));*/

	    
	// Note: We can't read or parse pdf which are scanned, as its treated as image

	    @AfterTest
	    public void tearDown() throws InterruptedException {

	        driver.quit();
	 
	    }

}
