package selenium.tests;

import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;

import static org.testng.AssertJUnit.assertTrue;

public class CookiesTest extends MainTest {
    Cookies cookies;
    HomePage homePage;

    @Test
    public void acceptCookies() {
        cookies = new Cookies();
        cookies.ClickCookie();
        assertTrue(cookies.StaleCookie());

    }



}
