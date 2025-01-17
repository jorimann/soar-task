package ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

public abstract class BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    protected Page page;
    public TopMenu topMenu;
    protected void waitForElements(Locator locator, int milliseconds) {
        long currentTimeMillis = System.currentTimeMillis();
        do {
            try{
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (locator.count() <= 0 || currentTimeMillis + milliseconds < System.currentTimeMillis());


        if (locator.count() == 0){
            throw new NoSuchElementException("number of elements is zero: " + locator);
        }
    }

    protected void waitForElements(Locator locator, int milliseconds, int expectedCount) {
        long currentTimeMillis = System.currentTimeMillis();
        while (locator.count() != expectedCount && currentTimeMillis + milliseconds < System.currentTimeMillis()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (locator.count() == 0){
            throw new NoSuchElementException("number of elements is zero: " + locator);
        }
    }
}
