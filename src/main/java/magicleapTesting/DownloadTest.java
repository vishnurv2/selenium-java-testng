package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class DownloadTest {

    public void FileDownload(RemoteWebDriver driver){

        try{
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().frame("iframeResult");

            WebElement element = driver.findElement(By.xpath("//a[@href='/images/myw3schoolsimage.jpg']"));
            element.click();

            Thread.sleep(4000);

            Assert.assertEquals(((JavascriptExecutor) driver).executeScript("lambda-file-exists=myw3schoolsimage.jpg"), true); //file exist check

            System.out.println(((JavascriptExecutor) driver).executeScript("lambda-file-stats=myw3schoolsimage.jpg")); //retrieve file stats

            String base64EncodedFile = ((JavascriptExecutor) driver).executeScript("lambda-file-content=myw3schoolsimage.jpg").toString(); // file content download
            System.out.println(base64EncodedFile);


            byte[] data = Base64.getDecoder().decode(base64EncodedFile);
            OutputStream stream = new FileOutputStream("myw3cImage.jpg");
            stream.write(data);

        }catch (Exception e){

        System.out.println(e);
        }


    }
}
