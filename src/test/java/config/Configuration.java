package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties","classpath:config.properties"})
public interface Configuration extends Config {

    @Key("ui.baseurl")
    String uiBaseUrl();

    @Key("ui.browsertype")
    String browserType();

    @Key("ui.headless")
    Boolean headless();

    @Key("ui.viewport.width")
    Integer viewportWidth();

    @Key("ui.viewport.height")
    Integer viewportHeight();

    @Key("ui.device.scale.factor")
    @DefaultValue("1")
    Integer deviceScaleFactor();

    @Key("ui.slow.motion")
    Integer slowMotion();

    @Key("ui.timeout")
    Integer timeout();

    @Key("ui.wait.element")
    Integer waitElement();

    @Key("android.appium.server")
    String androidAppiumServer();

    @Key("android.device.name")
    String androidDeviceName();

    @Key("android.app.package")
    String androidAppPackage();

    @Key("android.automation.name")
    String androidAutomationName();

    @Key("android.app.activity")
    String androidActivity();

    @Key("android.new.command.timeout")
    Integer androidNewCommandTimeout();

    @Key("android.platform.name")
    String androidPlatformName();

    @Key("android.platform.version")
    Integer androidPlatformVersion();

    @Key("android.auto.grant.permissions")
    boolean androidAutoGrantPermissions();

    @Key("android.ignore.hidden.api.policy.error")
    boolean androidIgnoreHiddenApiPolicyError();

    @Key ("android.path.to.app.to.install")
    String androidPathToAppToInstall();

    @Key("android.app.no.reset")
    boolean androidNoReset();

    @Key("android.app.full.reset")
    boolean androidFullReset();
}
