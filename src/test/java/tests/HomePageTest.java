package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import selenium.base.MainTest;
import selenium.pages.HomePage;
import selenium.pages.RegistrationForm;

import java.util.Iterator;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class HomePageTest extends MainTest {
    HomePage homePageHeader;
    RegistrationForm registrationForm;
    WebDriverWait wait;



@Test
public void startRegistration(){
    homePageHeader = new HomePage(driver);
    WebElement element = driver.findElement(By.id("cmplz-cookiebanner-container"));
    homePageHeader.UserRegistrateClick();
}



    @Test
    public void beginRegistration() {
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
        //homePageHeader.UserRegistrateClick();
        //homePageHeader.checkRegistrationForm();By.className("cmplz-btn cmplz-accept")
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
