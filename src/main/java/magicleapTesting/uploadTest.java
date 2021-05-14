package magicleapTesting;

import gherkin.lexer.Th;
import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class uploadTest {

    public void upload(RemoteWebDriver driver, String status) {
        try {
            driver.setFileDetector(new LocalFileDetector());
//            driver.manage().window().maximize();
            //Set Selenium Local File Detector
            driver.get("https://angular-file-upload.appspot.com/");

            driver.findElement(By.xpath("//*[@id=\"editArea\"]/div/div/form/fieldset/input[1]")).sendKeys("lambdatest");

            WebElement uploadElement = driver.findElement(By.xpath("//*[@id=\"editArea\"]/div/div/form/fieldset/input[2]"));
            //Element for file upload
            uploadElement.sendKeys("D:\\New folder\\1.PNG");
            // Upload file system path

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/form/fieldset/button")).click();
            //Click on upload button
           Thread.sleep(5000);
/*
            driver.get("https://qa.worthpoint.com/app/login/auth?parentUrl=/");

            Thread.sleep(5000);
            driver.findElementById("username1").sendKeys("vishnukdas@lambdatest.com");

            driver.findElementById("j_password").sendKeys("Lambdatest@vkdas1");

            driver.findElementById("loginBtn").click();

            driver.get("https://qa.worthpoint.com/app/myWorthPoint/vault/tagManager");

            Thread.sleep(15000);

            WebDriverWait el = new WebDriverWait(driver,30);
            el.until(ExpectedConditions.elementToBeClickable(driver.findElementByClassName("tagName")));

            driver.findElementByClassName("tagName").click();

            Thread.sleep(5000);
            driver.findElementByClassName("ant-checkbox-input").click();


//            driver.findElementByXPath("//*[@id=\"actionDropdown\"]/div[1]").click();
//
////            Actions keyDown = new Actions(driver);
////            keyDown.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();
//
            WebElement testDropDown = driver.findElement(By.xpath("//*[@id=\"actionDropdown\"]/div[1]"));

//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            testDropDown = (WebElement)js.executeScript("arguments[2].removeAttribute('unselectable'); return arguments[2];", testDropDown);

            testDropDown.click();
            Thread.sleep(5000);
            Actions builder = new Actions(driver);
            WebElement hover = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/section/main/div/div/div/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li[3]"));
            hover.isDisplayed();
            builder.moveToElement(hover).perform();
            builder.moveToElement(hover).click().perform();

//            //driver.findElementByXPath("//*[@id=\"b66407df-ce7c-422a-84cc-4d9fa250315c\"]/ul/li[3]").click();
//          //  driver.executeScript("window.open('https://google.com')");
//////            Select dropdown = new Select(testDropDown);
////            testDropDown.click();

///            WebElement SharedC = driver.findElement(By.xpath("//*[@id=\"b66407df-ce7c-422a-84cc-4d9fa250315c\"]/ul/li[3]"));
////            JavascriptExecutor js = (JavascriptExecutor)driver;
////            WebElement ele = (WebElement) js.executeScript("return document.querySelector(\"#b9cf0a04-b9f3-4eff-a10a-11b86ed6d7f6 > ul > li:nth-child(3)\")");
////            js.executeScript("arguments[0].click();", ele);

////            driver.findElement(By.partialLinkText("Create Shared Collection")).click();
////            List<WebElement> li = driver.findElements(By.linkText("Select Action"));
////            li.get(2).click();

//            dropdown.selectByVisibleText("Create Shared Collection");
//
//            Thread.sleep(1000);

            driver.findElementByName("title").sendKeys("Test");
            driver.findElementByName("description").sendKeys("Testing");

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElementByCssSelector("body > div:nth-child(6) > div > div.ant-modal-wrap > div > div.ant-modal-content > div.ant-modal-body > div.styles__StyledModalContent-lqhj42-3.ldPCCr > div > div:nth-child(1) > div:nth-child(4) > div > div.wrapper > div > input[type=file]")));

            WebElement e = driver.findElementByXPath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[4]/div/div[2]/div/input");

                e.sendKeys("C:\\Users\\Lattitude3410\\Desktop\\worthpoint.PNG");
                        driver.findElementByXPath("/html/body/div/div/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/section/main/div/div/div/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div/ul/li[3]").click();

            Thread.sleep(7000);

            driver.findElementByXPath("//*[@id=\"agree\"]").click();

            Thread.sleep(1000);

            driver.findElementByCssSelector("#actionBtn").click();

            Thread.sleep(10000);
*/
            status = "passed";


        } catch (Exception u) {
            System.out.println(u);
            status = "failed";
        }

//        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
    }
}
