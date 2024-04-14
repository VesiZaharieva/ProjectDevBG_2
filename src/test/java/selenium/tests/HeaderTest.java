package selenium.tests;

import com.opencsv.exceptions.CsvException;
import dev.selenium.driver.DriverFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.MainTest;
import selenium.pages.*;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class HeaderTest extends MainTest {
    HomePage homePage;
    Cookies cookies;
    RegistrationForm registrationForm;
    SoftAssert softAssert = new SoftAssert();
    HomePageHeader homePageHeader;
    EventsPage eventsPage;

    @DataProvider(name = "starting-urls")
    public static Object[][] dataProviderCsvUrls() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/header-urls.csv");
    }

    @BeforeMethod
    public void AcceptCookies() {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
    }

    @Test(dataProvider = "starting-urls")
    public void GoToAdvertisements(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickAdvertisements(), "https://dev.bg/");
    }

    @Test(dataProvider = "starting-urls")
    public void GoToAdvertisementsVarna(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.selectAdvCity(), "https://dev.bg/varna/");
    }

    @Test(dataProvider = "starting-urls")
    public void GoToCompanies(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickCompanies(), "https://dev.bg/company/");
    }

    @Test(dataProvider = "starting-urls")
    public void GoToEvents(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        homePageHeader.clickEvents();
        String eventsTitle = eventsPage.GetEventsTitle();
        assertEquals(eventsTitle, "Събитията на DEV.BG");
    }
    @Test(dataProvider = "starting-urls")
    public void GoToEventsOfDevbg(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        homePageHeader.clickEventsOfDevbg();
        String title = eventsPage.GetEventsTitle();
        assertEquals(title, "Събитията на DEV.BG");
    }
    @Test(dataProvider = "starting-urls")
    public void GoToEventsUserGroups(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickEventsUserGroups(), "https://dev.bg/groups/");
    }

    @Test(dataProvider = "starting-urls")
    public void GoToDigest(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickDigest(), "https://dev.bg/digest/");
    }

    @Test(dataProvider = "starting-urls")
    public void GoToPodcast(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals("https://dev.bg/podcast/", homePageHeader.clickPodcast());
    }

    @Test(dataProvider = "starting-urls")
    public void GoToAboutUs(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickAboutDevbg(), "https://dev.bg/about-us/");
    }
}
