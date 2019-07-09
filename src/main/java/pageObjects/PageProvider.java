package pageObjects;

import org.openqa.selenium.WebDriver;

public interface PageProvider<T extends AbstractBasePage> {

    T getPage(WebDriver driver);
}
