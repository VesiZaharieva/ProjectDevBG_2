package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import selenium.base.BasePage;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (className = "subscriber-register-wrapper open")
    private WebElement registrationWindow;





    //public void UserRegistrateClick() {
         //userRegisterButton.click();
    //}
    public void checkRegistrationForm(){
        Assert.assertTrue(registrationWindow.isDisplayed());
    }


}

