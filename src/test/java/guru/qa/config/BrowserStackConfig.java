package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserStackConfig extends Config {

    @Config.Key("browserstack.user")
    String user();

    @Config.Key("browserstack.key")
    String key();

    @Config.Key("browserstack.app")
    String app();
}
