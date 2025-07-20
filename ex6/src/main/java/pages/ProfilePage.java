public class ProfilePage extends BasePage {
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By phoneField = By.id("phone");
    private final By fileUploadField = By.id("avatar");
    private final By saveButton = By.id("saveProfile");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void updateProfile(String firstName, String lastName, String phone, String imagePath) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(phoneField, phone);
        driver.findElement(fileUploadField).sendKeys(new File(imagePath).getAbsolutePath());
        click(saveButton);
    }
}
