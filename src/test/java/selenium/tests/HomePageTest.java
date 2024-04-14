package selenium.tests;

import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.Files;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.RegistrationForm;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.*;
import static org.testng.reporters.Files.readFile;


public class HomePageTest extends MainTest {
    HomePage homePage;
    Cookies cookies;
    RegistrationForm registrationForm;
    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "notvalid-data")
    public static Object[][] dataProviderCsvNotValidData() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/register-notvalid-data.csv");
    }

    @DataProvider(name = "enter-data")
    public static Object[][] dataProviderCsvEnterData() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/register-data.csv");
    }

    @Test
    public void acceptCookies() {
        cookies = new Cookies();
        cookies.ClickCookie();
        assertTrue(cookies.StaleCookie());

    }

    @Test
    public void StartRegistration() {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        Boolean registerScreenOpened = homePage.UserRegistrateClick();
        assertTrue(registerScreenOpened = Boolean.TRUE);
    }

    @Test(dataProvider = "enter-data")
    public void RegisterValidData(String name, String familyName, String email, String password, String number) {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        homePage.UserRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.EnterFirstName(name);
        registrationForm.EnterFamilyName(familyName);
        registrationForm.EnterEmail(email);
        registrationForm.EnterPassword(password);
        registrationForm.EnterQuizNumber(number);
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        assertTrue(registrationForm.SuccessfulRegistration());
    }

    @Test(dataProvider = "notvalid-data")
    public void RegisterEmptyField(String name, String familyName, String email, String password, String number) {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        homePage.UserRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.EnterFirstName(name);
        registrationForm.EnterFamilyName(familyName);
        registrationForm.EnterEmail(email);
        registrationForm.EnterPassword(password);
        registrationForm.EnterQuizNumber(number);
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        Boolean notValidRegistrationExpected = (!registrationForm.SuccessfulRegistration()) && ((homePage.registerScreen).isDisplayed());
        assertTrue(notValidRegistrationExpected);
        //String colors = registrationForm.FirstNameBorderColor();
        //System.out.println(colors);
        //assertEquals("1px solid rgb(255, 0, 0)", colors);
    }

    @Test(dataProvider = "enter-data")
    public void RegisterWrongSum(String name, String familyName, String email, String password, String number) {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        homePage.UserRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.EnterFirstName(name);
        registrationForm.EnterFamilyName(familyName);
        registrationForm.EnterEmail(email);
        registrationForm.EnterPassword(password);
        registrationForm.EnterQuizNumber(number);
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        Boolean errorMessageDisplayed = registrationForm.VisibilityOfWrongSumMessage();
        assertTrue(errorMessageDisplayed == Boolean.TRUE);
    }

    @Test(dataProvider = "enter-data")
    public void RegisterWithoutGDPR(String name, String familyName, String email, String password, String number) {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        homePage.UserRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.EnterFirstName(name);
        registrationForm.EnterFamilyName(familyName);
        registrationForm.EnterEmail(email);
        registrationForm.EnterPassword(password);
        registrationForm.EnterQuizNumber(number);
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
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        String qaUrl = homePage.qaLinkClick();
        assertEquals(qaUrl, "https://dev.bg/company/jobs/quality-assurance/");
    }

    @Test
    public void QAautomationModule() {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
        String qaAutomationUrl = homePage.qaAutomationLinkClick();
        assertEquals(qaAutomationUrl, "https://dev.bg/company/jobs/automation-qa/");
    }
}
