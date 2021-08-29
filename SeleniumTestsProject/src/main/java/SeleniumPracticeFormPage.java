import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumPracticeFormPage extends PageObject {

    @FindBy(name = "firstname")
    private WebElement firstnameElement;
    @FindBy(name = "lastname")
    private WebElement lastnameElement;

    public SeleniumPracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public SeleniumPracticeFormPage fillName(String firstname, String lastname) {
        firstnameElement.clear();
        firstnameElement.sendKeys(firstname);
        lastnameElement.clear();
        lastnameElement.sendKeys(lastname);
        return this;
    }
}
