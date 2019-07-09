package pageObjects;

import configuration.WebDriverUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public abstract class AbstractBasePage {

    WebDriver driver;
    private final long STANDARD_TIMEOUT_IN_SECONDS = 30;
    private String partialPageTitle;
    private final By COOKIES_BANNER = By.cssSelector(".mtn-c-cookie-banner");
    private final By ACCEPT_COOKIES_BUTTON = By.cssSelector(".mtn-c-button");
    private final Logger logger = LoggerFactory.getLogger(getClass());

    AbstractBasePage(WebDriver driver, String partialPageTitle) {
        this.driver = driver;
        this.partialPageTitle = partialPageTitle;
        validatePage();
    }

    private void validatePage() {
        waitForPageToLoad();
        waitForJQueryToNotBeActive();
        waitForTitle();
        verifyOnCorrectPage();
        logger.info("On page titled {}", driver.getTitle());

    }

    private void waitForPageToLoad() {
        new WebDriverWait(driver, STANDARD_TIMEOUT_IN_SECONDS)
                .until(driver -> (JavascriptExecutor) driver)
                .executeScript("return document.readyState == 'complete'");
    }

    private void waitForJQueryToNotBeActive() {
        new WebDriverWait(driver, STANDARD_TIMEOUT_IN_SECONDS)
                .until(driver -> (JavascriptExecutor) driver)
                .executeScript("return (typeof jQuery == 'undefined' || jQuery.active == 0)");
    }

    private String waitForTitle() {
        Assertions.assertThat(partialPageTitle).isNotNull();
        new WebDriverWait(driver, STANDARD_TIMEOUT_IN_SECONDS)
                .until(driver -> driver.getTitle() != null);
        return driver.getTitle();
    }

    private void openMainMenu() {
        final By MENU_BUTTON = By.cssSelector(".toggle");
        final By MENU_BUTTON_LABEL = By.cssSelector(".nav-menu-label");

        if (driver.findElement(MENU_BUTTON_LABEL).getText().equalsIgnoreCase("menu")) {
            driver.findElement(MENU_BUTTON).click();
        }
    }


    public <T extends AbstractBasePage> T selectMenuItem(String menuName) {
        openMainMenu();
        final By menuItem = By.cssSelector("[href='/" + menuName.toLowerCase() + "']");
        waitUntilClickable(menuItem).click();
        T page = null;
        switch (menuName.toUpperCase()) {
            case "INDUDTRIES":
                page = (T) getPage(IndustriesPage::new);
            case "SERVICES":
                page = (T) getPage(ServicesPage::new);
                break;
            case "WORK":
                page = (T) getPage(WorkPage::new);
                break;
            case "ABOUT":
                page = (T) getPage(AboutPage::new);
                break;
            case "NEWS":
                page = (T) getPage(NewsPage::new);
                break;
            case "CONTACT":
                page = (T) getPage(ContactPage::new);
                break;
            case "CAREERS":
                page = (T) getPage(CareersPage::new);
                break;
        }


        return page;
    }

    private void verifyOnCorrectPage() {
        boolean correctPageDisplayed = driver.getTitle().contains(partialPageTitle);
        if (correctPageDisplayed) {
            return;
        }
        List<String> lines = Stream.of(
                "Failed to create " + getClass().getSimpleName(),
                "Expected title regex: " + partialPageTitle,
                "Actual title: " + driver.getTitle(),
                "Actual url: " + driver.getCurrentUrl()
        ).collect(toCollection(ArrayList::new));
        throw new RuntimeException(lines.stream().collect(joining(lineSeparator())));
    }

    void acceptCookies() {
        driver.findElement(COOKIES_BANNER).findElement(ACCEPT_COOKIES_BUTTON).click();
    }

    public WebElement waitUntilVisible(By by) {

        return waitUntilVisible(by, Duration.ofSeconds(STANDARD_TIMEOUT_IN_SECONDS));
    }

    public WebElement waitUntilVisible(By by, Duration waitTime) {

        return WebDriverUtils.waitUntilVisible(driver, by, waitTime);
    }

    public WebElement waitUntilClickable(By by) {

        return waitUntilClickable(by, Duration.ofSeconds(STANDARD_TIMEOUT_IN_SECONDS));
    }

    public WebElement waitUntilClickable(By by, Duration waitTime) {

        return WebDriverUtils.waitUntilClickable(driver, by, waitTime);
    }

    public void scrollToElement(By elementLocator){
        new Actions(driver).moveToElement(driver.findElement(elementLocator)).build().perform();
    }

    public <T extends AbstractBasePage> T goDirectlyToURL(String url, PageProvider<T> pageProvider) {
        driver.get(System.getProperty("base.url") + "/" + url);
        return pageProvider.getPage(driver);
    }

    public <T extends AbstractBasePage> T getPage(PageProvider<T> pageProvider) {
        return pageProvider.getPage(driver);
    }
}
