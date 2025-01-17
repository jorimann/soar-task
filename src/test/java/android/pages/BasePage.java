package android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void goToNearBy() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/icon\").instance(3)").click();
    }

    public void goToHistory() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/icon\").instance(2)").click();
    }

    public void goToMyLists() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/icon\").instance(1)").click();
    }

    public void goToExplore() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/icon\").instance(0)").click();
    }

    public void search(String text) {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_container\")").click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_src_text\")").sendKeys(text);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<WebElement> getSearchResultElements() {
        WebElement searchResultsList = waitElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_results_list\").instance(0)");
        return searchResultsList.findElements(By.className("android.widget.TextView"));
    }

    public void closeSearch() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_close_btn\")").click();
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_close_btn\")").click();
    }

    private WebElement getElement(String locator) {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(locator));
    }

    private WebElement waitElement(String locator) {
        FluentWait<AppiumDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
        wait.until(driver -> !driver.findElements(new AppiumBy.ByAndroidUIAutomator(locator)).isEmpty());
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(locator));
    }

    private List<WebElement> getElements(String locator) {
        return driver.findElements(new AppiumBy.ByAndroidUIAutomator(locator));
    }

    public void scrollToEndMultipleTimes() {
        int maxScrolls = 20;
        boolean canScrollMore = true;
        int scrollCount = 0;

        while (canScrollMore && scrollCount < maxScrolls) {
            try {
                WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollToEnd(1)"
                ));
                canScrollMore = element != null;
            } catch (Exception e) {
                canScrollMore = false;
            }
            scrollCount++;
        }
    }

    public void scrollToTopMultipleTimes() {
        int maxScrolls = 20;
        boolean canScrollMore = true;
        int scrollCount = 0;

        while (!isElementDisplayed("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_container\")") && (canScrollMore && scrollCount < maxScrolls)) {
            try {
                WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollToBeginning(1)"
                ));
                canScrollMore = element != null;
            } catch (Exception e) {
                canScrollMore = false;
            }
            scrollCount++;
        }
    }

    public boolean isElementDisplayed(String locator) {
        try {
            WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void goToSettings() {
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/menu_overflow_button\")").click();
        getElement("new UiSelector().resourceId(\"org.wikipedia.alpha:id/explore_overflow_settings\")").click();
    }

    public void disableAllSettings() {
        List<WebElement> settings = getElements("new UiSelector().resourceId(\"org.wikipedia.alpha:id/switchWidget\")");
        settings.forEach(WebElement::click);
    }

    public void navigateBackFromSettings() {
        getElement("new UiSelector().description(\"Navigate up\")").click();
    }
}
