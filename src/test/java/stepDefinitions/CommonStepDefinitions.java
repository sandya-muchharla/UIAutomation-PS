package stepDefinitions;

import configuration.PageNavigator;
import cucumberDatatableMapping.OfficeLocationParameters;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pageObjects.sapientWebsite.ContactPage;
import pageObjects.sapientWebsite.HomePage;

import java.util.List;

public class CommonStepDefinitions {

    private PageNavigator navigator;
    private HomePage homePage;
    private ContactPage contactPage;

    @Before
    public void setUp() {
        navigator = new PageNavigator();
    }

    @Given("^I launch the website$")
    public void iLaunchTheWebsite() {
        homePage = navigator.launchApplication();
    }

    @And("^I open the menu item (.*)$")
    public void iOpenTheMenuItemContact(String menuName) {
        contactPage = homePage.selectMenuItem(menuName);
    }

    @And("^I navigate to Contact page from the main menu$")
    public void iNavigateToContactPageFromTheMainMenu() {
        contactPage = homePage.selectMenuItem("Contact");
    }

    @Then("^I see the following office locations for the region (.*)$")
    public void iSeeTheFollowingOfficeLocationsForTheRegion(String region, DataTable expectedOfficeLocationsDatatable) {
        List<OfficeLocationParameters> expectedOfficeLocationsList = expectedOfficeLocationsDatatable.asList(OfficeLocationParameters.class);
        List<OfficeLocationParameters> actualOfficeLocationsList = contactPage.getOfficeLocationsForRegion(ContactPage.Regions.valueOf(region));
        Assertions.assertThat(actualOfficeLocationsList).containsExactlyInAnyOrderElementsOf(expectedOfficeLocationsList);
    }
}
