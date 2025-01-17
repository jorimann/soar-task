package ui.tests;

import com.microsoft.playwright.*;
import ui.browser.BrowserManager;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.pages.ProductsPage;

import static config.ConfigurationManager.config;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;
    protected ProductsPage productsPage;

    @BeforeAll
    public void createPlaywrightAndBrowserInstances() {
        playwright = Playwright.create();
        browser = BrowserManager.getBrowser(playwright);
    }

    @AfterAll
    public void closeBrowserAndPlaywrightSessions() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @BeforeEach
    void setupContextAndNavigateToProductsPage() {
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(config().viewportWidth(), config().viewportHeight())
                .setDeviceScaleFactor(config().deviceScaleFactor());

        context = browser.newContext(options);
        context.setDefaultTimeout(config().timeout());

        page = context.newPage();

        page.navigate(config().uiBaseUrl());
        productsPage = new ProductsPage(page);
        productsPage.dismissWelcomeMessage();
        productsPage.dismissCookieMessage();
    }

    @AfterEach
    void closeContext() {
        if (page != null) page.close();
        if (context != null) context.close();
    }

}

