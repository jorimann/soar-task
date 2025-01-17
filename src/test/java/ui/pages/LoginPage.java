package ui.pages;

import com.microsoft.playwright.Page;
import ui.models.User;

public class LoginPage extends BasePage {
    public LoginPage(Page page){
        this.page = page;
    }

    public void clickEmailField(){
        page.getByLabel("Text field for the login email").click();
    }

    public void clickPasswordField(){
        page.getByLabel("Text field for the login password").click();
    }

    public Boolean isEmailAbsenseErrorPresent(){
        return page.waitForSelector("//*[text()='Please provide an email address.']").isVisible();
    }

    public Boolean isConfirmationMessagePresent(){
        return page.waitForSelector("//snack-bar-container//span[contains(text(), 'Registration completed successfully')]").isVisible();
    }

    public Boolean isPasswordAbsenseErrorPresent(){
        return page.waitForSelector("//*[text()='Please provide a password.']").isVisible();
    }

    public UserRegistrationPage goToUserRegistration(){
            page.getByText("Not yet a customer?").click();
            return new UserRegistrationPage(page);
    }

    public ProductsPage login(User user) {
        page.getByLabel("Text field for the login email").fill(user.email());
        page.getByLabel("Text field for the login password").fill(user.password());
        page.locator("#loginButton").click();
        return new ProductsPage(page);
    }
}
