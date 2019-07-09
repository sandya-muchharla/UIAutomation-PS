package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractBasePage {

    private final By HOME_LOGO = By.cssSelector(".logo");
    private final By MENU_BUTTON = By.cssSelector(".toggle");
    private final By MENU_BUTTON_LABEL = By.cssSelector(".nav-menu-label");



    public HomePage(WebDriver driver) {
        super(driver, "Publicis Sapient | Seize the Space Between Next and Now");
    }

    public boolean isMenuButtonDisplayed() {
        return true;
    }


}
