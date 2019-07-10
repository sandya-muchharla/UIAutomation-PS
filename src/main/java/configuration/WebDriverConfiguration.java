package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class WebDriverConfiguration {

    private static final Logger LOGGER = getLogger(WebDriverConfiguration.class);

    private enum Browser {
        CHROME,
        FIREFOX,
        IE,
        HEADLESS_MODE;
    }

    public WebDriver intializeDriver() {
        return spinDriverInstanceFor(Browser.valueOf(System.getProperty("browser.name").toUpperCase()));
    }

    private WebDriver spinDriverInstanceFor(Browser driverType) {
        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/webDrivers/chromedriver-mac");
                return spinChromeDriver();
            case FIREFOX:
                return spinChromeDriver();
            case IE:
                return spinChromeDriver();
            case HEADLESS_MODE:
                return spinChromeDriver();
            default:
                return spinChromeDriver();
        }
    }

    private WebDriver spinChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver constructChromeHeadlessDriver() {
        LOGGER.info("Creating Headless ChromeDriver instance");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--disable-extensions", "--disable-dev-shm-usage");

        DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability("acceptInsecureCerts", true);

        return new ChromeDriver(cap);
    }
}
