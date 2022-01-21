package guru.qa.driver;

import com.codeborne.selenide.WebDriverProvider;
import guru.qa.config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class SelenoidAndroidDriver implements WebDriverProvider {

    private final SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", config.appVersion());

        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        desiredCapabilities.setCapability("app", config.appPath());
        try {
            return new AndroidDriver<>(new URL(config.url()), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}