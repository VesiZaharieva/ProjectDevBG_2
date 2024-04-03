package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationForm extends BasePage{

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

    @FindBy(css = "[name=Submitted]")
    private WebElement submitButton;

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
        submitButton.click();
    }

}
