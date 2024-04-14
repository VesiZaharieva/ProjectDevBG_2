package selenium.tests;

import org.testng.annotations.BeforeMethod;
import selenium.base.BasePage;
import selenium.pages.Cookies;
import selenium.pages.EventsPage;
import selenium.pages.HomePage;
import selenium.pages.QAautomationPage;

public class EventsPageTest extends BasePage {
    Cookies cookies;
    HomePage homePage;
    EventsPage eventsPage;

    @BeforeMethod
    public void openEventsPage() {
        cookies = new Cookies();
        homePage = new HomePage();
        cookies.ClickCookie();
        homePage.qaAutomationLinkClick();
    }

}
