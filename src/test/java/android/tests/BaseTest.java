package android.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static config.ConfigurationManager.config;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(config().androidDeviceName())
                .setAutomationName(config().androidAutomationName())
                .setAppPackage(config().androidAppPackage())
                .setAppActivity(config().androidActivity())
                .setNewCommandTimeout(Duration.ofMillis(config().androidNewCommandTimeout()))
                .setPlatformName(config().androidPlatformName())
                .setPlatformVersion(config().androidPlatformVersion().toString())
                .setAutoGrantPermissions(config().androidAutoGrantPermissions())
                .setIgnoreHiddenApiPolicyError(config().androidIgnoreHiddenApiPolicyError())
                .setApp(System.getProperty("user.dir") + config().androidPathToAppToInstall())
                .setFullReset(config().androidFullReset())
                .setNoReset(config().androidNoReset());
        driver = new AndroidDriver(new URL(config().androidAppiumServer()), options);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
