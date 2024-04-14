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

import static org.testng.AssertJUnit.*;


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

    @BeforeMethod
    public void AcceptCookies() {
        homePage = new HomePage();
        cookies = new Cookies();
        cookies.ClickCookie();
    }

    @Test
    public void StartRegistration() {
        Boolean registerScreenOpened = homePage.UserRegistrateClick();
        assertTrue(registerScreenOpened = Boolean.TRUE);
    }

    @Test(dataProvider = "enter-data")
    public void RegisterValidData(String name, String familyName, String email, String password, String number) {
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
        homePage.UserRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.EnterFirstName(name);
        registrationForm.EnterFamilyName(familyName);
        registrationForm.EnterEmail(email);
        registrationForm.EnterPassword(password);
        registrationForm.EnterQuizNumber(number);
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();
        Boolean notValidRegistrationExpected = !registrationForm.SuccessfulRegistration() && (homePage.registerScreen).isDisplayed();
        assertTrue(notValidRegistrationExpected);
        //String colors = registrationForm.FirstNameBorderColor();
        //System.out.println(colors);
        //assertEquals("1px solid rgb(255, 0, 0)", colors);
    }

    @Test(dataProvider = "enter-data")
    public void RegisterWrongSum(String name, String familyName, String email, String password, String number) {
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
        String qaUrl = homePage.qaLinkClick();
        assertEquals(qaUrl, "https://dev.bg/company/jobs/quality-assurance/");
    }

    @Test
    public void QAautomationModule() {
        String qaAutomationUrl = homePage.qaAutomationLinkClick();
        assertEquals(qaAutomationUrl, "https://dev.bg/company/jobs/automation-qa/");
    }


}
