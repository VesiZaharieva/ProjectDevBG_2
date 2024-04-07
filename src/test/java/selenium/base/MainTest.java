package selenium.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import dev.selenium.driver.DriverFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class MainTest {
    public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;

        private void setUpBrowserDriver() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            //case "edge":
                //driver = DriverFactory.getEdgeDriver(implicitWait);
                //break;
            default:
                throw new IllegalStateException("Unsupported browser type");

        }
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void acceptCookies (){
        WebDriver.Window coockieWindow = driver.manage().window();

    }
    @BeforeMethod
    public void beforeSetup() {
        setUpBrowserDriver();
        loadUrl();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";
            try {
                FileUtils.copyFile(source, new File("./Screenshots/" + fileName));
                System.out.println("Screenshot taken: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //driver.quit();
    }
}

