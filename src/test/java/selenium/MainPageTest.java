package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class MainPageTest extends MainDriver {
    MainPageHeader mainPageHeader;
    RegistrationForm registrationForm;

    @Test
    public void beginRegistration() {
        mainPageHeader = new MainPageHeader(driver);
        mainPageHeader.UserRegistrateClick();
    }
@Test
    public void RegisterEmptyFirstName(){
        registrationForm = new RegistrationForm(driver);
        registrationForm.EnterFirstName("");
        registrationForm.EnterFamilyName("Георгиева");
        registrationForm.EnterEmail("vtzg@abv.bg");
        registrationForm.EnterPassword("password");
        registrationForm.EnterQuizNumber("200");
        registrationForm.MarkCheckboxGDPR();
        registrationForm.ClickSubmitButton();




}
}
