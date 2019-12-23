import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class magicLeap {

    public String username = "prateeks";
    public String accesskey = "utDW23FJGmZgmgmMu1eoF7sZvobSn7Cmdjwbyqbp5qkJd3EYDo";
    public RemoteWebDriver driver;
    public String gridURL = "@stage-hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "resolution", "timezone", "geoLocation"})
    public void setUp(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation) throws Exception {

        //  ChromeOptions capabilities = new ChromeOptions();
        //  FirefoxOptions capabilities = new FirefoxOptions();
        // SafariOptions capabilities = new SafariOptions();
        // InternetExplorerOptions capabilities= new InternetExplorerOptions();
        //  EdgeOptions capabilities = new EdgeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("build", "LeaseWebTesting7");
        capabilities.setCapability("name", browser + "  " + version + "  " + platform );
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
      //  capabilities.setCapability("fixedIP", fixedIp);
      //  capabilities.setCapability("idleTimeout",270);
        // capabilities.setCapability("timezone", timezone);
      //    capabilities.setCapability("tunnel", true);
        //capabilities.setCapability("resolution", resolution);
        //   capabilities.setCapability("geoLocation", geoLocation);
        //  capabilities.setCapability("selenium_version", "4.0.0-alpha-2");
        // capabilities.setCapability("chrome.driver","78.0");
        //   capabilities.setCapability("w3c", false);


        try {
            String url = "http://" + username + ":" + accesskey + gridURL;
            System.out.println(url);
            driver = new RemoteWebDriver(new URL(url), capabilities);
            System.out.println(driver);

        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception f) {
            System.out.println(f.getMessage());
        }
    }

    @Test
    public void DesktopScript() {
        try {


            driver.get("https://lambdatest.github.io/sample-todo-app/");
            Thread.sleep(10000);
            //Let's mark done first two items in the list.
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();

            // Let's add an item in the list.

            Thread.sleep(10000);
            System.out.println("windwo handling start");

            ((JavascriptExecutor) driver).executeScript("window.open()");
            System.out.println("windwo windows open");
            ArrayList<String> ta = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(ta.get(0));


            //switches to new tab
            driver.get("https://www.youtube.com/watch?v=k-xhYEPZBT8");
            System.out.println("windwos open Url");
            Thread.sleep(20000);

            Actions action = new Actions(driver);
            WebElement doubleclick= driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input"));
            action.doubleClick(doubleclick).perform();
            System.out.println("Double click perform");
            //driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input")).click();
            driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input")).sendKeys("lambdaTest");
            driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/button")).click();
            System.out.println("scroll down");
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollBy(0,500)");
            Thread.sleep(10000);
            JavascriptExecutor scrollup = (JavascriptExecutor) driver;
            scrollup.executeScript("window.scrollBy(0,-500)");
            if (driver.findElement(By.linkText("LambdaTest")).isDisplayed()) {
                status = "passed";
                System.out.println("test passed");

            } else {
                status = "failed";
                System.out.println("test Failed");
            }

            //LambdaTest

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); //switches to new tab


            driver.get("http://localhost:8080");
            driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("prateeks");

            if(driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).isDisplayed())
            {
                status="passed";
                System.out.println("test passed");

            }
            else {
                status="failed";
                System.out.println("test Failed");
            }
            driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("9582334806");
            driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).click();
            Thread.sleep(10000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(2)); //switches to new tab

            // driver.get("http://localhost.lambdatest.com:4200");
            driver.get("https://bestfirms.com/what-is-my-screen-resolution/");
            Thread.sleep(10000);
            System.out.println("windwo handling stop");


          /*  ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> another = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(another.get(3));
            try {
                driver.findElement(By.xpath("/html/body/script[3]")).isDisplayed();
                status = "passed";
                System.out.println("test passed");
            } catch (Exception f) {
                status = "failed";
                System.out.println("test failed");
                System.out.println(f);
            }
//driver.findElement(By.xpath("/html/body/script[3]")).isDisplayed();
            driver.get("http://localhost:4200/dashboard/");
            Thread.sleep(10000);
            driver.get("https://www.iplocation.net/find-ip-address");
            Thread.sleep(10000);
            driver.get("http://localhost.lambdatest.com:4200");
            Thread.sleep(10000);
*/

        } catch (Exception e) {
            status = "failed";
            System.out.println("test failed");
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

