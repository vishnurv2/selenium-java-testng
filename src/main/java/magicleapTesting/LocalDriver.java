package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalDriver {

    public static void main(String[] args) {

        String status = null;
        System.setProperty("webdriver.chrome.driver", "E:\\localDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        try {
          /*  driver.manage().window().maximize();
            WebDriverWait wait=new WebDriverWait(driver, 20);
            driver.get("https://www.nsw.gov.au/");
            driver.findElement(By.id("home-search-autosuggest-input")).sendKeys("Jobs");
            WebElement link;
            link= wait.until(ExpectedConditions.visibilityOfElementLocated  (By.xpath( "//*[@id=\"home-search-autosuggest-list\"]/li[2]")));
            link.click();*/
            driver.manage().window().maximize();
            driver.get("https://www.lambdatest.com/");
            WebElement homePageLogin= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/nav/div/ul/li[6]/a"));
            homePageLogin.click();
            Thread.sleep(2000);
            WebElement username= driver.findElement(By.name("email"));
            username.sendKeys("prateeks@lambdatest.com");
            Thread.sleep(2000);
            WebElement password= driver.findElement(By.name("password"));
            password.sendKeys("9582334806");
            Thread.sleep(2000);
            WebElement loginPlatform= driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[3]/button"));
            loginPlatform.click();
            Thread.sleep(2000);
            WebElement VisualUIOption= driver.findElement(By.className("arrow-menu"));
            VisualUIOption.click();
            Thread.sleep(2000);
            WebElement clickScreenShot= driver.findElement(By.xpath("/html/body/div[2]/header/aside/ul/li[3]/ul/li[1]/a"));
            clickScreenShot.click();
            Thread.sleep(2000);
            WebElement ClickAutomation= driver.findElement(By.cssSelector("body > app-root > app-console > app-header > header > aside > ul > li:nth-child(4) > a"));
            ClickAutomation.click();
            Thread.sleep(2000);
            WebElement AutomationLogs= driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div/main/div/div[2]/div[2]/ul/li[2]/a"));
            AutomationLogs.click();
            Thread.sleep(2000);
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollBy(0,600)");
            scroll.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(2000);
            WebElement AutoamtionAnalyticls= driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div/main/div/div[2]/div[2]/ul/li[3]/a"));
            AutoamtionAnalyticls.click();
            Thread.sleep(2000);
            WebElement userPofile= driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div/main/div/div[2]/div[1]/nav/div/div[2]/ul/li[5]/a/div/span/img"));
            userPofile.click();
            Thread.sleep(2000);
            WebElement Profile= driver.findElement(By.xpath("/html/body/div[2]/div/div/main/div/main/div/div[2]/div[1]/nav/div/div[2]/ul/li[5]/ul/li[2]/a"));
            Profile.click();
            Thread.sleep(2000);
            WebElement userPofilepage= driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[3]/div/ul/li[5]/a"));
            userPofilepage.click();
            Thread.sleep(2000);
            WebElement LogOut= driver.findElement(By.xpath("/html/body/div[2]/header/div/div/div[3]/div/ul/li[5]/div/a[9]"));
            LogOut.click();
           // WebElement DownloadSPeed = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/table/tbody/tr/td/div[2]/div[2]/div/div[1]/h3"));

          /*  driver.get("http://teachables-stage.scholastic.com/teachables/guesthomepage.html");
            driver.manage().window().maximize();

        WebElement search= driver.findElement(By.className("teachablesnav-search--field"));
       // search.setAttribute
            String val = "hello";

            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.className("teachablesnav-search--field")));
            actions.click();


            for (int i = 0; i < val.length(); i++) {

                char c = val.charAt(i);
                String s = new StringBuilder().append(c).toString();
                System.out.println(s);
                actions.sendKeys(s);

                actions.build().perform();
                Thread.sleep(5000);
            }
            search.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(20000);*/
            Thread.sleep(30000);
            driver.quit();
        } catch (Exception e) {
            System.out.println(e);


        }
    }


}
