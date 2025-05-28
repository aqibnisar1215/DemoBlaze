package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    String comfirmedMassegeProductAdded;

    public ProductPage(WebDriver driver)
    {
        super(driver);
    }

}
