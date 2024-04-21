package selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

import static org.testng.Assert.assertTrue;

public class RegistrationForm extends BasePage {

    //public RegistrationForm(WebDriver driver) {super(driver);}

    @FindBy(id = "fname")
    private WebElement firstNameField;

    @FindBy(id = "lname")
    private WebElement familyNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "subscriber-register-quiz")
    private WebElement quizNumberField;

    @FindBy(id = "subscriber-register-consent")
    private WebElement checkboxGDPR;

    @FindBy(xpath = "//input[@name='Submitted']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='open popup-notice-wrapper error']")
    private WebElement wrongSumMessage;

    @FindBy(id = "consent-error")
    private WebElement errorMessageGDPR;

    @FindBy(xpath = "//div[contains(@class, 'popup-notice-wrapper')]")
    private WebElement successfulRegistrationMessage;

    @Step("Enter first name")
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    @Step("Enter family name")
    public void enterFamilyName(String familyName) {
        familyNameField.sendKeys(familyName);
    }

    @Step("Enter e-mail")
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    @Step("Enter quiz number")
    public void enterQuizNumber(String quizNumber) {
                quizNumberField.sendKeys(quizNumber);
    }
    @Step("Check GDPR")
    public void markCheckboxGDPR() {
                checkboxGDPR.click();
    }
    @Step("Click submit button")
    public void clickSubmitButton() {
        driver.manage().window().fullscreen();
        waitForElementTobeClickable(submitButton);
        submitButton.click();
    }

    public String firstNameBorderColor() {
        String borderColor = firstNameField.getCssValue("border");
        return borderColor;
    }
    @Step("Wrong sum message appears")
    public Boolean visibilityOfWrongSumMessage() {
        return wrongSumMessage.isDisplayed();
    }
    @Step("Unselect GDPR message appears")
    public Boolean visibilityOfErrorMessageGDPR() {
        return errorMessageGDPR.isDisplayed();
    }
    @Step("Color of GDPR error message")
    public String colorOfErrorMessageGDPR() {
        String messageColor = errorMessageGDPR.getCssValue("border");
        return messageColor;
    }
    @Step("Successful registration message appears")
    public Boolean successfulRegistration() {
        return successfulRegistrationMessage.isDisplayed();
    }


}
