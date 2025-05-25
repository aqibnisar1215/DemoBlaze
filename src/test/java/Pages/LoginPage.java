package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );

    String nameOfuser;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    @FindBy(id = "loginusername") WebElement usernamefield;

    @FindBy(id = "loginpassword") WebElement passwordfield;

    @FindBy(xpath = "//button[normalize-space()='Log in']") WebElement loginBtn;

    @FindBy(id = "nameofuser") WebElement txt_nameOfUser;


    public void enterusername(String username){

        wait.until(ExpectedConditions.visibilityOf(usernamefield));

        usernamefield.sendKeys(username);
    }

    public void enterpassword(String password){

        wait.until(ExpectedConditions.visibilityOf(passwordfield));

        passwordfield.sendKeys(password);
    }
    public void ClickLoginBtn(){

        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }
    public void login(String username, String password){

        enterusername(username);
        enterpassword(password);
        ClickLoginBtn();
    }

    public String VerifyUserLogin(){
        try{

            wait.until(ExpectedConditions.visibilityOf(txt_nameOfUser));

            nameOfuser = txt_nameOfUser.getText();

            System.out.println(nameOfuser);

            return nameOfuser;
        }
        catch (Exception e ){
            return "The user is not present as"+e;
        }
    }
}
