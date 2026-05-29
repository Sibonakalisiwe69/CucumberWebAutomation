package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class GroupPage {

    WebDriver driver;

    public GroupPage(WebDriver driver) {
        this.driver = driver;
    }

    By groupMenu = By.xpath("(//nav//button)[4]");
    By groupButton = By.xpath("//button[text()='+ Create New Group']");
    By groupName = By.xpath("//input[@name='name']");
    By groupDesc = By.xpath("//textarea[@name='description']");
    By yearInput = By.xpath("//input[@name='year']");
    By maxCapacityInput = By.xpath("//input[@name='maxCapacity']");
    By startDateInput = By.cssSelector("input[name='startDate']");
    By endDateInput = By.xpath("//input[@name='endDate']");
    By createBtn = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath(" //div[contains(text(),'Group created successfully')]");
    By backButton = By.xpath("//button[normalize-space()='← Back to Website']");
    By LogoutButton = By.xpath("//span[normalize-space()='Logout']");
    By LoginButton = By.xpath("//span[normalize-space()='Login']");


    public void openGroup() {
        driver.findElement(groupMenu).click();
    }

    public void clickCreateNewGroup() {
        WebElement createButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(visibilityOfElementLocated(groupButton));
        createButton.click();
    }

    public void createGroup(String name, String desc, String year, String maxCapacity, String startDate, String endDate) {
        driver.findElement(groupName).sendKeys(name);
        driver.findElement(groupDesc).sendKeys(desc);
        driver.findElement(yearInput).clear();
        driver.findElement(yearInput).sendKeys(year);
        driver.findElement(maxCapacityInput).sendKeys(String.valueOf(maxCapacity));
        setReactDate(startDateInput, startDate);
        setReactDate(endDateInput, endDate);

        driver.findElement(createBtn).click();

    }

    public void setReactDate(By locator, String date) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "const nativeInputValueSetter = " +
                        "Object.getOwnPropertyDescriptor(" +
                        "window.HTMLInputElement.prototype, 'value').set;" +

                        "nativeInputValueSetter.call(arguments[0], arguments[1]);" +

                        "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                element,
                date
        );
    }


    public boolean isGroupCreatedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                .isDisplayed();
    }

    public void clickbackButton() {
        driver.findElement(backButton).click();
    }
    public void clickLogoutButton() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(visibilityOfElementLocated(LogoutButton));
        loginButton.click();
        driver.findElement(LoginButton).click();
    }






}


