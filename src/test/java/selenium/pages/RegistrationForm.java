package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

import static org.testng.Assert.assertTrue;

public class RegistrationForm extends BasePage {

    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

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

    @FindBy (xpath = "//div[@class='open popup-notice-wrapper error']")
    private WebElement wrongSumMessage;

    @FindBy (id = "consent-error")
    private WebElement errorMessageGDPR;

    public void EnterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        }
    public void EnterFamilyName(String familyName){
        familyNameField.sendKeys(familyName);
    }

    public void EnterEmail(String email){
        emailField.sendKeys(email);
    }
    public void EnterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void EnterQuizNumber(String quizNumber){
        quizNumberField.sendKeys(quizNumber);
    }
    public void MarkCheckboxGDPR(){
        checkboxGDPR.click();
    }

    public void ClickSubmitButton(){
        driver.manage().window().fullscreen();
        waitForElementTobeClickable(submitButton);
        submitButton.click();
    }

    public String FirstNameBorderColor(){
        String borderColor = firstNameField.getCssValue("border");
        return borderColor;
    }
    public Boolean VisibilityOfWrongSumMessage(){
        return wrongSumMessage.isDisplayed();
    }
    public Boolean VisibilityOfErrorMessageGDPR(){
        return errorMessageGDPR.isDisplayed();
    }
    public String ColorOfErrorMessageGDPR(){
        String messageColor = errorMessageGDPR.getCssValue("border");
        return messageColor;
    }

}
