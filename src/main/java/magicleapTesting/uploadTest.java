package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class uploadTest {

    public void upload(RemoteWebDriver driver, String status) {
        try {
            driver.setFileDetector(new LocalFileDetector());
            //Set Selenium Local File Detector
            driver.get("https://angular-file-upload.appspot.com/");

            driver.findElement(By.xpath("//*[@id=\"editArea\"]/div/div/form/fieldset/input[1]")).sendKeys("lambdatest");

            WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"editArea\"]/div/div/form/fieldset/input[2]"));
            //Element for file upload
            uploadElement.sendKeys("E:\\New folder\\1mb.jpg");
            // Upload file system path

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/form/fieldset/button")).click();
            //Click on upload button
            status = "passed";


        } catch (Exception u) {
            System.out.println(u);
            status = "failed";
        }

        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
    }
}
