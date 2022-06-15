package pk_OrangeHRM;

import org.testng.annotations.DataProvider;

public class OrangeHRM_TestData_TestNG {

	@DataProvider(name = "Login")
    public Object[][] getDataforLogin() {
        // Multidimensional Object
        // 3X3 or 4X3 or 4X5
        return new Object[][] {
 
                {"Admin", "admin123" },
                {"raman", "admin123" },
                {"dixit", "admin123" },
                {"dinesh", "admin123" },
                {" ", "admin123"}
                };
 
    }
}