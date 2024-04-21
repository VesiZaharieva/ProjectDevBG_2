package selenium.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CookiesTest extends MainTest {
    Cookies cookies;
    HomePage homePage;

    @Epic("Accept Cookies")
    @Story("Click Accept cookie button")
    @Test
    public void acceptCookies() {
        cookies = new Cookies();
        cookies.clickCookie();
        assertFalse(cookies.cookieBannerVisible());
        }



}
