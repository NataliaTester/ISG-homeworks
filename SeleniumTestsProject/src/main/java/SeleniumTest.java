// homework 2

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest() throws InterruptedException {
        SeleniumPracticeFormPage practiceFormPage = new SeleniumPracticeFormPage(driver);

        Thread.sleep(3000);
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(3000);
        practiceFormPage.fillName("Natalia", "Chornii")
                .chooseGender("female")
                .chooseYearsOfExperience(3)
                .chooseContinent("Europe")
                .clickSubmit()
                .checkName("Natalia", "Chornii")
                .checkGender("female")
                .checkExperience(3);

        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}

