package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    static WebDriver driver;
    static LoginPage loginPage;

    @BeforeAll
    static void setup() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Đăng nhập thất bại với thông tin không đúng")
    void testLoginInvalid() {
        loginPage.navigate();
        loginPage.login("thangkhaiyt24@gmail.com", "123123123");
        String msg = loginPage.getErrorMessage();
        assertTrue(msg.toLowerCase().contains("thông tin không chính xác") || msg.toLowerCase().contains("invalid"));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
