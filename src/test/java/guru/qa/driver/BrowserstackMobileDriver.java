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

public class BrowserstackMobileDriver implements WebDriverProvider {

    private final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);


    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.user());
        desiredCapabilities.setCapability("browserstack.key", config.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", config.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Xiaomi Redmi Note 9");
        desiredCapabilities.setCapability("os_version", "10.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Qa guru diploma");
        desiredCapabilities.setCapability("build", "#133");
        desiredCapabilities.setCapability("name", "wiki tests");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new AndroidDriver<>(new URL("http://hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}