package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userNameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String signIn(String userName, String password) {
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return driver.getCurrentUrl();
    }
}
