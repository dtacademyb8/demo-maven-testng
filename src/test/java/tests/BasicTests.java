package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;



public class BasicTests extends  TestBase{







    @Test (groups = {"homepage", "smoke", "flaky"})
    public void verifyTitleTest() throws InterruptedException {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Web Orderz Bclsd,dvj");


    }


    @Test (groups =  {"smoke"} )
    public void verifyURLTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

    }









}
