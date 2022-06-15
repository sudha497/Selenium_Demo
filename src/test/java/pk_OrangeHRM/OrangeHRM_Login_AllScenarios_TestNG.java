package pk_OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRM_Login_AllScenarios_TestNG {
	
	@DataProvider(name = "Login")
    public Object[][] getDataforLogin() {
        // Multidimensional Object
        // 3X3 or 4X3 or 4X5
        return new Object[][] {
 
                {"Admin", "admin123" },
                {"raman", "admin123" },
                {"dixit", "admin123" },
                {"dinesh", "admin123" }
                };
 
    }

	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
	    return new Object[][] { 
	            { "admin", "", "Password cannot be empty"},
	            { "", "admin123", "Username cannot be empty" }, 
	            { "AdminWrong", "admin123", "Invalid credentials" },
	            { "admin", "admin", "Invalid credentials" }, 
	            { "admin", "admin123", "Dashboard" } };

	}
	
	 //-------------------------------------------- This is to read Excel Data------------
	 
    @DataProvider(name = "LoginExcelData")
    public Object[][] ReadDataFromExcel() throws Exception{
        ReadExcel excel = new ReadExcel();
        String RelativePath = System.getProperty("user.dir");
        //Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xls","Login");
        Object[][] testObjArray = excel.getExcelData(RelativePath+"\\OrangeHRM_SignIn.xls","SignIn");
        System.out.println(testObjArray);
        return testObjArray;
 
    }
    @DataProvider(name = "AddUser")
    public Object[][] getDataforAddUser() {
    return new Object[][] {
    { "", "", "","","Employee does not exist"},
    { "", "Newgen T","admin123","admin123","Employee does not exist"},
    { "Fiona Grace", "","admin123","admin123", "Required" },
    { "Fiona Grace", "Newgen T","","", "Required Password" },
    { "Fiona Grace", "Newgen T","admin123","", "Passwords Empty" } ,
    { "Fiona Grace", "Newgen T","admin123","qwert123", "Different Passwords" },
    { "Fiona Grace", "Newgen T","admin123","admin123", "Username"}};
    }
	}
