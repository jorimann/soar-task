package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static config.ConfigurationManager.config;

public class TopMenu {
    private Page page;
    public TopMenu(Page page) {
        this.page = page;
    }

    public String getUserEmail(){
        page.getByLabel("Show/hide account menu").click();
        return page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Go to user profile")).locator("span").textContent().trim();
    }

    public int getCountOfProductsInBasket() {
        String [] str = page.getByLabel("Show the shopping cart").allInnerTexts().get(0).split("\n");
        return Integer.parseInt(str[1]);
    }

    public BasketPage goToBasketPage() {
        page.getByText("Your Basket").click();
        return new BasketPage(page);
    }

    public int waitForCountOfProductsInBasket(int expectedCount ) {
        long currentTimeMillis = System.currentTimeMillis();
        while (getCountOfProductsInBasket() != expectedCount && currentTimeMillis + config().waitElement() > System.currentTimeMillis()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return getCountOfProductsInBasket();
    }
}
