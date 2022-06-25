package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests {





    @Test
    public void verifyTitleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.duotech.io/");

        Assert.assertEquals(driver.getTitle(), "Software QA Automation Engineer program | SDET | QA School | Software ");

        driver.quit();
    }


    @Test
    public void verifyURLTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.duotech.io/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.duotech.io/");

        driver.quit();
    }


}
