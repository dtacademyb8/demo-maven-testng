package tests2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.TestBase;

import java.time.Duration;

public class ParametrizedTests2CrossBrowser  {


    @Test
    @Parameters ({"browser"})
    public void testParamCrossBrowser(String browser) throws InterruptedException {
        WebDriver driver = null;

        switch (browser.toLowerCase()){

            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                break;
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                break;

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("afa", Keys.TAB, "cdbhsdv", Keys.ENTER);




//        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_status")).isDisplayed());

        driver.quit();


    }


}
