package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginPageTest extends BaseTest {


    @Test(priority = 1, dataProvider = "validData")
    public void testValidLogin(String userName, String password, String message) {

        String actualResult = loginPage.signIn(userName, password);
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualResult, expectedResult, "Unable to login");
    }


    @Test(priority = 2, dataProvider = "invalidData")
    public void testInvalidLogin(String userName, String password, String message) {
        SoftAssert softAssert = new SoftAssert();
        String actualResult = loginPage.signIn(userName, password);
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        softAssert.assertNotEquals(actualResult, expectedResult, "Mustn't login " + message);
    }


    @DataProvider
    public Object[][] validData() {
        Object[][] data = new Object[1][3];

        //Valid username and valid password.
        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";
        data[0][2] = "Valid login";

        return data;
    }

    @DataProvider
    public Object[][] invalidData() {
        Object[][] data = new Object[2][3];

        //Valid username and invalid password.
        data[0][0] = "standard_user";
        data[0][1] = "123456";
        data[0][2] = "Invalid login , incorrect password";

        //Invalid username and invalid password.
        data[1][0] = "Fady_waheed";
        data[1][1] = "123456";
        data[1][2] = "Invalid login , invalid username and password";

        return data;
    }
}
