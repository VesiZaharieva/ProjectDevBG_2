package selenium;


import org.testng.annotations.Test;


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
