package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.window;

public class MainPageHeader extends BasePage {

    public MainPageHeader(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='button bold subscriber-register-btn']")
    private WebElement userRegisterButton;



    public void UserRegistrateClick() {
        userRegisterButton.click();
    }




}
