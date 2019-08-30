import geb.*;
import geb.spock.GebSpec;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


import io.appium.java_client.AppiumDriver;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.WebElement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import sun.awt.windows.ThemeReader;

import static org.testng.reporters.jq.BasePanel.D;

public class Random {
    public String username = "prateeks";
    public String accesskey = "utDW23FJGmZgmgmMu1eoF7sZvobSn7Cmdjwbyqbp5qkJd3EYDo";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "deviceName"})
    public void setUp(String browser, String version, String platform, String fixedIp, String deviceName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("version", version);
        //   capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformName", platform); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Debug ");
        capabilities.setCapability("name", browser + platform + deviceName);
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("w3c", false);

        //      capabilities.setCapability("realMobile", true);
        //capabilities.setCapability("nativeWebScreenshot", true);
        //  capabilities.setCapability("port", "8000");
        // capabilities.setCapability("orientation","LANDSCAPE");

        // capabilities.setCapability("resolution", "1600x900");
        //capabilities.setCapability("timezone", "UTC+05:30"); //nativeWebScreenshot
        //  capabilities.setCapability("fixedIP", fixedIp);

          capabilities.setCapability("tunnel", false);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
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
            driver.get("https://raylo-frontend-staging.herokuapp.com/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/ul[1]/li[1]/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/ul[2]/li[1]/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/div/ul/li/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/div/ul/li/div/ul/li[1]/button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"invitationCode\"]")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"invitationCode\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"invitationCode\"]")).sendKeys("dev-234");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('invitationCode').value='dev-234';");





            //WebElement user=   driver.findElement(By.xpath("//*[@id=\"invitationCode\"]"));

            // user.sendKeys("dev-234");
/*
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/section[1]/div[2]/div/form/div[2]/div[2]/button")).click();

*/

            //System.out.println("Url get by the browser");

          /*  driver.get("https://sentry.io/auth/login/");
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys("sushobhitd@lambdatest.com");
            System.out.println("Test running");
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("sushobhit@2018");
            List<WebElement> loginbutton = driver.findElementsByXPath("//*[@id=\"login\"]/div/div[1]/form/div[3]/button");
            loginbutton.get(0).click();
            Thread.sleep(10000);
            driver.manage().deleteAllCookies();*/
            //  driver.setFileDetector(new LocalFileDetector());



/*driver.get("https://www.google.com");
            String handle= driver.getWindowHandle();

            driver.switchTo().window(handle);

            driver.get("https://www.facebook.com");*/

            /*driver.get("https://lambdatest.github.io/sample-todo-app/");

            //Let's mark done first two items in the list.
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).getAttribute("li2");
            driver.findElement(By.name("li2")).click();

            // Let's add an item in the list.
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");


            boolean is_displayed =driver.findElement(By.id("addbutton")).isDisplayed();
            driver.findElement(By.id("addbutton")).click();
            // Let's check that the item we added is added in the list.
            String enteredText = driver.findElementByXPath("/html/body/div/div/div/ul/li[6]/span").getText();
            if (enteredText.equals("Yey, Let's add it to list")) {

            }*/
////*[@id="search"]/div[1]/div[2]/div/span[3]/div[1]/div[9]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span
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
            driver.get("http://localhost.lambdatest.com");
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //   FileUtils.copyFile(src, new File("C:/selenium/error.png"));
            Thread.sleep(10000);
            driver.manage().deleteAllCookies();

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(2)); //switches to new tab
            driver.get("https://bestfirms.com/what-is-my-screen-resolution/");
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

