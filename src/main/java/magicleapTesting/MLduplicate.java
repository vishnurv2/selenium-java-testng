package magicleapTesting;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MLduplicate {

    public String username = "sushobhitd";
    public String accesskey = "8NFTCyOh68MjrGVTlCT9RAau9B1jIaIJQhESCXFJzvUqx057Yu";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub"; //"@eu-central-1-hub.lambdatest.com/wd/hub";
    String status;
    String ResolutionValue;
    long quitestoptime;
    long totaltime;
    long totaltimeforlocaltest;
    long Nettotalspeedtest;
    long GeolocationTotal;
    long ResolutionTotal;
    long totaltesttimeDuration;
    SessionId session;
    String BrowserValue;
    String versionValue;
    String PlatformValue;
    String FixedIpValue;
    String ResolutionValueCap;
    String TimeZoneValue;
    String GeoLocationValue;
    String hub;
    String TestName;
    String Space = "  ";
    String Tunnel;
    String AllVersions = null;


    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "resolution", "timezone", "geoLocation", "tunnel"})
    public MLduplicate(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation, String tunnel) {
        try {
            BrowserValue = browser;
            versionValue = version;
            PlatformValue = platform;
            FixedIpValue = fixedIp;
            ResolutionValueCap = resolution;
            TimeZoneValue = timezone;
            GeoLocationValue = geoLocation;
            Tunnel = System.getProperty("tunnel");
            if (BrowserValue != null) {
                TestName = BrowserValue;
                if (PlatformValue != null) {
                    TestName = BrowserValue + Space + PlatformValue;
                    if (versionValue != null) {
                        TestName = BrowserValue + Space + PlatformValue + Space + versionValue;
                        if (FixedIpValue != null)
                            TestName = BrowserValue + Space + PlatformValue + Space + versionValue + Space + FixedIpValue;

                    }
                }
            }

        } catch (Exception t) {
        }
    }

    @BeforeTest
    public void setUp() throws Exception {
        System.out.println(this.versionValue);

        for (int i = 0; i < 9; i++) {
            try {


                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", this.BrowserValue);
                capabilities.setCapability("version", this.versionValue);
                //capabilities.setCapability("version", "latest" + "-" + i);
                capabilities.setCapability("platform", this.PlatformValue);
                capabilities.setCapability("build", "Tunnel/2 3");
                capabilities.setCapability("name", this.TestName);
                capabilities.setCapability("resolution", this.ResolutionValueCap);
                capabilities.setCapability("console", true);
                capabilities.setCapability("network", true);


                capabilities.setCapability("video", true);
                capabilities.setCapability("visual", true);
                capabilities.setCapability("tunnel", true);

                capabilities.setCapability("selenium_version", "4.0.0-alpha-1");

          /*  System.out.println(Tunnel);
            if (this.Tunnel.matches("true")) {

               RunTunnelListener TunnelInitateObjectToStart= new RunTunnelListener();
                TunnelInitateObjectToStart.onExecutionStart();

                Thread.sleep(20000);
                capabilities.setCapability("tunnel", "true");
            }*/
                //      capabilities.setCapability("safari.cookies",true);
                //   capabilities.setCapability("region", "eu");
                capabilities.setCapability("fixedIP", this.FixedIpValue);
                //   capabilities.setCapability("tunnel", "true");
        /*capabilities.setCapability("ie.driver","3.4.0");
        capabilities.setCapability("ie.compatibility",11001);*/
                //     capabilities.setCapability("tunnelName", "prateek");
                //           capabilities.setCapability("geoLocation", geoLocation);
                //    capabilities.setCapability("unboundRegion", "PUSE-EU");
                capabilities.setCapability("timezone", this.TimeZoneValue);
                //    capabilities.setCapability("geoLocation", this.GeoLocationValue);
                //     capabilities.setCapability("headless", true);
                //   capabilities.setCapability("networkThrottling", "Regular 4G");
                //  capabilities.setCapability("prerun", "lambda:BasicAuthChrome/pre/httpdialog.au3");
//            String[] UploadFiles = new String[]{"1mb.jpg", "2mb.jpg"};
//
//            capabilities.setCapability("lambda:userFiles", UploadFiles);

                StopWatch driverStart = new StopWatch();
                driverStart.start();

                hub = "http://" + username + ":" + accesskey + gridURL;
                System.out.println(hub);

                driver = new RemoteWebDriver(new URL(hub), capabilities);
                session = driver.getSessionId();

                uploadTest UPFile = new uploadTest();
                TodoApp TodoAppTestObject = new TodoApp();
                TodoAppTestObject.TodoAppTest(driver);
                UPFile.upload(driver, status);
                driver.quit();
                //   System.out.println(driver + "Session ID" + "  " + session.toString() + "\n" + browser + version + "\n" + fixedIp);
                driverStart.stop();

                float timeElapsed = driverStart.getTime() / 1000f;
                System.out.println("Driver initiate time" + "   " + timeElapsed);


            } catch (
                    MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception f) {
                status = "failed";
                System.out.println(f);
                // System.out.println(f.getMessage() + browser + version + fixedIp);
            }
        }


    }

    @Test
    public void DesktopScript() {
        try {
            SessionTest SessionTestObject = new SessionTest();
            SessionTestObject.SessionLaunch(driver, status);
            uploadTest UPFile = new uploadTest();
            TodoApp TodoAppTestObject = new TodoApp();
            TodoAppTestObject.TodoAppTest(driver);
            UPFile.upload(driver, status);
           /* if (this.BrowserValue.matches("Chrome")) {
                ChromeBrowserVersion ChromeVersionObject = new ChromeBrowserVersion();
                ChromeVersionObject.BrowserVersion(driver);

            }

            System.out.println(hub);*/

          /*  for (int i = 0; i < 15; i++) {
                TodoApp TodoAppTestObject = new TodoApp();
                TodoAppTestObject.TodoAppTest(driver);


                ResolutionTest ResolutionTestObject = new ResolutionTest();
                ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap);

            }*/

            /*TunnelTest TunnelTestObject = new TunnelTest();
            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
            System.out.println(Tunnel);*/
            /*if (this.Tunnel.matches("true")) {
                TunnelTest TunnelTestObject = new TunnelTest();
                TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
            }*/
             /*   NetSpeed NetSpeedTestObject = new NetSpeed();
                NetSpeedTestObject.NetSpeed(driver, status, Nettotalspeedtest);*/
        /*    TunnelTest TunnelTestObject = new TunnelTest();
            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);*/
           /* UserTest UserTestObject= new UserTest();
            UserTestObject.TestCase(driver,status);*/
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @AfterTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
    public void tearDown(String version, String platform, String browser) throws Exception {
        long quitetimestart;
        long quitetimestop;

        quitetimestart = System.currentTimeMillis();

        if (driver != null) {
            System.out.println(driver + "Session ID" + "  " + session.toString());

            driver.quit();
            RunTunnelListener TunnelInitateObjectToStop = new RunTunnelListener();
            TunnelInitateObjectToStop.onExecutionFinish();


        }
        quitestoptime = System.currentTimeMillis();
        quitetimestop = quitestoptime - quitetimestart;
        System.out.println(platform + "  " + browser + "  " + version + "\n" + "Driver Quite time" + "   " + quitetimestop / 1000f + "Sec.");

    }


}

