package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

import java.time.Duration;


public class GroupSteps extends Base {


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        homePage.clickLoginButton();
        loginPage.verifyLoginPageIsDisplayed();
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement welcomeHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='Welcome']")
                )
        );

        Assert.assertTrue(
                welcomeHeader.getText().contains("Welcome")
        );
    }


    @When("I navigate to admin panel")
    public void iNavigateToAdminPanel() {
        adminPage.openProfileDropdown();
        adminPage.goToAdminPanel();
    }

    @And("I click on group section")
    public void iClickOnGroupSection() {
        groupPage.openGroup();
    }

    @And("I click on the create new group button")
    public void iClickOnCreateNewGroupButton() {
        groupPage.clickCreateNewGroup();
    }

    @And("I create group with {string}, {string}, {string}, {string}, {string}, {string}")
    public void createGroup(String groupName,
                            String groupDescription,
                            String year,
                            String maxCapacity,
                            String startDate,
                            String endDate) {

        groupPage.createGroup(groupName, groupDescription, year, maxCapacity, startDate, endDate
        );

    }

    @Then("i should see the group created successfully")
    public void i_should_see_the_group_created_successfully() {
        Assert.assertTrue(groupPage.isGroupCreatedSuccessfully());
    }

    @And("I click back to website button")
    public void andIClickBackToWebsiteButton() {
        groupPage.clickbackButton();
        adminPage.openProfileDropdown();
    }

    @And("I click log out")
    public void iClickLogOut() {
        groupPage.clickLogoutButton();
    }

    @When("I confirm logout")
    public void i_confirm_logout() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @And("I navigate to signup page")
    public void i_navigate_to_signup_page() {
        groupPage.clicklogButton();
        groupPage.clickSignupButton();
    }


    @Then("the created {string} should be displayed in the group dropdown")
    public void verifyCreatedGroupDisplayedInDropdown(String groupName) {
        groupPage.verifyGroupVisibleInDropdown(groupName);
    }
}