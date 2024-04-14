package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

public class AdvMyPosPage extends BasePage {
    @FindBy(css = "[alt='Apply']")
    private WebElement applyButton;

    @FindBy(css = ".job-application-form")
    private WebElement applicationForm;

    public Boolean clickApplyButton(){
        applyButton.click();
        waitForElementToBeVisible(applicationForm);
        return applicationForm.isDisplayed();
    }
}
