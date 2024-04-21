package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

public class Cookies extends BasePage{
    //public Cookies(WebDriver driver) {super(driver);}
    @FindBy(css = "#cmplz-cookiebanner-container .cmplz-accept")
    private WebElement acceptCookieButton;

    @FindBy (css = "#cmplz-cookiebanner-container")
    private WebElement cookieBanner;

    public void clickCookie(){
        acceptCookieButton.click();
        waitForElementToBeStale(cookieBanner);
    }
    public Boolean cookieBannerVisible(){
        return cookieBanner.isDisplayed();
        }
}
