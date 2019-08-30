import geb.*;
import geb.spock.GebSpec;
import geb.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import spock.lang.Specification;


import java.net.URL;

public class SampleGeb {
    public String username = "prateeks";
    public String accesskey = "utDW23FJGmZgmgmMu1eoF7sZvobSn7Cmdjwbyqbp5qkJd3EYDo";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status;

    public void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("version", version);
        //   capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformName", "platform"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Debug ");
        capabilities.setCapability("name", "");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        capabilities.setCapability("deviceName", "");
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("w3c", false);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);

        } catch (Exception e)
        {

        }
    }
class Sample extends Specification{

}

    }

