package tests2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.TestBase;

import java.time.Duration;

public class BasicTests2 extends TestBase {








    @Test (groups = {"homepage", "smoke", "flaky"})
    public void testLoginWithValidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }


    @Test (groups =  {"smoke"} )
    public void testLoginWithInValidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Heloo", Keys.TAB, "bdcnbsgh", Keys.ENTER);


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        Assert.assertTrue(errorMessage.isDisplayed());

    }






}
