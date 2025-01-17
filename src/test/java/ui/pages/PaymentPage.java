package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ui.models.CreditCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentPage extends BasePage {
    Logger LOGGER = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(Page page) {
        this.page = page;
    }

    public void addPayment(CreditCard card) {
        LOGGER.info(card.toString());
        page.getByText("Add new card").click();
        page.getByLabel("Name").fill(card.name());
        page.getByLabel("Card Number").pressSequentially(card.cardNumber());
        page.getByLabel("Expiry Month").pressSequentially(String.valueOf(card.expiryMonth()));
        page.getByLabel("Expiry Year").pressSequentially(String.valueOf(card.expiryYear()));
        page.getByText("Submit").click();
    }

    public void selectPaymentOption(String lastNumbers) {
        String str = "mat-row:has-text('" + lastNumbers + "')";
        Locator element = page.locator(str).locator(".mat-radio-outer-circle");
        element.click();
    }

    public OrderSummaryPage continuerOrder () {
        page.getByText("Continue").click();
        return new OrderSummaryPage(page);
    }
}
