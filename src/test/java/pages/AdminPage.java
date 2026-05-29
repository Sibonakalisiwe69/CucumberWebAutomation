package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class AdminPage {

    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    By navDrop =By.xpath("(//span[text()='▼'])[4]");
    By adminPanel = By.xpath("//span[normalize-space()='Admin Panel'][1]");

    public void openProfileDropdown() {
        driver.findElement(navDrop).click();
    }
    public void goToAdminPanel() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(visibilityOfElementLocated(adminPanel));
        loginButton.click();
    }
}