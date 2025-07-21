package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By errorMsg = By.cssSelector(".alert.alert-danger");

    public void navigate() {
        driver.get("https://apt3233.id.vn/login");
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginBtn);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}
