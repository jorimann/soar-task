package ui.pages;

import com.microsoft.playwright.Page;
import ui.models.User;

public class UserRegistrationPage extends BasePage {
    public UserRegistrationPage(Page page) {
        this.page=page;
    }

    public void populateUserData(User user) {
        page.getByLabel("Email address field").fill(user.email());
        page.getByLabel("Field for the password").fill(user.password());
        page.getByLabel("Field to confirm the password").fill(user.repeatPassword());
        page.getByLabel("Show password advice").press("Tab");
        page.getByLabel("Selection list for the").locator("span").click();
        page.getByText(user.securityQuestion()).click();
        page.getByPlaceholder("Answer to your security").fill(user.answer());
    }

    public LoginPage completeRegistration() {
        page.getByLabel("Button to complete the").click();
        return new LoginPage(page);
    }
}
