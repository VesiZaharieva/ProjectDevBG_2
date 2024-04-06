package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import selenium.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
@FindBy (xpath = "//div[@id='cmplz-cookiebanner-container']//button[contains(text(),'Създай профил')")
private WebElement acceptCookieButton;

    @FindBy(xpath = "//header[@class='site-header]//a[@class='button bold subscriber-register-btn']")
    private WebElement userRegisterButton;

    @FindBy (className = "subscriber-register-wrapper open")
    private WebElement registrationWindow;

    public void ClickCookie(){
        waitForElementToBeVisible(acceptCookieButton);
        switchToCookieWindow();
        acceptCookieButton.click();
    }

    public void UserRegistrateClick() {
         userRegisterButton.click();
    }
    public void checkRegistrationForm(){
        Assert.assertTrue(registrationWindow.isDisplayed());
    }


}

