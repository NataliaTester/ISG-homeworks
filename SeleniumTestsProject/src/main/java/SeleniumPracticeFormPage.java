import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SeleniumPracticeFormPage extends PageObject {

    @FindBy(name = "firstname")
    private WebElement firstnameElement;
    @FindBy(name = "lastname")
    private WebElement lastnameElement;
    @FindBy(id = "sex-0")
    private WebElement maleRadioBtnElement;
    @FindBy(id = "sex-1")
    private WebElement femaleRadioBtnElement;
    @FindBy(id = "exp-0")
    private WebElement oneYearOfExp;
    @FindBy(id = "exp-1")
    private WebElement twoYearsOfExp;
    @FindBy(id = "exp-2")
    private WebElement threeYearsOfExp;
    @FindBy(id = "exp-3")
    private WebElement fourYearsOfExp;
    @FindBy(id = "exp-4")
    private WebElement fiveYearsOfExp;
    @FindBy(id = "exp-5")
    private WebElement sixYearsOfExp;
    @FindBy(id = "exp-6")
    private WebElement sevenYearsOfExp;
    @FindBy(xpath = "//option[contains(text(),'Asia')]")
    private WebElement asiaOption;
    @FindBy(xpath = "//option[contains(text(),'Europe')]")
    private WebElement europeOption;
    @FindBy(xpath = "//option[contains(text(),'Africa')]")
    private WebElement africaOption;
    @FindBy(xpath = "//option[contains(text(),'Australia')]")
    private WebElement australiaOption;
    @FindBy(xpath = "//option[contains(text(),'South America')]")
    private WebElement southAmericaOption;
    @FindBy(xpath = "//option[contains(text(),'North America')]")
    private WebElement northAmericaOption;
    @FindBy(xpath = "//option[contains(text(),'Antartica')]")
    private WebElement antarticaOption;
    @FindBy(id = "submit")
    private WebElement submitBtn;


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

    public SeleniumPracticeFormPage chooseGender(String gender) {
        if (gender.equals("male")) {
            maleRadioBtnElement.click();
        } else if (gender.equals("female")) {
            femaleRadioBtnElement.click();
        } else {
            System.out.println("Invalid gender");
        }
        return this;
    }

    public SeleniumPracticeFormPage chooseYearsOfExperience(Number yearsOfExperience) {
        if (yearsOfExperience.equals(1)) {
            oneYearOfExp.click();
        } else if (yearsOfExperience.equals(2)) {
            twoYearsOfExp.click();
        } else if (yearsOfExperience.equals(3)) {
            threeYearsOfExp.click();
        } else if (yearsOfExperience.equals(4)) {
            fourYearsOfExp.click();
        } else if (yearsOfExperience.equals(5)) {
            fiveYearsOfExp.click();
        } else if (yearsOfExperience.equals(6)) {
            sixYearsOfExp.click();
        } else if (yearsOfExperience.equals(7)) {
            sevenYearsOfExp.click();
        } else {
            System.out.println("Invalin Experiance");
        }
        return this;
    }

    public SeleniumPracticeFormPage chooseContinent(String continent) {
        if (continent.equals("Asia")) {
            asiaOption.click();
        } else if (continent.equals("Europe")) {
            europeOption.click();
        } else if (continent.equals("Africa")) {
            africaOption.click();
        } else if (continent.equals("Australia")) {
            australiaOption.click();
        } else if (continent.equals("South America")) {
            southAmericaOption.click();
        } else if (continent.equals("North America")) {
            northAmericaOption.click();
        } else if (continent.equals("Antartica")) {
            antarticaOption.click();
        }
        return this;
    }

    public SeleniumPracticeFormPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    //checks

    public SeleniumPracticeFormPage checkName(String firstname, String lastname) {
        Assert.assertEquals(firstnameElement.getAttribute("value"), firstname, "Invalid first name");
        Assert.assertEquals(lastnameElement.getAttribute("value"), lastname, "Invalid last name");
        return this;
    }

    public SeleniumPracticeFormPage checkGender(String gender) {
        if (gender.equals("male")) {
            Assert.assertTrue(Boolean.parseBoolean(maleRadioBtnElement.getAttribute("selected")));
        } else if (gender.equals("female")) {
            Assert.assertTrue(Boolean.parseBoolean(femaleRadioBtnElement.getAttribute("selected")));
        } else {
            System.out.println("Invalid gender");
        }
        return this;
    }

    public SeleniumPracticeFormPage checkExperience(Number yearsOfExperience) {
        if (yearsOfExperience.equals(1)) {
            Assert.assertTrue(Boolean.parseBoolean(oneYearOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(2)) {
            Assert.assertTrue(Boolean.parseBoolean(twoYearsOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(3)) {
            Assert.assertTrue(Boolean.parseBoolean(threeYearsOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(4)) {
            Assert.assertTrue(Boolean.parseBoolean(fourYearsOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(5)) {
            Assert.assertTrue(Boolean.parseBoolean(fiveYearsOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(6)) {
            Assert.assertTrue(Boolean.parseBoolean(sixYearsOfExp.getAttribute("selected")));
        } else if (yearsOfExperience.equals(7)) {
            Assert.assertTrue(Boolean.parseBoolean(sevenYearsOfExp.getAttribute("selected")));
        } else {
            System.out.println("Invalin Experiance");
        }
        return this;
    }
}
