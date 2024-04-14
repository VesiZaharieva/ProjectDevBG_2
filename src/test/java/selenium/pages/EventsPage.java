package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import selenium.base.BasePage;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.QAautomationPage;

public class EventsPage extends BasePage {

    @FindBy(css = ".page-title")
    private WebElement eventsTitle;

    public String GetEventsTitle(){
        return eventsTitle.getText();
    }
}
