package selenium.tests;

import com.opencsv.exceptions.CsvException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.*;
//import selenium.pages.AdvertisementMyPosPage;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AdvMyPosTest extends MainTest {
    Cookies cookies;
    HomePage homePage;
    QAautomationPage qaAutomationPage;
    AdvMyPosPage advMyPosPage;
    ApplicationForm applicationForm;

    @DataProvider(name = "notvalid-application-data")
    public static Object[][] dataProviderCsvNotValidApplData() throws IOException, CsvException {
        return CsvReader.readFile("src/test/resources/notvalid-appl-data.csv");
    }

    @BeforeMethod
    public void openAdvMyPosPage() {
        cookies = new Cookies();
        homePage = new HomePage();
        qaAutomationPage = new QAautomationPage();
        cookies.ClickCookie();
        homePage.qaAutomationLinkClick();
        qaAutomationPage.scrollAndClickAdvMyPos();
    }
    @Test
    public void applyAdvMyPos(){
        advMyPosPage = new AdvMyPosPage();
        assertTrue(advMyPosPage.clickApplyButton() == Boolean.TRUE);
    }
    @Test(dataProvider = "notvalid-application-data")
    public void applyNotValidData(String names, String email, String text, String number){
        advMyPosPage = new AdvMyPosPage();
        applicationForm = new ApplicationForm();
        advMyPosPage.clickApplyButton();
        applicationForm.enterNames(names);
        applicationForm.enterEmail(email);
        applicationForm.enterApplMessage(text);
        applicationForm.enterSum(number);
        applicationForm.acceptGDPR();
        applicationForm.acceptGDPRmypos();
        applicationForm.clickSubmitButton();
        assertTrue(applicationForm.clickSubmitButton() == Boolean.TRUE);
        assertEquals("В едно или повече полета има грешка",applicationForm.errorMessageText());
    }
}
