package magicleapTesting;

import gherkin.lexer.Th;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import com.lambdatest.tunnel.Tunnel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class magicLeap {
    // stage = bMrsjajNlv6Fnoi7I7ZYOVuHfPZ0PnqyZre0eUrvUJU3KSB14B

    public String username = "mohammadasadkhan1";//System.getenv("LT_USERNAME"); //"mohammadasadkhan1";
    public String accesskey = "CsbtfqVzuuBShxEgq1K3";//System.getenv("LT_ACCESS_KEY");//"CsbtfqVzuuBShxEgq1K3";
    public RemoteWebDriver driver;
    public String gridURL = "@hub-cloud.browserstack.com/wd/hub" ;//"@eu-central-1-hub.lambdatest.com/wd/hub";
    String status;
    String ResolutionValue;
//    Tunnel t;



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
    public magicLeap(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation, String tunnel) {
        try {

//            create tunnel instance
//            t = new Tunnel();
//            HashMap<String, String> options = new HashMap<String, String>();
//            options.put("user", username);
//            options.put("key", accesskey);
//            //start tunnel
//            t.start(options);

            BrowserValue = browser;
            versionValue = version;
            PlatformValue = platform;
            FixedIpValue = fixedIp;
            ResolutionValueCap = resolution;
            TimeZoneValue = timezone;
            GeoLocationValue = geoLocation;
            Tunnel = tunnel;
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

          //for (int i = 0; i < 9; i++) {
        try {

//            String[] extention = {"https://test-artefacts-prod.s3.amazonaws.com/extensions/orgId-32518/2.1.0_0.zip"};

            DesiredCapabilities capabilities = new DesiredCapabilities();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-web-security");
//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

//            options.addArguments("ignore-certificate-errors");
//            options.addArguments("enable-automation");


//            capabilities.setCapability("browserstack.networkLogsOptions",networkLogsOptions);
//            capabilities.setCapability(ChromeOptions.CAPABILITY,options);
//            options.setCapability("nativeEvents",true);
//            capabilities.setCapability("loadExtension", extention);
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "88.0");
            //capabilities.setCapability("version", "latest" + "-" + i);

//             capabilities.setCapability("fixedIP", "10.81.8.175");
            capabilities.setCapability("os", "Windows");
            capabilities.setCapability("os_version", "10");
//            capabilities.setCapability("platform","Windows 10");
//            capabilities.setCapability("build", "Live");
//            capabilities.setCapability("resolution", "1680x1050");

//            capabilities.setCapability("acceptInsecureCerts","true");
     //      capabilities.setCapability("chrome.driver","2.34");
       //    capabilities.setCapability("selenium_version","3.14.59");
//            capabilities.setCapability("region","us");
//            capabilities.setCapability("geoLocation","US");
//            capabilities.setCapability("browserstack.autoWait",35);
//            capabilities.setCapability("browserstack.console","verbose");
//            capabilities.setCapability("browserstack.debug","true");
//            capabilities.setCapability("browserstack.local","true");
//            capabilities.setCapability("network",true);
//            capabilities.setCapability("project","P1");
      //      options.setExperimentalOption("mobileEmulation","iPhone X");
            //capabilities.setCapability("ie.driver", "2.53.1");
//
        //    capabilities.setCapability("rotatable",false);
//            Map<String, String> mobileEmulation = new HashMap<>();
//            mobileEmulation.put("deviceName", "iPhone X");
//            options.setExperimentalOption("mobileEmulation", mobileEmulation);
//
//            Map<String, Object> prefs = new HashMap<String, Object>();
//            prefs.put("profile.managed_default_content_settings.geolocation", 2);
//            prefs.put("profile.managed_default_content_settings.notifications",2);
//            options.setExperimentalOption("prefs", prefs);
//
           // capabilities.setCapability("nativeEvents",false);
//            capabilities.setCapability("name", this.TestName);
//            float abc = (float) 12.234;
                        capabilities.setCapability("build", "Jenkins US PeacockTV");
//      //      capabilities.setCapability("resolution", "1280x1024");
//            capabilities.setCapability("console", true);
//             capabilities.setCapability("network", true);
            capabilities.setCapability("browserstack.networkLogs", "true");
//        capabilities.setCapability("browserstack.geoLocation", "US");
            //    capabilities.setCapability("w3c",false);
//            MessageDigest m=MessageDigest.getInstance("MD5");
//            String s = "vishnukdas:D3tRgjqJOrG7GKCmdIkafAP7uUbPfiK3SaWXTWdjX3vhglk2yd";
//            m.update(s.getBytes(),0,s.length());
//            System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));


//           // capabilities.setCapability("network.har", true);
//            capabilities.setCapability("idleTimeout","20");
            //capabilities.setCapability("ie.compatibility",11001);
//            capabilities.setCapability("unexpectedAlertBehaviour","accept");

         //   capabilities.setCapability("safari.cookies", true);
////capabilities.setCapability("w3c",true);
      //      capabilities.setCapability("performance",true);
//            capabilities.setCapability("video", true);
//            capabilities.setCapability("visual", true);
         //      capabilities.setCapability("tunnel", true);
//              capabilities.setCapability("seleniumVersion", "3.141.59");

        /*  System.out.println(Tunnel);
            if (this.Tunnel.matches("true")) {

               RunTunnelListener TunnelInitateObjectToStart= new RunTunnelListener();
                TunnelInitateObjectToStart.onExecutionStart();

                Thread.sleep(20000);
                capabilities.setCapability("tunnel", "true");
            }


            //      capabilities.setCapability("safari.cookies",true);
            //   capabilities.setCapability("region", "eu");
                  capabilities.setCapability("fixedIP", this.FixedIpValue);
            //  capabilities.setCapability("tunnel", "true");


         */
   //     capabilities.setCapability("ie.driver","3.150.1.0");
    //    capabilities.setCapability("ie.compatibility",11001);
            //     capabilities.setCapability("tunnelName", "prateek");
            //           capabilities.setCapability("geoLocation", geoLocation);
            //    capabilities.setCapability("unboundRegion", "PUSE-EU");
            //     capabilities.setCapability("timezone", this.TimeZoneValue);
             // capabilities.setCapability("geoLocation", this.GeoLocationValue);
            //     capabilities.setCapability("headless", true);
            //   capabilities.setCapability("networkThrottling", "Regular 4G");
            //  capabilities.setCapability("prerun", "lambda:BasicAuthChrome/pre/httpdialog.au3");
//            String[] Tags = new String[]{"myproject", "myproject2","myproject3"};
//
//            capabilities.setCapability("tags", Tags);


            StopWatch driverStart = new StopWatch();
            driverStart.start();

            hub = "http://" + username + ":" + accesskey + gridURL;
//            hub="http://localhost:4444/wd/hub";
            System.out.println(hub);

            driver = new RemoteWebDriver(new URL(hub), capabilities);
            session = driver.getSessionId();

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
        //   }


    }

    @Test
    public void DesktopScript() {
        try {

           /* TodoApp TodoAppTestObject = new TodoApp();
            TodoAppTestObject.TodoAppTest(driver);*/

//            SessionTest SessionTestObject = new SessionTest();
//            SessionTestObject.SessionLaunch(driver, status);
//            uploadTest UPFile = new uploadTest();
//                 UPFile.upload(driver, status);
//            TodoApp TodoAppTestObject = new TodoApp();
//            TodoAppTestObject.TodoAppTest(driver);
            driver.get("https://www.peacocktv.com/signin");

            Thread.sleep(2000);
            driver.findElementByName("userIdentifier").sendKeys("testing");
            driver.findElementByName("password").sendKeys("test");

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/div/div/form/div[5]/button")).click();

            Thread.sleep(5000);

//            driver.get("chrome://settings/clearBrowserData");
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            WebElement ele = (WebElement) js.executeScript("return document.querySelector(\"body > settings-ui\").shadowRoot.querySelector(\"#main\").shadowRoot.querySelector(\"settings-basic-page\").shadowRoot.querySelector(\"#basicPage > settings-section:nth-child(8) > settings-privacy-page\").shadowRoot.querySelector(\"settings-clear-browsing-data-dialog\").shadowRoot.querySelector(\"* /deep/ #clearBrowsingDataConfirm\")");
//            js.executeScript("arguments[0].click();", ele);
//


//            driver.findElementByCssSelector("#clearBrowsingDataConfirm").click();


//             Thread.sleep(5000);

            driver.quit();
//            driver.findElement(By.name("q")).sendKeys("LambdaTest");
//            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

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

            }
//            */
//            TunnelTest TunnelTestObject = new TunnelTest();
//            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
//            System.out.println(Tunnel);
            /*if (this.Tunnel.matches("true")) {
                TunnelTest TunnelTestObject = new TunnelTest();
                TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);
//            }*/
//               NetSpeed NetSpeedTestObject = new NetSpeed();
//                NetSpeedTestObject.NetSpeed(driver, status, Nettotalspeedtest);
//        /*    TunnelTest TunnelTestObject = new TunnelTest();
//            TunnelTestObject.tunnelTest(driver, status, totaltimeforlocaltest);*/
//           /* UserTest UserTestObject= new UserTest();
//            UserTestObject.TestCase(driver,status);*/
//           driver.get("https://youtube.com");
//           Thread.sleep(10000);
//
//            driver.executeScript("lambda-perform-keyboard-events:^R");
//
//            Thread.sleep(10000);
//            driver.quit();
//            try {


//                driver.get("https://ifconfig.me/");
//                System.out.println(driver.executeScript("lambda-perform-keyboard-events:^p")); //for CTRL+P
//                Thread.sleep(2000);
//                System.out.println(driver.executeScript("lambda-perform-keyboard-events:{ENTER}")); //pressing ENTER
//                Thread.sleep(2000);
//                System.out.println(driver.executeScript("lambda-perform-keyboard-events:demo-testing-keystroke.pdf"));  //inserting charcters
//                Thread.sleep(2000);
//                System.out.println(driver.executeScript("lambda-perform-keyboard-events:{ENTER}"));
//                Thread.sleep(2000);
//            }catch(Exception E){
//                status="failed";
//                System.out.println(E);
//            }
//            driver.get("https://jqueryui.com/droppable/");
//
//            WebElement webFrame = driver.findElement(By.className("demo-frame"));
//
//            driver.switchTo().frame(webFrame);
//
//            WebElement source = driver.findElement(By.id("draggable"));
//            WebElement target = driver.findElement(By.id("droppable"));
//
//            Actions action = new Actions(driver);
//
//            String colourBeforeDnD = target.getCssValue("color");
//
//            //action.dragAndDrop(source, target).build().perform();
//
//            action.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
//
//            String colorAfterDnD = target.getCssValue("color");
//
//            System.out.println("Color before Drag and Drop : "+ colourBeforeDnD);
//
//            System.out.println("Color after Drag and Drop : "+ colorAfterDnD);
//            driver.get("https://ipinfo.io/");
//            Thread.sleep(5000);
//            driver.quit();
//            GeolocationTest Geolocationobject = new GeolocationTest();
//            Geolocationobject.Geolocation(driver, status, GeoLocationValue, GeolocationTotal);

//            ResolutionTest ResolutionTestObject = new ResolutionTest();
//           ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap);

////
//                driver.get("https://staging.secure-payment.moona.com/checkout");
//                driver.manage().window().maximize();
//                driver.findElementByName("simulate").click();
////                Thread.sleep(5000);
//                driver.findElementByName("go-to-pay-button").click();
//                Thread.sleep(5000);
//
//                driver.getSessionId();

                //            driver.switchTo().frame("__privateStripeFrame3695");
//            driver.findElementByName("cardnumber").sendKeys("1234098712340987");
//                Thread.sleep(5000);
//            driver.quit();


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
//            RunTunnelListener TunnelInitateObjectToStop = new RunTunnelListener();
//            TunnelInitateObjectToStop.onExecutionFinish();
//            t.stop();

        }
        quitestoptime = System.currentTimeMillis();
        quitetimestop = quitestoptime - quitetimestart;
        System.out.println(platform + "  " + browser + "  " + version + "\n" + "Driver Quit time" + "   " + quitetimestop / 1000f + "Sec.");

    }


}

