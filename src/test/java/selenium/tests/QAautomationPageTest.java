package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class QAautomationPageTest extends MainTest {
    QAautomationPage qaAutomationPage;
    HomePage homePage;
    Cookies cookies;

    @BeforeMethod
    public void openQAautomationPage() {
        cookies = new Cookies();
        homePage = new HomePage();
        cookies.ClickCookie();
        homePage.qaAutomationLinkClick();
    }

    @Test
    public void VisibilityOfFilterRemote() {
        qaAutomationPage = new QAautomationPage();
        Boolean filterRemoteVisible = qaAutomationPage.VisibilityOfFilterRemote();
        assertTrue(filterRemoteVisible == Boolean.TRUE);
    }

    @Test
    public void VisibilityOfFilterVarna() {
        qaAutomationPage = new QAautomationPage();
        Boolean filterVarnaVisible = qaAutomationPage.VisibilityOfFilterVarna();
        assertTrue(filterVarnaVisible == Boolean.TRUE);
    }

    @Test
    public void testFilterRemote() {
        qaAutomationPage = new QAautomationPage();
        Boolean displayRemoteSelection = qaAutomationPage.clickFilterRemote();
        assertTrue(displayRemoteSelection == Boolean.TRUE);
    }

    @Test
    public void testFilterVarna() {
        qaAutomationPage = new QAautomationPage();
        Boolean displayVarnaSelection = qaAutomationPage.clickFilterVarna();
        assertTrue(displayVarnaSelection == Boolean.TRUE);
    }

    @Test
    public void testFiltersRemoteAndVarna() {
        qaAutomationPage = new QAautomationPage();
        Boolean displaySelections = qaAutomationPage.clickFilters();
        assertTrue(displaySelections == Boolean.TRUE);
    }

    @Test
    public void openAdvMyPos() {
        qaAutomationPage = new QAautomationPage();
        qaAutomationPage.clickFilterRemote();
        qaAutomationPage.clickFilterVarna();
        assertEquals("https://dev.bg/company/jobads/mypos-automation-qa-specialist-2/", qaAutomationPage.clickAdvMyPos());
    }
    @Test
    public void openAdvMyPosByScroll(){
        qaAutomationPage = new QAautomationPage();
        assertEquals("https://dev.bg/company/jobads/mypos-automation-qa-specialist-2/", qaAutomationPage.scrollAndClickAdvMyPos());
    }
    @Test
    public void openAdvPageTwo() {
        qaAutomationPage = new QAautomationPage();
        assertEquals("https://dev.bg/company/jobs/automation-qa/?_paged=2", qaAutomationPage.clickPageTwo());
    }
    @Test
    public void openAdvPageTwoAndAdvLuxsoft(){
        qaAutomationPage = new QAautomationPage();
        qaAutomationPage.clickPageTwo();
        qaAutomationPage.clickAdvLuxsoft();
    }
}
