package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import selenium.base.BasePage;

public class HomePage extends BasePage{
    //public HomePage(WebDriver driver) {super(driver);}

    @FindBy (xpath = "//a[@class='button bold subscriber-register-btn']")
    private WebElement userRegisterButton;

    @FindBy (className = "subscriber-register-wrapper")
    public WebElement registerScreen;

    @FindBy(xpath = "//a[@class='category-name'][contains(text(), 'Quality Assurance')]")
    private WebElement qaLink;

    @FindBy(xpath = "//div[@class='child-term']//div[contains(@class,'icon-automation-qa')]")
    private WebElement qaAutomationLink;



    public Boolean UserRegistrateClick() {
         userRegisterButton.click();
         return registerScreen.isDisplayed();
         }

    public String qaLinkClick(){
        qaLink.click();
        return driver.getCurrentUrl();
    }
    public String qaAutomationLinkClick(){
        qaAutomationLink.click();
        return driver.getCurrentUrl();
    }


}

