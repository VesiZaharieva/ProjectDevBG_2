package selenium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.QApage;

import static org.testng.AssertJUnit.assertTrue;

public class QApageTest extends MainTest {
    QApage qaPage;
    HomePage homePage;
    Cookies cookies;

    @BeforeMethod
    public void openQAPage() {
        cookies = new Cookies();
        qaPage = new QApage();
        homePage = new HomePage();
        cookies.clickCookie();
        homePage.qaLinkClick();
    }
    @Test
    public void visibilityOfQAlogo(){
        qaPage = new QApage();
        Boolean qaLogoVisible = qaPage.qaLogoDisplayed();
        assertTrue(qaLogoVisible == Boolean.TRUE);
    }



}
