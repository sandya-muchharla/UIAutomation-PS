package pageObjects.sapientWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AbstractBasePage;

public class HomePage extends AbstractBasePage {

    private final By HOME_LOGO = By.cssSelector(".logo");
    private final By MENU_BUTTON = By.cssSelector(".toggle");
    private final By MENU_BUTTON_LABEL = By.cssSelector(".nav-menu-label");



    public HomePage(WebDriver driver) {
        super(driver, "Publicis Sapient | Seize the Space Between Next and Now");
    }

    private void openMainMenu() {
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
            case "CONTACT":
                page = (T) getPage(ContactPage::new);
                break;
            case "CAREERS":
                page = (T) getPage(CareersPage::new);
                break;
        }
        return page;
    }


}
