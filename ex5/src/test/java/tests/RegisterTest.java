package tests;

import org.junit.jupiter.api.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    void testRegisterForm() {
        RegisterPage page = new RegisterPage(driver);
        page.navigate();
        page.fillForm("Nguyen", "Thang", "thangtran@fe.edu.vn", "0912345678");
        page.submit();

        // Có thể thêm assert ở đây nếu bạn cần kiểm tra dialog xác nhận
        // Ví dụ: assertTrue(driver.getPageSource().contains("Thanks for submitting the form"));
    }
}
