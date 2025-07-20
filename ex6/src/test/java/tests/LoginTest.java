package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data/login.csv", numLinesToSkip = 1)
    void testLogin(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(username, password);

        boolean hasError = loginPage.isErrorVisible();
        if (expectedResult.equals("success")) {
            Assertions.assertFalse(hasError, "Expected login success but error appeared");
        } else {
            Assertions.assertTrue(hasError, "Expected login failure but no error appeared");
        }
    }
}
