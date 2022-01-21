package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface SelenoidConfig extends Config {

    @Key("selenoid.url")
    String url();

    @Key("selenoid.app.version")
    String appVersion();

    @Key("selenoid.app.url")
    String appPath();
}
