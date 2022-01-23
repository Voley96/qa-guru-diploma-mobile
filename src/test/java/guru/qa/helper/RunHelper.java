package guru.qa.helper;

import guru.qa.config.RunConfig;
import guru.qa.driver.BrowserstackMobileDriver;
import guru.qa.driver.LocalAndroidDriver;
import guru.qa.driver.RealAndroidDriver;
import guru.qa.driver.SelenoidAndroidDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {

    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        if (config.deviceHost() == null) {
            throw new RuntimeException("Device host should not be null value");
        }

        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalAndroidDriver.class;
            case "real":
                return RealAndroidDriver.class;
            case "selenoid":
                return SelenoidAndroidDriver.class;
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
