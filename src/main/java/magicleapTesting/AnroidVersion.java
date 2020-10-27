package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AnroidVersion {

    public void AndVersion(RemoteWebDriver driver, String deviceNameValue, String platformVersionValue) {
        try {
            driver.get("https://whatismyandroidversion.com/");
            Thread.sleep(5000);
            WebElement AndVersionValue = driver.findElement(By.id("results"));
            AndVersionValue.getAttribute("innerText");
            System.out.println("Android Version Value" + "  " + AndVersionValue.getAttribute("innerText") + "   " + deviceNameValue + "  " + platformVersionValue);

        } catch (Exception A) {

        }
    }
}
