package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    Logger LOGGER = LoggerFactory.getLogger(ProductsPage.class);

    public ProductsPage(Page page) {
        this.page = page;
        this.topMenu = new TopMenu(page);
    }

    public void dismissWelcomeMessage() {
        page.getByLabel("Close Welcome Banner").click();
    }

    public void dismissCookieMessage() {
        page.getByLabel("dismiss cookie message").click();
    }

    public void selectItemsPerPage(int itemsPerPage) {
        page.getByLabel("Items per page:").locator("div").nth(2).scrollIntoViewIfNeeded();
        page.getByLabel("Items per page:").locator("div").nth(2).click();
        page.getByText(String.valueOf(itemsPerPage)).click();
    }

    public int getCountOfProductsOnPage() {
        waitForElements(page.locator("mat-card"), 2000, 1);
        return page.locator("mat-card").count();
    }

    public List<String> getListOfProductsOnPage(Boolean includeSoldOut){
        List<String> productNames = new ArrayList<>();

        Locator elements = page.locator("mat-card");
        waitForElements(elements, 2000);

        int count  = elements.count();
        for (int i = 0; i < count; i++) {
          if (!includeSoldOut && ! elements.nth(i).textContent().contains("Sold Out")){
              productNames.add(elements.nth(i).locator(".item-name").textContent());
          }
        }
        return productNames;
    }

    public int getExpectedNumberOfProductsAvailable() {
        String txt = page.locator(".mat-paginator-range-label").textContent();
        String [] arr = txt.split(" ");
        return Integer.parseInt(arr[arr.length-1]);
    }

    public void clickProductByName(String text) {
        page.getByText(text, new Page.GetByTextOptions().setExact(false)).click();
    }

    public Boolean isImagePresent(String imageName) {
        return page.locator(".mat-dialog-content").locator("img[src='assets/public/images/products/" + imageName + "']").isVisible();
    }

    public void openReviewsSectionIfExists(){
        if (page.getByText("Reviews", new Page.GetByTextOptions().setExact(false)).isVisible()){
            page.getByText("Reviews", new Page.GetByTextOptions().setExact(false)).click();
            LOGGER.info("Reviews section expanded");
        } else {
            LOGGER.warn("Reviews section not found");
        }
    }

    public void closeProductCard() {
        page.getByLabel("Close Dialog").click();
    }

    public LoginPage goToLoginPage() {
        page.getByLabel("Show/hide account menu").click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Go to login page")).click();
        return new LoginPage(page);
    }

    public void addProductToBasket(String productName) {
        Locator elements = page.locator("mat-card");
        int count  = elements.count();
        for (int i = 0; i < count; i++) {
            if (elements.nth(i).textContent().contains(productName)){
                elements.nth(i).getByText("Add to Basket").click();
                page.getByText(productName + "into basket.", new Page.GetByTextOptions().setExact(false)).waitFor();
                break;
            }
        }
    }
}
