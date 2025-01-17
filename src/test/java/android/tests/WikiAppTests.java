package android.tests;

import android.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WikiAppTests extends BaseTest {
    BasePage app;

    @Test
    public void task1() throws InterruptedException {
        app = new BasePage(driver);
        app.scrollToEndMultipleTimes();
        app.goToNearBy();
        app.goToHistory();
        app.goToMyLists();
        app.goToExplore();
        app.scrollToTopMultipleTimes();
        Thread.sleep(1000);
    }

    @Test
    public void task2() throws InterruptedException {
        //Task 2:
        //Create an appium script that launch provided app, at search bar
        //search for “New York” then assert that search bar expanded
        //with returned results. Double click on close search button to
        //clear and return to home page.
        app = new BasePage(driver);
        app.search("New York");
        Assertions.assertFalse(app.getSearchResultElements().isEmpty());
        app.closeSearch();
        Thread.sleep(1000);
    }

    @Test
    public void task3() throws InterruptedException {
        // 1. Create an appium script that launch provided app,
        // 2. click on settings icon
        // 3. then disable all options
        // 4. and go back to home page.
        app = new BasePage(driver);
        app.goToSettings();
        app.disableAllSettings();
        Thread.sleep(1000);
        app.navigateBackFromSettings();
        Thread.sleep(1000);
    }
}
