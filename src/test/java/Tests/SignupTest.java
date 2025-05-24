package Tests;
import Pages.HomePage;
import Pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class SignupTest extends BaseTest{
    public String PROPERTIES_FILE = "src/test/resources/validLoginData.properties";
    public static String userName = randomString();
    public static  String passWord = randomNumber();
    String actualConfirmMessage;
    String expectedSuccessfulMessage = "Sign up successful.";

    @Test
    public void registerTest () {
        // Initialize the Object
        HomePage homePage = new HomePage(driver);

        // Click on the signup link
        homePage.ClickSignupBtn();

        // Initialize the Object
        SignupPage signupPage = new SignupPage(driver);

        // Perform signup action
        signupPage.signup(userName,passWord);

        // save the username and password in properties file
        saveCredentialToProperties(userName,passWord);

        // Assert for verification
        actualConfirmMessage = signupPage.confirmMessage();
        Assert.assertEquals(actualConfirmMessage,expectedSuccessfulMessage);
    }

    // Save credentials to the property file
    private void saveCredentialToProperties(String username, String password){
        Properties properties = new Properties();
        try(OutputStream output = new FileOutputStream(PROPERTIES_FILE)){
            properties.setProperty("username", username);
            properties.setProperty("password", password);
            properties.store(output, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
