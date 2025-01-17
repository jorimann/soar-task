package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    public BasketPage(Page page) {
        this.page = page;
    }

    public List<String> getListOfProducts() {
        Locator productsInBasket = page.locator("mat-row");

        waitForElements(productsInBasket, 2000);
        int count = productsInBasket.count();

        List<String> productsNames = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            productsNames.add(productsInBasket.nth(i).locator("mat-cell").nth(1).textContent().trim());
        }
        return productsNames;
    }

    public void increaseQuantityOf(String product) {
        Locator elements = page.locator("mat-row");
        int count = elements.count();
        for (int i = 0; i < count; i++) {
            if (elements.nth(i).textContent().contains(product)) {
                elements.nth(i).locator("svg[data-icon=plus-square]").click();
                break;
            }
        }
    }

    public double getPriceTotal(){
        String totalPriceText = page.locator("#price").textContent();
        totalPriceText = totalPriceText.split(":")[1].trim();
        return Double.parseDouble(totalPriceText.substring(0, totalPriceText.length()-1));
    }

    public void deleteProduct(String product) {
        Locator elements = page.locator("mat-row");
        int count = elements.count();
        for (int i = 0; i < count; i++) {
            if (elements.nth(i).textContent().contains(product)) {
                elements.nth(i).locator("svg[data-icon=trash-alt]").click();
                break;
            }
        }
        waitForElements(page.locator("mat-row"), 2000, count-1);
    }

    public AddressPage proceedWithCheckout(){
        page.getByText("Checkout").click();
        return new AddressPage(page);
    }
}
