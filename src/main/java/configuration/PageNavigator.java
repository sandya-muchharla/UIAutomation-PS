package configuration;

import pageObjects.AbstractBasePage;
import pageObjects.lloydsBank.LlloydsHomePage;
import pageObjects.sapientWebsite.HomePage;
import pageObjects.PageProvider;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageNavigator {

    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(PageNavigator.class);


    public PageNavigator(){
        this.driver = new WebDriverConfiguration().intializeDriver();
    }

    public LlloydsHomePage launchApplication(){
        driver.get(System.getProperty("base.url"));
        LOGGER.info("Launching application with url: " + System.getProperty("base.url"));
        return new LlloydsHomePage(driver);
    }

    public void closeBrowser(){
        driver.close();
        LOGGER.info("Closing the web driver connection and terminating the test.");
    }

    public <T extends AbstractBasePage> T goDirectlyToURL(String url, PageProvider<T> pageProvider){
        driver.get(System.getProperty("base.url") + "/" + url);
        return pageProvider.getPage(driver);
    }

}
