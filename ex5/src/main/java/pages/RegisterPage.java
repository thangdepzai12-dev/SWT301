package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By genderMale = By.cssSelector("label[for='gender-radio-1']");
    By mobile = By.id("userNumber");
    By submitBtn = By.id("submit");

    public void navigate() {
        driver.get("https://demoqa.com/automation-practice-form");
        removeAdsIframe(); // Xoá iframe quảng cáo
    }

    public void fillForm(String fname, String lname, String emailStr, String phone) {
        type(firstName, fname);
        type(lastName, lname);
        type(email, emailStr);
        scrollIntoView(genderMale);
        click(genderMale);
        type(mobile, phone);
    }

    public void submit() {
        scrollIntoView(submitBtn);
        click(submitBtn);
    }
}
