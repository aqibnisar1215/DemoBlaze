package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Identify the Web Elements
    @FindBy(id = "signin2") WebElement btn_Signup;
    @FindBy(id = "login2") WebElement btn_Login;

    //-----------------------------------------------------------------------------------------------

    By list_ProductNames_loc= By.xpath("//h4[@class='card-title']");

    @FindBy(xpath = "//a[@onclick=\"byCat('phone')\"]") WebElement btn_Phones;
    @FindBy(xpath = "//a[@onclick=\"byCat('notebook')\"]") WebElement btn_Laptops;

    //By btn_Cart_loc = By.id("cartur");

    public void  ClickSignupBtn(){
        wait.until(ExpectedConditions.visibilityOf(btn_Signup));
        btn_Signup.click();
    }

    public void  ClickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOf(btn_Login));
        btn_Login.click();
    }

    public List<String> getProductList() {
        List<WebElement> products = driver.findElements(list_ProductNames_loc);
        List<String> productNames = new ArrayList<>();

        for (WebElement product : products) {
            productNames.add(product.getText());
        }
        return productNames;
    }

    public void  ClickLapTopsBtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(btn_Laptops));
        btn_Laptops.click();
        Thread.sleep(3000);

    }

    public void  ClickPhoneBtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(btn_Phones));
        btn_Phones.click();
        Thread.sleep(3000);

    }
}
