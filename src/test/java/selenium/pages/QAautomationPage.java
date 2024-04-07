package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import selenium.base.BasePage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static java.util.List.*;

public class QAautomationPage extends BasePage {
    public QAautomationPage(WebDriver driver) {
        super(driver);
    }

    Cookies cookies;
    QAautomationPage qaAutomationPage;
    HomePage homePage;
    List<WebElement> checkboxes;


    @FindBy(xpath = "//span[@class='facetwp-display-value'][contains(text(),'Fully Remote')]")
    private WebElement filterRemote;

    @FindBy(xpath = "//span[@class='facetwp-display-value'][contains(text(),'Варна')]")
    private WebElement filterVarna;

    @FindBy(xpath = "//div[contains(@class,'facetwp-checkbox')][@data-value='remote']")
    private WebElement checkboxFilterRemote;

    @FindBy(xpath = "//div[contains(@class,'facetwp-checkbox')][@data-value='varna']")
    private WebElement checkboxFilterVarna;

    @FindBy(xpath = "//span[@class='facetwp-selection-value'][@data-value='remote']")
    private WebElement labelRemoteSelection;

    @FindBy(xpath = "//span[@class='facetwp-selection-value'][@data-value='varna']")
    private WebElement labelVarnaSelection;

    @FindBy(xpath = "//div[contains(@class,'facetwp-checkbox')]")
    List<WebElement> Checkboxes;

    public Boolean VisibilityOfFilterRemote() {
        driver.manage().window().fullscreen();
        return filterRemote.isDisplayed();
    }

    public Boolean VisibilityOfFilterVarna() {
        driver.manage().window().fullscreen();
        return filterVarna.isDisplayed();
    }

    public Boolean clickFilterRemote() {
        checkboxFilterRemote.click();
        waitForElementToBeVisible(labelRemoteSelection);
        return labelRemoteSelection.isDisplayed();
    }

    public Boolean clickFilterVarna() {
        checkboxFilterVarna.click();
        waitForElementToBeVisible(labelVarnaSelection);
        return labelVarnaSelection.isDisplayed();
    }

    public Boolean clickFilters() {
        checkboxFilterRemote.click();
        waitForElementToBeVisible(labelRemoteSelection);
        checkboxFilterVarna.click();
        waitForElementToBeVisible(labelVarnaSelection);
       Boolean displayFilterLabels = labelRemoteSelection.isDisplayed() && labelVarnaSelection.isDisplayed();
        return displayFilterLabels;
    }
}
