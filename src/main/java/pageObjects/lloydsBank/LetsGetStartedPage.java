package pageObjects.lloydsBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AbstractBasePage;

public class LetsGetStartedPage extends AbstractBasePage {

    private final By APPLY_NOW_BUTTON = By.cssSelector(".apply-now-btn");



    public LetsGetStartedPage(WebDriver driver) {
        super(driver, "Let's get started - Lloyds Bank Current Accounts");
    }

    private void applyNow() {
            driver.findElement(APPLY_NOW_BUTTON).click();
    }


}
