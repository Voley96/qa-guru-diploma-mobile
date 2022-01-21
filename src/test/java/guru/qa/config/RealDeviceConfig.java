package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface RealDeviceConfig extends Config {

    @Key("real.device.name")
    String deviceName();

    @Key("real.device.version")
    String deviceVersion();

    @Key("real.app.path")
    String appPath();
}
