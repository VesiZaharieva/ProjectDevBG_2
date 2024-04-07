package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.RegistrationForm;

import static org.testng.AssertJUnit.*;


public class HomePageTest extends MainTest {
    HomePage homePage;
    Cookies cookies;
    RegistrationForm registrationForm;
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void acceptCookies() {
        cookies = new Cookies(driver);
        Boolean hideCookie = cookies.staleCookie();
        assertFalse(hideCookie == Boolean.TRUE);
    }

    @Test
    public void StartRegistration() {
        homePage = new HomePage(driver);
        acceptCookies();
        homePage.UserRegistrateClick();
    }

    @Test
    public void RegisterEmptyFirstName() {
        StartRegistration();
        registrationForm = new RegistrationForm(driver);
        registrationForm.EnterFirstName("");
        registrationForm.EnterFamilyName("Георгиева");
        registrationForm.EnterEmail("vtzg@abv.bg");
        registrationForm.EnterPassword("password");
        registrationForm.EnterQuizNumber("200");
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        String colors = registrationForm.FirstNameBorderColor();
        System.out.println(colors);
        assertEquals("1px solid rgb(255, 0, 0)", colors);
    }

    @Test
    public void RegisterWrongSum() {
        StartRegistration();
        registrationForm = new RegistrationForm(driver);
        registrationForm.EnterFirstName("Ваня");
        registrationForm.EnterFamilyName("Георгиева");
        registrationForm.EnterEmail("vtzg@abv.bg");
        registrationForm.EnterPassword("password");
        registrationForm.EnterQuizNumber("200");
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        Boolean errorMessageDisplayed = registrationForm.VisibilityOfWrongSumMessage();
        assertTrue(errorMessageDisplayed == Boolean.TRUE);
    }

    @Test
    public void RegisterWithoutGDPR() {
        StartRegistration();
        registrationForm = new RegistrationForm(driver);
        registrationForm.EnterFirstName("Ваня");
        registrationForm.EnterFamilyName("Георгиева");
        registrationForm.EnterEmail("vtzg@abv.bg");
        registrationForm.EnterPassword("password");
        registrationForm.EnterQuizNumber("200");

        registrationForm.ClickSubmitButton();

        System.out.println("Test results:");
        Boolean MessageDisplayed = registrationForm.VisibilityOfErrorMessageGDPR();
        assertTrue(MessageDisplayed == Boolean.TRUE);

        String color = registrationForm.ColorOfErrorMessageGDPR();
        System.out.println(color);
        softAssert.assertEquals("1px none rgb(255, 0, 0)", color);
    }

    @Test
    public void QAModule() {
        homePage = new HomePage(driver);
        cookies = new Cookies(driver);
        cookies.ClickCookie();
        String qaUrl = homePage.qaLinkClick();
        assertEquals(qaUrl, "https://dev.bg/company/jobs/quality-assurance/");
    }

    @Test
    public void QAautomationModule() {
        homePage = new HomePage(driver);
        cookies = new Cookies(driver);
        cookies.ClickCookie();
        String qaAutomationUrl = homePage.qaAutomationLinkClick();
        assertEquals(qaAutomationUrl, "https://dev.bg/company/jobs/automation-qa/");
    }
}
