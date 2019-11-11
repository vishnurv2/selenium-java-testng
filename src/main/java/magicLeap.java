import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class magicLeap {

    public String username = "prateek_test";
    public String accesskey = "IWLQX1RPCs7WVcOXyUZvmem3Ct9iH1K9XBNb6ofKazKSrAmzxp";
    public RemoteWebDriver driver;
    public String gridURL = "@stage-hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "resolution", "timezone", "geoLocation"})
    public void setUp(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation) throws Exception {
        //  ChromeOptions capabilities = new ChromeOptions();
        FirefoxOptions capabilities = new FirefoxOptions();
        // SafariOptions capabilities = new SafariOptions();
        // InternetExplorerOptions capabilities= new InternetExplorerOptions();
        //  EdgeOptions capabilities = new EdgeOptions();

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", version);
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("build", "freemium 100minutes");
        capabilities.setCapability("name", browser + "  " + version + "  " + platform + "  " + geoLocation);
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
        //  capabilities.setCapability("tunnelName", "Aditya");
        capabilities.setCapability("timezone", timezone);
      //  capabilities.setCapability("tunnel", true);
        capabilities.setCapability("resolution", resolution);
        //   capabilities.setCapability("geoLocation", geoLocation);
      //  capabilities.setCapability("selenium_version", "4.0.0-alpha-2");
        // capabilities.setCapability("chrome.driver","78.0");
        //      capabilities.setCapability("w3c", true);


        try {
            String url = "https://" + username + ":" + accesskey + gridURL; //"https://webhook.site/f06d736f-ed12-4faf-b719-d6846def50ad";
            System.out.println(url);
            driver = new RemoteWebDriver(new URL(url), capabilities);
            System.out.println(driver);

        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void DesktopScript() {
        try {

/*            Cookie ck = new Cookie();
            System.out.println(ck);
            driver.manage().addCookie(ck);*/
            System.out.println(driver.getCapabilities());

            //  driver.manage().window().setSize();
             for (int i=0;i<60;i++){
            driver.get("https://lambdatest.github.io/sample-todo-app/");

            //Let's mark done first two items in the list.
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();

            // Let's add an item in the list.
            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();

            // Let's check that the item we added is added in the list.
            String enteredText = driver.findElementByXPath("/html/body/div/div/div/ul/li[6]/span").getText();
            if (enteredText.equals("Yey, Let's add it to list")) {
                status = "passed";
            }
            Thread.sleep(50000);
            System.out.println("windwo handling start");
/*
            ((JavascriptExecutor) driver).executeScript("window.open()");
            System.out.println("windwo windows open");
            ArrayList<String> ta = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(ta.get(1));
*/

            //switches to new tab
            driver.get("https://www.youtube.com/watch?v=a-T4ZPP3k8U");
            System.out.println("windwos open Url");
            Thread.sleep(50000);
            System.out.println("scroll down");

            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollBy(0,500)");


/*
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2)); //switches to new tab
*/

            driver.get("http://localhost:8080");
            Thread.sleep(30000);
          /*  ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(3));*/ //switches to new tab

            // driver.get("http://localhost.lambdatest.com:4200");
            driver.get("https://bestfirms.com/what-is-my-screen-resolution/");
            Thread.sleep(40000);
            System.out.println("windwo handling stop");

/*
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> another = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(another.get(4));*/

            driver.get("http://localhost:4200/dashboard/");
            Thread.sleep(30000);
            driver.get("https://www.iplocation.net/find-ip-address");
            Thread.sleep(25000);
             }
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

