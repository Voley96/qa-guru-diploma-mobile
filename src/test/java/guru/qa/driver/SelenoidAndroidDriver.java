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


public class SelenoidAndroidDriver implements WebDriverProvider {

    private static BrowserStackConfig config =
            ConfigFactory.create(BrowserStackConfig.class);
    private final static String APP_PATH =
            "https://github.com/qa-guru/wikipedia-mobile-tests/raw/local/src/test/resources/apk/app-alpha-universal-release.apk";


    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");

        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        desiredCapabilities.setCapability("app", APP_PATH);
        try {
            return new AndroidDriver<>(new URL("http://user1:1234@selenoid.autotests.cloud:4444/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}