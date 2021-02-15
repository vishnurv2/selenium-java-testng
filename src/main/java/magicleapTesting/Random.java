package magicleapTesting;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Random {
    public String username = "vishnukdas";
    public String accesskey = "40fkQ3JuRlYMzd4ff7uqkqXCTnwvvkEB7FWJz1sLS2qSqoEDal";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";//"@18.212.120.135:32450/wd/hub";//"";
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
    String browserNameValue;
    String platformVersionValue;
    String platformValueDevice;
    String fixedIpValue;
    String deviceNameValue;
    String geoLocationValue;
    String ResolutionValueCap;

    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "fixedIp", "deviceName", "geoLocation"})

    public Random(String browser, String platformVersion, String platform, String fixedIp, String deviceName, String geoLocation) {
        browserNameValue = browser;
        platformVersionValue = platformVersion;
        platformValueDevice = platform;
        fixedIpValue = fixedIp;
        deviceNameValue = deviceName;
        geoLocationValue = geoLocation;


    }


    @BeforeTest
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //  double version = 13.2;
        capabilities.setCapability("platformVersion", this.platformVersionValue);
        capabilities.setCapability("platform", this.platformValueDevice); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("name", this.platformValueDevice + "   " + this.deviceNameValue + "  " + this.platformVersionValue);
        capabilities.setCapability("build", "iOS 14.2 ");
        //capabilities.setCapability("isRealMobile",true);
        //capabilities.setCapability("nativeWebScreenshot",true);
     //   capabilities.setCapability("fixedIP", "10.242.32.73");
        capabilities.setCapability("deviceName", this.deviceNameValue);
        
  //      capabilities.setCapability("network", true);
   //     capabilities.setCapability("console", true);
    //    capabilities.setCapability("visual", true);
     //   capabilities.setCapability("language","fr");

        //  capabilities.setCapability("isRealMobile", true);
        //    capabilities.setCapability("w3c", false);
        capabilities.setCapability("tunnel", true);

    //          capabilities.setCapability("appiumVersion ", "1.12.1");

        //  capabilities.setCapability("autoDismissAlerts", true);

        //  capabilities.setCapability("tunnel", true);
      /*  capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", true);*/
        //  capabilities.setCapability("orientation", "LANDSCAPE");
        //     capabilities.setCapability("appiumVersion", "1.17.1");

        //  capabilities.setCapability("console", true); // To capture console logs
        // capabilities.setCapability("geoLocation", this.geoLocationValue);

        //capabilities.setCapability("tunnelName", "prateek");
       /* capabilities.setCapability("os_version", "14");
        capabilities.setCapability("device", "iPhone 11");
        capabilities.setCapability("real_mobile", "true");
        capabilities.setCapability("browserstack.local", "false");
        capabilities.setCapability("browserstack.appium_version", "1.18.0");
        capabilities.setCapability("browserstack.debug", "true");
        capabilities.setCapability("browserstack.networkLogs", "true");
*/


        try {
            StopWatch driverStart = new StopWatch();
            driverStart.start();
            String url = "http://" + username + ":" + accesskey + gridURL;
            System.out.println(url);
            driver = new RemoteWebDriver(new URL(url), capabilities);
            //   session = driver.getSessionId();

            driverStart.stop();
            float timeElapsed = driverStart.getTime() / 1000f;
            System.out.println("Driver Setup time in Seconds " + "  " + timeElapsed + "Sec." + "  " + this.deviceNameValue + "  " + this.fixedIpValue);

        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
            System.out.println("Test null pointer exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Test null pointer exception");
        }

    }

    @Test(priority = 1)
    public void DesktopScript() throws IOException {

        try {

            long startTest;
            long stopTest;
            startTest = System.currentTimeMillis();
            StopWatch teststarted = new StopWatch();
            teststarted.start();
            
            SessionTest SessionTestObject = new SessionTest();
            SessionTestObject.SessionLaunch(driver, status);
    //        TodoApp TodoAppTestObject = new TodoApp();
      //      TodoAppTestObject.TodoAppTest(driver);
//            StreamTest YouTubeStream = new StreamTest();
//            YouTubeStream.TestStream(driver, status);

          /*  for (int i = 0; i < 1; i++) {
                TodoApp TodoAppTestObject = new TodoApp();
                TodoAppTestObject.TodoAppTest(driver);
                StreamTest YouTubeStream = new StreamTest();
                YouTubeStream.TestStream(driver, status);

            }*/
         /*   ResolutionTest ResolutionTestObject = new ResolutionTest();
            ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap);*/
          /*  TunnelTest TunnelTestObject = new TunnelTest();
            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest); */
         //   driver.manage().deleteAllCookies();
            driver.get("http://localhost.lambdatest.com");
            Thread.sleep(10000);
            driver.getTitle();
            Thread.sleep(10000);

/*
                System.out.println(Tunnel);
                if (this.Tunnel.matches("true")) {

                }*/

               /* NetSpeed NetSpeedTestObject = new NetSpeed();
                NetSpeedTestObject.NetSpeed(driver, status, Nettotalspeedtest);
*/
          /*  UserTest UserTestObject = new UserTest();
            UserTestObject.TestCase(driver, status);*/

          /*  AnroidVersion AndVerObj = new AnroidVersion();
            AndVerObj.AndVersion(driver, deviceNameValue, platformVersionValue);
            ChromeBrowserVersion ChromeVersionObject = new ChromeBrowserVersion();
            ChromeVersionObject.BrowserVersion(driver, deviceNameValue, platformVersionValue);*/
          /*  GeolocationTest GeoObject = new GeolocationTest();
            GeoObject.Geolocation(driver, status, geoLocationValue, GeolocationTotal);*/
            stopTest = System.currentTimeMillis();
            totaltime = stopTest - startTest;

            System.out.println("Time taken by the test to execute" + "    " + totaltime / 1000f + "Sec.");
        } catch (Exception y) {
            status = "failed";
            System.out.println(y);
              /*  File filetwo = driver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(filetwo, new File("myScreenshot.png"));*/
        }


    }

    @AfterTest
    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "fixedIp", "deviceName", "geoLocation"})

    public void tearDown(String browser, String platformVersion, String platform, String fixedIp, String deviceName, String geoLocation) throws Exception {
        try {
            long quitetimestart;
            long quitetimestop;

            quitetimestart = System.currentTimeMillis();

            if (driver != null) {

                // System.out.println(driver + "Session ID" + "  " + session.toString());
//                ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

                driver.quit();

                status = "passed";
            } else {
                status = "failed";
            }
            quitestoptime = System.currentTimeMillis();
            quitetimestop = quitestoptime - quitetimestart;
            System.out.println(deviceName + "  " + browser + "  " + platformVersion + "   " + fixedIp + "\n" + "Driver Quite time" + "   " + quitetimestop / 1000f + "Sec.");
        } catch (Exception T) {
            System.out.println(T);
        }

    }
}

