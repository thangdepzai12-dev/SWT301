package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfileTest extends BaseTest {

    @Test
    void testProfileUpdateWithValidData() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.navigate();
        profilePage.fillForm("Nguyen", "Thang", "0912345678", "src/test/resources/data/avatar.jpg");
        profilePage.submit();
        Assertions.assertTrue(profilePage.isSuccessMessageVisible());
    }
}
