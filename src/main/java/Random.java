

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Random {
    public String username = "prateeks";
    public String accesskey = "utDW23FJGmZgmgmMu1eoF7sZvobSn7Cmdjwbyqbp5qkJd3EYDo";
    public RemoteWebDriver driver;
    public String gridURL = "@stage-hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "fixedIp", "deviceName"})
    public void setUp(String browser, String platformVersion, String platform, String fixedIp, String deviceName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //  capabilities.setCapability("platformVersion", platformVersion);
        //   capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformName", platform); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Device test Android");
        capabilities.setCapability("name", browser + platform + deviceName);
        capabilities.setCapability("network", false); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        capabilities.setCapability("deviceName", deviceName);

        //   capabilities.setCapability("w3c", false);

        //   capabilities.setCapability("fixedIP", fixedIp);

        //   capabilities.setCapability("tunnel", true);
        try {
            String url = "https://" + username + ":" + accesskey + gridURL;
            driver = new RemoteWebDriver(new URL(url), capabilities);
            System.out.println(driver);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void screenshotSequenceRunner() {
        try {



            System.out.println("windwo handling start");
            ((JavascriptExecutor) driver).executeScript("window.open()");
            System.out.println("windwo windows open");
            ArrayList<String> ta = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(ta.get(0));
            //switches to new tab
            driver.get("https://www.youtube.com/watch?v=a-T4ZPP3k8U");
            System.out.println("windwos open Url");
            Thread.sleep(20000);
            System.out.println("scroll down");

            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollBy(0,500)");
            driver.manage().deleteAllCookies();
            Thread.sleep(500);
            Thread.sleep(50000);
//Thread.sleep(90000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); //switches to new tab
            driver.get("http://localhost:4200");
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //   FileUtils.copyFile(src, new File("C:/selenium/error.png"));
            Thread.sleep(10000);
            driver.manage().deleteAllCookies();

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(2)); //switches to new tab
            driver.get("https://amazon.com/");
            Thread.sleep(30000);
            System.out.println("windwo handling stop");
            driver.get("https://amazon.com/");
            JavascriptExecutor scrolly = (JavascriptExecutor) driver;
            scrolly.executeScript("window.scrollBy(0,500)");
            Thread.sleep(500);
            JavascriptExecutor scrolldddy = (JavascriptExecutor) driver;
            scrolldddy.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(500);

            JavascriptExecutor scrolld = (JavascriptExecutor) driver;
            scrolld.executeScript("window.scrollBy(0,700)");
            Thread.sleep(500);

            JavascriptExecutor scrolldd = (JavascriptExecutor) driver;
            scrolldd.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(500);

            System.out.println("scroll up");
            driver.manage().deleteAllCookies();

            JavascriptExecutor scrollddd = (JavascriptExecutor) driver;
            scrollddd.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(500);
            driver.get("http://demo.guru99.com/test/upload/");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }


    }
}

