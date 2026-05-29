package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage {
    WebDriver driver;

    By loginButton_xpath = By.xpath("//span[text()='Login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(visibilityOfElementLocated(loginButton_xpath));
        loginButton.click();
    }


}