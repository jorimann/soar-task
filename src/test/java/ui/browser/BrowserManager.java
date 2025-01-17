package ui.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

import static config.ConfigurationManager.config;

public class BrowserManager {
    private BrowserManager() {}

    public static Browser getBrowser(final Playwright playwright){
        return BrowserFactory.valueOf(config().browserType().toUpperCase()).createInstance(playwright);
    }
}

