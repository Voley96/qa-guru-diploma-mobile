package guru.qa.driver;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class RealAndroidDriver implements WebDriverProvider {

    private static BrowserStackConfig config =
            ConfigFactory.create(BrowserStackConfig.class);
    private final static String APP_PATH =
            "/Users/vladimir/IdeaProjects/qa-guru-hw-mobile/src/test/resources/app-alpha-universal-release.apk";


    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "442e860");
        desiredCapabilities.setCapability("version", "10.0");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", APP_PATH);
        try {
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}