import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Random {
    public String username = "prateeks";
    public String accesskey = "IuCSesD83A7LsTFzEKS0Lb6tzvEfBQ38DMkFTEpudatxxxsdjH";
    public RemoteWebDriver driver;
    public String gridURL = "@eu-central-1-hub.lambdatest.com/wd/hub";
    String status;


    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "fixedIp", "deviceName"})
    public void setUp(String browser, String platformVersion, String platform, String fixedIp, String deviceName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
       // capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", platform); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "JenkinsDeivceseurope");
        capabilities.setCapability("name", browser + platform + deviceName);
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        capabilities.setCapability("deviceName", deviceName);

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
    public void DeviceScript() {
        try {


            driver.get("https://lambdatest.github.io/sample-todo-app/");
            WebElement lambda;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            lambda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("li1")));

            //Let's mark done first two items in the list.
            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();

            // Let's add an item in the list.

            Thread.sleep(10000);
            System.out.println("windwo handling start");


            //switches to new tab
            try {
                driver.get("https://www.youtube.com/watch?v=k-xhYEPZBT8");
                System.out.println("windwos open Url");
                Thread.sleep(20000);
                if (driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input")).isDisplayed()) {
                    System.out.println("Got first Search");
                    driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input")).click();
                    driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/div/div[1]/input")).sendKeys("lambdaTest");
                    driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/ytd-searchbox/form/button")).click();

                    status = "passed";
               /* if (driver.findElement(By.linkText("LambdaTest")).isDisplayed()) {
                    status = "passed";
                    System.out.println("test passed");

                } else {
                    status = "failed";
                    System.out.println("test Failed");
                }*/
                } else {
                    System.out.println("Got Secound Search");
                    driver.findElement(By.xpath("//*[@id=\"header-bar\"]/header/div/button")).click();
                    driver.findElement(By.xpath("//*[@id=\"header-bar\"]/header/ytm-searchbox/form/div/input")).click();
                    driver.findElement(By.xpath("//*[@id=\"header-bar\"]/header/ytm-searchbox/form/div/input")).sendKeys("LambdaTest");
                    driver.findElement(By.xpath("//*[@id=\"header-bar\"]/header/ytm-searchbox/form/button[2]")).click();
                    status = "passed";
                }
                System.out.println("scroll down");
                JavascriptExecutor scroll = (JavascriptExecutor) driver;
                scroll.executeScript("window.scrollBy(0,500)");
                Thread.sleep(10000);
                JavascriptExecutor scrollup = (JavascriptExecutor) driver;
                scrollup.executeScript("window.scrollBy(0,-500)");
                if (driver.findElement(By.partialLinkText("LambdaTest")).isDisplayed()) {
                    status = "passed";
                    System.out.println("test passed");

                } else {
                    status = "failed";
                    System.out.println("test Failed");
                }
            }
            catch (Exception t){
                System.out.println(t);
            }

            //LambdaTest


            driver.get("http://localhost:8080");
            driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("prateeks");

            if (driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).isDisplayed()) {
                status = "passed";
                System.out.println("test passed");

            } else {
                status = "failed";
                System.out.println("test Failed");
            }
            driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("9582334806");
            driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).click();
            Thread.sleep(10000);


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
            driver.get("https://whatsmyos.com/");
            Thread.sleep(10000);
            driver.get("http://localhost.lambdatest.com:4200");
            Thread.sleep(10000);


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

