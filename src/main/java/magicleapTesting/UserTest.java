package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;

public class UserTest {

    public void TestCase(RemoteWebDriver driver, String status) {
        try {

            driver.get("https://www.google.com/intl/en_in/earth/");
            driver.findElement(By.cssSelector("body > div.ge-hero.ge-hero--home.ge-hero--text-clipping.ng-scope > div > div:nth-child(2) > div > div.ge-chapter__ctas.ge-desktop-only.ctas > div > a")).click();
            Thread.sleep(5000);
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");
            System.out.println(driver.getTitle());

        } catch (InterruptedException e) {
            e.printStackTrace();
            status="failed";
        }

          /*
            driver.findElement(By.className("teachablesnav-search--field")).sendKeys("hello");
            String val = "hello";

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.className("teachablesnav-search--field")));
            actions.click();


            for (int i = 0; i < val.length(); i++){

                char c = val.charAt(i);
                String s = new StringBuilder().append(c).toString();
                System.out.println(s);
                actions.sendKeys(s);

                actions.build().perform();
            }*/

        //   ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

    }
}
