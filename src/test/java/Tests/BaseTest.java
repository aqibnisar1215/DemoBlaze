package Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterTest
    public static void TearDown()
    {
        driver.close();
    }

    // Generate the randomString
    public static String randomString(){

        return RandomStringUtils.randomAlphabetic(7);
    }
    // Generate the randomNumber
    public static String randomNumber(){

        return RandomStringUtils.randomNumeric(6);
    }
}
