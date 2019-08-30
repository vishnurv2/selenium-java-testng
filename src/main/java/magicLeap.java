

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class magicLeap {
    public String username = "prateeks";
    public String accesskey = "utDW23FJGmZgmgmMu1eoF7sZvobSn7Cmdjwbyqbp5qkJd3EYDo";
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp"})
    public void setUp(String browser, String version, String platform, String fixedIp) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);
        capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Internet Explorer ");
        capabilities.setCapability("name", browser + platform +fixedIp + version);
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs

        capabilities.setCapability("resolution", "1920x1080");
        capabilities.setCapability("timezone", "UTC+05:30");
        capabilities.setCapability("fixedIP", fixedIp);
     //   capabilities.setCapability("selenium_version","3.13.0");
    //    capabilities.setCapability("edge.popups","true");

        capabilities.setCapability("tunnel", true);
        try {
            String url="https://" + username + ":" + accesskey + gridURL;
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
    public void screenshotSequenceRunner() {
        try {



         /*   driver.get("https://raylo-frontend-staging.herokuapp.com/");
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/button")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/ul[1]/li[1]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/ul[2]/li[1]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/div/ul/li/button")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li/div/div/ul/li/div/ul/li[1]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"invitationCode\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"invitationCode\"]")).sendKeys("dev-234");
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/section[1]/div[2]/div/form/div[2]/div[2]/button")).click();*/

           /* driver.get("https://www.amazon.in");
            driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]")).click();
            Thread.sleep(20000);
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).click();

            driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("headphones");
            driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div")).click();*/


            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> ta = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(ta.get(1)); //switches to new tab
            driver.get("https://www.youtube.com/watch?v=a-T4ZPP3k8U");
          //  driver.get("http://www.localhost.lambdatest.com");
            // driver.findElement(By.id("gbqfb")).isDisplayed();
            Thread.sleep(100000);
//Thread.sleep(90000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2)); //switches to new tab
            driver.get(" http://localhost.lambdatest.com");
            Thread.sleep(10000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(3)); //switches to new tab
            driver.get("https://bestfirms.com/what-is-my-screen-resolution/");
            Thread.sleep(9000);
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tab3 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tab3.get(4)); //switches to new tab
            driver.get("https://www.fast.com/");
            //driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div/div[3]/div[1]/div[1]/a/span[4]")).click();
            Thread.sleep(100000);

            SessionId session = ((RemoteWebDriver) driver).getSessionId();

            System.out.println("Session id: " + session.toString());


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

