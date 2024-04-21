package selenium.tests;

import com.opencsv.exceptions.CsvException;
import dev.selenium.driver.DriverFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
    public void acceptCookies() {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.clickCookie();
    }
    @Epic("Click every Header menu and open correspondent page")
    @Feature("Open Job advertisements page")
    @Story("Open Job advertisements page")
    @Test(dataProvider = "starting-urls")
    public void goToAdvertisements(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickAdvertisements(), "https://dev.bg/");
    }
    @Epic("Click every Header menu and open correspondent page")
    @Feature("Open Job advertisements page")
    @Story("Open Job advertisements for Varna")
    @Test(dataProvider = "starting-urls")
    public void goToAdvertisementsVarna(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.selectAdvCity(), "https://dev.bg/varna/");
    }
    @Epic("Click every Header menu and open correspondent page")
    @Feature("Open Companies page")
    @Story("Open Companies page")
    @Test(dataProvider = "starting-urls")
    public void goToCompanies(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickCompanies(), "https://dev.bg/company/");
    }
    @Epic("Click every Header menu and open correspondent page")
    @Feature("Open Events page")
    @Story("............")
    @Test(dataProvider = "starting-urls")
    public void goToEvents(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        homePageHeader.clickEvents();
        String eventsTitle = eventsPage.getEventsTitle();
        assertEquals(eventsTitle, "Събитията на DEV.BG");
    }
    @Test(dataProvider = "starting-urls")
    public void goToEventsOfDevbg(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        homePageHeader.clickEventsOfDevbg();
        String title = eventsPage.getEventsTitle();
        assertEquals(title, "Събитията на DEV.BG");
    }
    @Test(dataProvider = "starting-urls")
    public void goToEventsUserGroups(String url) {
        homePageHeader = new HomePageHeader();
        eventsPage = new EventsPage();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickEventsUserGroups(), "https://dev.bg/groups/");
    }

    @Test(dataProvider = "starting-urls")
    public void goToDigest(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickDigest(), "https://dev.bg/digest/");
    }

    @Test(dataProvider = "starting-urls")
    public void goToPodcast(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals("https://dev.bg/podcast/", homePageHeader.clickPodcast());
    }

    @Test(dataProvider = "starting-urls")
    public void goToAboutUs(String url) {
        homePageHeader = new HomePageHeader();
        DriverFactory.getDriver().get(url);
        assertEquals(homePageHeader.clickAboutDevbg(), "https://dev.bg/about-us/");
    }
}
