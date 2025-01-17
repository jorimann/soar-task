package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ui.models.Address;

public class AddressPage extends BasePage {
    public AddressPage(Page page) {
        this.page = page;
    }

    public void addNewAddress(Address address) {
        page.getByText("Add New Address").click();
        page.getByLabel("Country").fill(address.country());
        page.getByLabel("Name").fill(address.name());
        page.getByLabel("Mobile Number").pressSequentially(address.mobileNumber());
        page.getByLabel("Zip Code").fill(address.zipCode());
        page.getByLabel("Address").fill(address.address());
        page.getByLabel("City").fill(address.city());
        page.getByLabel("State").fill(address.state());
        submit();
    }

    public void submit(){
        page.getByText("Submit").click();
    }

    public void selectAddress(String name) {
        page.locator("mat-row")
                .getByText(name).click();
    }

    public void continueToDelivery() {
        page.getByText("Continue").click();
    }

    public void selectDeliveryOption(String option) {
        Locator element = page.locator("mat-row >> text=" + option);
        element.click();
    }
    public PaymentPage continueToPayment() {
        page.getByText("Continue").click();
        return new PaymentPage(page);
    }
}
