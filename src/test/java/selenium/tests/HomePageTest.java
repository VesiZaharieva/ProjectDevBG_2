package selenium.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.Cookies;
import selenium.pages.HomePage;
import selenium.pages.RegistrationForm;

import java.util.Iterator;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class HomePageTest extends MainTest {
    HomePage homePage;
    Cookies cookies;
    RegistrationForm registrationForm;

@Test
public void StartRegistration(){
    cookies = new Cookies(driver);
    cookies.ClickCookie();
    //homePage.UserRegistrateClick();
}



    @Test
    public void BeginRegistration() {
    WebDriver driver = new ChromeDriver();
            driver.get("https://www.dev.bg");
                driver.manage().window().maximize();
                Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles" + allWindowHandles);
        String homePageHandle  = driver.getWindowHandle();
             System.out.println("homePageHandle" + homePageHandle);
        Iterator<String> iterator = allWindowHandles.iterator();
        String homePageWindow = iterator.next();
        String cookieWindow = iterator.next();
        System.out.println("homePageWindow" + homePageWindow);
        System.out.println("cookieWindow" + cookieWindow);
        driver.switchTo().window(cookieWindow);
        //WebElement acceptCookieButton = driver.findElement(By.className("cmplz-btn cmplz-accept"));

        //wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //
        //var handle = driver.getWindowHandle();
        //driver.switchTo().window(handle);
        //acceptCookieButton.click();
        //
        //homePage.UserRegistrateClick();
        //homePage.checkRegistrationForm();By.className("cmplz-btn cmplz-accept")
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
