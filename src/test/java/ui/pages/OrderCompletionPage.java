package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ui.models.Order;

import static config.ConfigurationManager.config;

public class OrderCompletionPage extends BasePage {
    public OrderCompletionPage(Page page) {
        this.page = page;
    }

    public Order getOrderSummary(){
        long currentTimeMillis = System.currentTimeMillis();
        while (getPrice("Total Price") == 0 && currentTimeMillis + config().waitElement() > System.currentTimeMillis()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        double totalPrice = getPrice("Total Price");
        double delivery = getPrice("Delivery");
        return new Order(totalPrice, delivery);
    }

    private double getPrice(String whichPrice) {
        String str = "table:has-text('" + whichPrice + "')";

        Locator table = page.locator(str);
        Locator rows = table.locator("tr");
        int rowCount = rows.count();
        int rowWithTotalPrice=-1;
        for (int i = 0; i < rowCount; i++) {
            if (rows.nth(i).textContent().contains(whichPrice)) {
                rowWithTotalPrice = i;
                break;
            }
        }
        Locator tableWithPrice = page.locator("table[class=price-align]");
        Locator rowsWithPrice = tableWithPrice.locator("tr");
        String priceRow = rowsWithPrice.nth(rowWithTotalPrice).textContent();
        return Double.parseDouble(priceRow.substring(0,priceRow.length()-1));
    }
}
