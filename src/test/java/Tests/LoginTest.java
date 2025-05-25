package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.FileUtility;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{

    String ValidUserName = FileUtility.getFile("ValidLoginData").getString("username");

    String ValidPassword = FileUtility.getFile("ValidLoginData").getString("password");

    String actualUserLogin;

    String exoectedUseLogin = "welcom"+ValidUserName;

    @Test
    public void validLoginTest(){

        HomePage hompage =new HomePage(driver);

        hompage.ClickLoginBtn();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ValidUserName, ValidPassword);

        actualUserLogin = loginPage.VerifyUserLogin();

        System.out.println(actualUserLogin);

        Assert.assertEquals(actualUserLogin,exoectedUseLogin);
    }
}
