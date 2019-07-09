package stepDefinitions;

import configuration.PageNavigator;
import cucumberDatatableMapping.OfficeLocationParameters;
import pageObjects.*;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;

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
    public void iSeeTheFollowingOfficeLocationsForTheRegionAMERICAS(String region, DataTable expectedOfficeLocationsDatatable) {
        List<OfficeLocationParameters> expectedOfficeLocationsList = expectedOfficeLocationsDatatable.asList(OfficeLocationParameters.class);
        List<OfficeLocationParameters> actualOfficeLocationsList = contactPage.getOfficeLocationsForRegion(ContactPage.Regions.valueOf(region));
        Assertions.assertThat(actualOfficeLocationsList).containsExactlyInAnyOrderElementsOf(expectedOfficeLocationsList);
    }
}
