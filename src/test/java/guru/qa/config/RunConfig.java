package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface RunConfig extends Config {

    @Key("deviceHost")
    @DefaultValue("browserstack")
    String deviceHost();

}
