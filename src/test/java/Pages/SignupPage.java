package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String confirmMessage;
    public SignupPage(WebDriver driver) {

        super(driver);
    }

    // Identify the web elements
    @FindBy(id = "sign-username") WebElement usernameField;

    @FindBy(id = "sign-password") WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Sign up']") WebElement signupBtn;

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    public void clickSignUpBtn() {
        wait.until(ExpectedConditions.visibilityOf(signupBtn));
        signupBtn.click();
    }
    public void signup(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickSignUpBtn();
    }
    public String confirmMessage() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            confirmMessage = alert.getText();
            alert.accept();
            System.out.println(confirmMessage);
            return confirmMessage;
        }catch (Exception e)
        {
            return "the Alert not present as :"+e;
        }
    }
}
