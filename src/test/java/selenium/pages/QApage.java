package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

import static org.testng.AssertJUnit.assertTrue;

public class QApage extends BasePage {
    //public QApage(WebDriver driver) {
        //super(driver);
    //}
    @FindBy(css = "[class='miniboard-image']")
    private WebElement qaLogo;

    public Boolean qaLogoDisplayed(){
        return qaLogo.isDisplayed();
    }
}