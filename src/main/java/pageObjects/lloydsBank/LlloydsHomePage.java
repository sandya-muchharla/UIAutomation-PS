package pageObjects.lloydsBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AbstractBasePage;
import pageObjects.sapientWebsite.CareersPage;
import pageObjects.sapientWebsite.ContactPage;

public class LlloydsHomePage extends AbstractBasePage {

    private final By APPLY_NOW_BUTTON = By.cssSelector(".apply-now-btn");



    public LlloydsHomePage(WebDriver driver) {
        super(driver, "Classic Account | UK Bank Accounts | Lloyds Bank");
    }

    public LetsGetStartedPage applyNow() {
            driver.findElement(APPLY_NOW_BUTTON).click();
            return new LetsGetStartedPage(driver);
    }


}
