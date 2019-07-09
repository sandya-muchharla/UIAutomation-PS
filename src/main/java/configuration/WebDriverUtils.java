package configuration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static java.lang.String.format;
import static org.assertj.core.api.Fail.fail;

public class WebDriverUtils {


    public static WebElement waitUntilVisible(WebDriver webDriver, By by, Duration wait) {
        try {
            new FluentWait<>(webDriver)
                    .withTimeout(wait)
                    .pollingEvery(Duration.ofMillis(2))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                    .until(driver -> driver.findElement(by).isDisplayed());
        } catch (org.openqa.selenium.TimeoutException te) {
            fail(format("Element %s still not visible after %s", by, wait));
        }
        return webDriver.findElement(by);
    }

    public static WebElement waitUntilClickable(WebDriver driver, By by, Duration wait) {
        return new WebDriverWait(driver, wait.getSeconds()).until(ExpectedConditions.elementToBeClickable(by));
    }
}
