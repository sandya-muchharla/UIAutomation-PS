package pageObjects;

import cucumberDatatableMapping.OfficeLocationParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ContactPage extends AbstractBasePage {

    private final By OFFICE_LOCATIONS_LIST = By.cssSelector(".officeListItem");
    private final By TABS_SECTION = By.id("tabs");
    private final By TAB_NAME_AMERICAS = By.cssSelector("[data-tab='1']");
    private final By TAB_NAME_APAC = By.cssSelector("[data-tab='2']");
    private final By TAB_NAME_EMEA = By.cssSelector("[data-tab='3']");
    private final By TAB_CONTENTS_AMERICAS = By.cssSelector("[data-content='1']");
    private final By TAB_CONTENTS_APAC = By.cssSelector("[data-content='2']");
    private final By TAB_CONTENTS_EMEA = By.cssSelector("[data-content='3']");

    public enum Regions{
        AMERICAS,
        APAC,
        EMEA
    }

    public ContactPage(WebDriver driver) {
        super(driver, "Contact Us | Publicis Sapient");
    }

    public List<OfficeLocationParameters> getOfficeLocationsForRegion(Regions region){
        List<OfficeLocationParameters> officeLocationList = null;
        scrollToElement(TABS_SECTION);
        switch(region){
            case AMERICAS:
                waitUntilClickable(TAB_NAME_AMERICAS).click();
                scrollToElement(TAB_CONTENTS_AMERICAS);
                officeLocationList = getOfficeLocations(driver.findElement(TAB_CONTENTS_AMERICAS));
                break;
            case APAC:
                waitUntilClickable(TAB_NAME_APAC).click();
                scrollToElement(TAB_CONTENTS_APAC);
                officeLocationList = getOfficeLocations(driver.findElement(TAB_CONTENTS_APAC));
                break;
            case EMEA:
                waitUntilClickable(TAB_NAME_EMEA).click();
                scrollToElement(TAB_NAME_EMEA);
                officeLocationList = getOfficeLocations(driver.findElement(TAB_CONTENTS_EMEA));
                break;
        }
        return officeLocationList;
    }
    private List<OfficeLocationParameters> getOfficeLocations(WebElement tabName) {
        return tabName.findElements(OFFICE_LOCATIONS_LIST).stream()
                .map(webElement -> new OfficeLocation(driver, webElement))
                .map(this::mapToOfficeLocationParametrsClass)
                .collect(Collectors.toList());
    }

    private OfficeLocationParameters mapToOfficeLocationParametrsClass(OfficeLocation officeLocation){
        return new OfficeLocationParameters(officeLocation.getCity(), officeLocation.getAddress(), officeLocation.getPhoneNumber());
    }


    public class OfficeLocation extends AbstractBasePage{

        private final WebElement OFFICE_LOCATION;
        private final By CITY = By.cssSelector(".headerTitle");
        private final By ADDRESS = By.cssSelector(".address");
        private final By PHONE_NUMBER = By.cssSelector(".phoneNumber");

        OfficeLocation(WebDriver driver, WebElement officeLocation) {
            super(driver, "Contact Us | Publicis Sapient");
            this.OFFICE_LOCATION = officeLocation;
        }

        String getCity(){
            return OFFICE_LOCATION.findElement(CITY).getText().trim();
        }

        String getAddress(){
            return OFFICE_LOCATION.findElement(ADDRESS).getText().replace('\n', ' ').trim();
        }

        String getPhoneNumber(){
            return OFFICE_LOCATION.findElement(PHONE_NUMBER).getText().trim();
        }
    }

}
