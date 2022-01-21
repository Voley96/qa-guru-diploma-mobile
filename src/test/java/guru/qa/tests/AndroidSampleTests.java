package guru.qa.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndroidSampleTests {

    public AndroidSampleTests() throws MalformedURLException {
    }

    public DesiredCapabilities getCaps() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserstack.user", "vovatester_C2F9Yi");
        desiredCapabilities.setCapability("browserstack.key", "fiXzyr4MbyKsg7RTSpVS");

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "Appium tests");
        desiredCapabilities.setCapability("build", "browserstack-build #1");
        desiredCapabilities.setCapability("name", "first_test");

        return desiredCapabilities;
    }

    AndroidDriver<AndroidElement> driver = new AndroidDriver<>(
            new URL("http://hub.browserstack.com/wd/hub"), getCaps());

    @Test
    void appiumTest() throws InterruptedException {

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();

        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");

        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assertTrue(allProductsName.size() > 0);
    }
}
