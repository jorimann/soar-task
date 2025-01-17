package ui.pages;

import com.microsoft.playwright.Page;

public class OrderSummaryPage extends BasePage {
    public OrderSummaryPage(Page page) {
        this.page = page;
    }

    public OrderCompletionPage placeOrderAndPay(){
        page.getByText("Place your Order and pay").click();
        return new OrderCompletionPage(page);
    }
}
