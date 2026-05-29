package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    By groupDropdown = By.id("groupDropdown");

    public boolean isGroupPresent(String groupName) {

        driver.get("https://your-app-url.com/signup");

        driver.findElement(groupDropdown).click();

        List<WebElement> options =
                driver.findElements(By.tagName("option"));

        for (WebElement option : options) {
            if (option.getText().equals(groupName)) {
                return true;
            }
        }
        return false;
    }
}