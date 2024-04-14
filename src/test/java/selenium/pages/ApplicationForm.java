package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

public class ApplicationForm extends BasePage {

    @FindBy(xpath = "//input[@name='your-name']")
    private WebElement namesField;

    @FindBy(xpath = "//input[@name='your-email']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@name='your-message']")
    private WebElement applicationMessageField;

    @FindBy(xpath = "//input[@name='short-question']")
    private WebElement sumField;

    @FindBy(xpath = "//input[@name='devbg-privacy[]']")
    private WebElement GDPRcheckbox;

    @FindBy(xpath = "//input[@name='company-privacy[]']")
    private WebElement GDPRmyposCheckbox;

    @FindBy(xpath = "//input[@value='Кандидатствай']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='footer-bottom']//div[@class='wpcf7-response-output']")
    private WebElement errorMessage;


    public void enterNames(String names) {
        namesField.sendKeys(names);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterApplMessage(String applMessage) {
        applicationMessageField.sendKeys(applMessage);
    }

    public void enterSum(String number) {
        sumField.sendKeys(number);
    }

    public void acceptGDPR() {
        GDPRcheckbox.click();
    }

    public void acceptGDPRmypos() {
        GDPRmyposCheckbox.click();
    }

    public Boolean clickSubmitButton() {
        submitButton.click();
        waitForElementToBeVisible(errorMessage);
        return errorMessage.isDisplayed();
    }
    public String errorMessageText(){
        waitForElementToBeVisible(errorMessage);
        return errorMessage.getText();
    }


}
