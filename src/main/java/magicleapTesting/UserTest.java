package magicleapTesting;

import org.openqa.selenium.remote.RemoteWebDriver;

public class UserTest {

    public void TestCase(RemoteWebDriver driver, String status) {
        try {

            driver.get("https://161.202.167.2/funrep/");
            Thread.sleep(100000);
          //  driver.findElement(By.xpath("@//XCUIElementTypeAlert//XCUIElementTypeButton[@name='Allow']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(100000);


         /*  LogEntries browserLOgs= driver.manage().logs().get(LogType.BROWSER);
           System.out.println("Safari browser logs Enteries"+"---------------"+ browserLOgs);
*/
            //   for (int i = 0; i < 10; i++)
            // {
           /* Thread.sleep(5000);
            System.out.println(driver.getTitle());

            driver.findElement(By.id("imgBtnRefreshCaptcha")).click();
            Thread.sleep(15000);*/

            //}
          /*  //driver.findElement(By.className("teachablesnav-search--field")).sendKeys("hello");
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

        } catch (Exception T) {
            System.out.println(T);
            status = "failed";

        }
        //   ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);

    }
}
