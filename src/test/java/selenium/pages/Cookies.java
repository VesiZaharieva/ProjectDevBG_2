package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cookies extends HomePage{
    public Cookies(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#cmplz-cookiebanner-container .cmplz-accept")
    private WebElement acceptCookieButton;

    public void ClickCookie(){
        acceptCookieButton.click();
    }
}
