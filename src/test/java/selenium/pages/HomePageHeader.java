package selenium.pages;

import dev.selenium.driver.DriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import selenium.base.BasePage;

import javax.xml.stream.Location;

import static org.testng.AssertJUnit.assertEquals;


public class HomePageHeader extends BasePage {

    Actions actions;


    @FindBy(xpath = "//li[@id='menu-item-9962']//a[contains(text(), 'Обяви')]")
    private WebElement menuAdvertisements;

    @FindBy(xpath = "//li[@id='menu-item-106635']//a[contains(text(), 'IT обяви Варна')]")
    private WebElement AdvVarna;

    @FindBy(xpath = "//li[@id='menu-item-9961']//a[contains(text(), 'Компании')]")
    private WebElement companies;

    @FindBy(xpath = "//li[@id='menu-item-19339']//a[contains(text(), 'Събития')]")
    private WebElement menuEvents;

    @FindBy(xpath = "//li[@id='menu-item-19340']//a[contains(text(), 'Събитията на DEV.BG')]")
    private WebElement devEvents;

    @FindBy(xpath = "//li[@id='menu-item-19341']//a[contains(text(), 'Потребителски групи')]")
    private WebElement userGroups;

    @FindBy(xpath = "//li[@id='menu-item-11686']//a[contains(text(), 'Digest')]")
    private WebElement digest;

    @FindBy(xpath = "//li[@id='menu-item-186216']//a[contains(text(), 'Подкаст')]")
    private WebElement podcast;

    @FindBy(xpath = "//li[@id='menu-item-19342']//a[contains(text(), 'За DEV.BG')]")
    private WebElement menuAboutDevbg;

    @FindBy(xpath = "//li[@id='menu-item-123359']//a[contains(text(), 'За нас')]")
    private WebElement aboutUs;


    public String clickAdvertisements() {
        menuAdvertisements.click();
        return DriverFactory.getDriver().getCurrentUrl();

    }
    public String selectAdvCity() {
        actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(menuAdvertisements).perform();
        AdvVarna.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickCompanies() {
        companies.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public void clickEvents() {
        menuEvents.click();
    }

    public void clickEventsOfDevbg() {
        actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(menuEvents).perform();
        devEvents.click();
    }
    public String clickEventsUserGroups(){
        actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(menuEvents).perform();
        userGroups.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickDigest() {
        digest.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickPodcast() {
        podcast.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public String clickAboutDevbg() {
        actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(menuAboutDevbg).perform();
        aboutUs.click();
        return DriverFactory.getDriver().getCurrentUrl();
    }
}
