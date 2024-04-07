package selenium.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.QAautomationPage;
import selenium.pages.QApage;

import static org.testng.AssertJUnit.assertTrue;

public class QAautomationPageTest extends MainTest {
    QAautomationPage qaAutomationPage;
    HomePage homePage;
    Cookies cookies;

    @BeforeMethod
    public void openQAautomationPage() {
        cookies = new Cookies(driver);
        qaAutomationPage = new QAautomationPage(driver);
        homePage = new HomePage(driver);
        cookies.ClickCookie();
        homePage.qaAutomationLinkClick();
    }

    @Test
    public void VisibilityOfFilterRemote() {
        Boolean filterRemoteVisible = qaAutomationPage.VisibilityOfFilterRemote();
        assertTrue(filterRemoteVisible == Boolean.TRUE);
    }

    @Test
    public void VisibilityOfFilterVarna() {
        Boolean filterVarnaVisible = qaAutomationPage.VisibilityOfFilterVarna();
        assertTrue(filterVarnaVisible == Boolean.TRUE);
    }

    @Test
    public void testFilterRemote() {
        Boolean displayRemoteSelection = qaAutomationPage.clickFilterRemote();
        assertTrue(displayRemoteSelection == Boolean.TRUE);
    }

    @Test
    public void testFilterVarna() {
        Boolean displayVarnaSelection = qaAutomationPage.clickFilterVarna();
        assertTrue(displayVarnaSelection == Boolean.TRUE);
    }

    @Test
    public void testFiltersRemoteAndVarna() {
        Boolean displaySelections = qaAutomationPage.clickFilters();
        assertTrue(displaySelections == Boolean.TRUE);
    }
}
