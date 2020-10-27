package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class TunnelTest {

    public void tunnelTest(RemoteWebDriver driver, String status, long totaltimeforlocaltest) {


        long localtesttimestart;
        long localtesttimestop;
        localtesttimestart = System.currentTimeMillis();

        try {
            //   for (int i = 0; i < 50; i++) {

            driver.get("http://localhost:8080/");

            driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("admin");
            driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("ba30c16c3f234f2d8d69c5a709772578");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("body > div > div > form > div.submit.formRow > input")).click();

            WebElement JenkinsWelcomeMessage = driver.findElement(By.cssSelector("#main-panel > div:nth-child(3) > h1"));
            System.out.println(JenkinsWelcomeMessage.getAttribute("innerText"));
            Thread.sleep(10000);

            if (driver.findElement(By.cssSelector("#main-panel > div:nth-child(3) > h1")).isDisplayed()) {

                status = "passed";
                System.out.println("Tunnel runs successfully");


            } else {

                status = "failed";
                System.out.println("Tunnel failed");

            }
            driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).click();
            // }
        } catch (Exception j) {
            status = "failed";
            System.out.println(j);
        }

        try {
            driver.get("http://localhost.lambdatest.com:3000/customerlist");

            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/button")).isDisplayed();
            status = "passed";

            System.out.println("Custom Domain working");
        } catch (Exception f) {
            status = "failed";
            System.out.println(f);
        }
        localtesttimestop = System.currentTimeMillis();
        totaltimeforlocaltest = localtesttimestop - localtesttimestart;


        System.out.println("Time taken by the test to execute in local" + "    " + totaltimeforlocaltest / 1000f);
        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

    }
}
