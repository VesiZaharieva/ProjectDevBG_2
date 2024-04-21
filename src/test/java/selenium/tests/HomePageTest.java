package selenium.tests;

import com.opencsv.exceptions.CsvException;
import dev.selenium.driver.DriverFactory;
import io.qameta.allure.*;
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
    public void acceptCookies() {
        cookies = new Cookies();
        cookies.clickCookie();
    }

    @Epic("User registration")
    @Feature("Open registration screen")
    @Story("Successful opening")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void startRegistration() {
        homePage = new HomePage();
        assertTrue(homePage.userRegistrateClick());
    }
    @Epic("User registration")
    @Feature("Entering data")
    @Story("Entering valid data")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "enter-data")
    public void registerValidData(String name, String familyName, String email, String password, String number) {
        homePage.userRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.enterFirstName(name);
        registrationForm.enterFamilyName(familyName);
        registrationForm.enterEmail(email);
        registrationForm.enterPassword(password);
        registrationForm.enterQuizNumber(number);
        registrationForm.markCheckboxGDPR();
        registrationForm.clickSubmitButton();
        assertTrue(registrationForm.successfulRegistration());
    }
    @Epic("User registration")
    @Feature("Entering data")
    @Story("Leave one field empty")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "notvalid-data")
    public void registerEmptyField(String name, String familyName, String email, String password, String number) {
        homePage.userRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.enterFirstName(name);
        registrationForm.enterFamilyName(familyName);
        registrationForm.enterEmail(email);
        registrationForm.enterPassword(password);
        registrationForm.enterQuizNumber(number);
        registrationForm.markCheckboxGDPR();
        registrationForm.clickSubmitButton();
        Boolean notValidRegistrationExpected = !registrationForm.successfulRegistration() && (homePage.registerScreen).isDisplayed();
        assertTrue(notValidRegistrationExpected);
        //String colors = registrationForm.FirstNameBorderColor();
        //System.out.println(colors);
        //assertEquals("1px solid rgb(255, 0, 0)", colors);
    }
    @Epic("User registration")
    @Feature("Entering data")
    @Story("Entering wrong sum")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "enter-data")
    public void registerWrongSum(String name, String familyName, String email, String password, String number) {
        homePage.userRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.enterFirstName(name);
        registrationForm.enterFamilyName(familyName);
        registrationForm.enterEmail(email);
        registrationForm.enterPassword(password);
        registrationForm.enterQuizNumber(number);
        registrationForm.markCheckboxGDPR();
        registrationForm.clickSubmitButton();
        Boolean errorMessageDisplayed = registrationForm.visibilityOfWrongSumMessage();
        assertTrue(errorMessageDisplayed == Boolean.TRUE);
    }
    @Epic("User registration")
    @Feature("Entering data")
    @Story("Not checking GDPR")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "enter-data")
    public void registerWithoutGDPR(String name, String familyName, String email, String password, String number) {
        homePage.userRegistrateClick();
        registrationForm = new RegistrationForm();
        registrationForm.enterFirstName(name);
        registrationForm.enterFamilyName(familyName);
        registrationForm.enterEmail(email);
        registrationForm.enterPassword(password);
        registrationForm.enterQuizNumber(number);
        registrationForm.clickSubmitButton();

        System.out.println("Test results:");
        Boolean MessageDisplayed = registrationForm.visibilityOfErrorMessageGDPR();
        assertTrue(MessageDisplayed == Boolean.TRUE);

        String color = registrationForm.colorOfErrorMessageGDPR();
        System.out.println(color);
        softAssert.assertEquals("1px none rgb(255, 0, 0)", color);
    }
    @Epic("QA jobs page")
    @Feature("Go to QA page")
    @Story("Successful opening QA page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void qaModule() {
        String qaUrl = homePage.qaLinkClick();
        assertEquals(qaUrl, "https://dev.bg/company/jobs/quality-assurance/");
    }

    @Epic("QA Automation jobs page")
    @Feature("Go to QA Automation page")
    @Story("Successful opening QA Automation page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void qaAutomationModule() {
        String qaAutomationUrl = homePage.qaAutomationLinkClick();
        assertEquals(qaAutomationUrl, "https://dev.bg/company/jobs/automation-qa/");
    }


}
