package selenium.pages;

import dev.selenium.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.BeforeMethod;
import selenium.base.BasePage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static java.util.List.*;

public class QAautomationPage extends BasePage {
    Actions actions;
    List<WebElement> Pagination;

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

    @FindBy(xpath = "//div[contains(@class, 'job-list-item')][@data-job-id='320240']")
    private WebElement advMyPos;

    @FindBy(css = ".pagination-wrap")
    private WebElement paginationContainer;

    @FindBys({
            @FindBy(css = ".job-listing-category-archive-container"),
            @FindBy(css = ".pagination-wrap"),
            @FindBy(css = ".facetwp-pager")
    })
    private List<WebElement> pagination;

    @FindBy(xpath = "//div[contains(@class, 'job-list-item')][@data-job-id='326517']")
    private WebElement advLuxsoft;

    public Boolean visibilityOfFilterRemote() {
        DriverFactory.getDriver().manage().window().fullscreen();
        return filterRemote.isDisplayed();
    }

    public Boolean visibilityOfFilterVarna() {
        DriverFactory.getDriver().manage().window().fullscreen();
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

    public String clickAdvMyPos() {
        advMyPos.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String scrollAndClickAdvMyPos() {
        actions = new Actions(DriverFactory.getDriver());
        actions.scrollToElement(advMyPos).perform();
        advMyPos.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickPageTwo() {
        actions = new Actions(DriverFactory.getDriver());
        actions.scrollToElement(paginationContainer).perform();
        actions.moveToElement(pagination.get(2));
        pagination.get(2).click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickAdvLuxsoft() {
        actions = new Actions(DriverFactory.getDriver());
        actions.scrollToElement(advLuxsoft).perform();
        advLuxsoft.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

}
