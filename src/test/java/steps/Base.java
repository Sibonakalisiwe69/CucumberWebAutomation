package steps;

import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome",
            "https://ndosisimplifiedautomation.vercel.app/");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);
    GroupPage groupPage = PageFactory.initElements(driver, GroupPage.class);
    SignupPage signupPage = PageFactory.initElements(driver, SignupPage.class);



}
