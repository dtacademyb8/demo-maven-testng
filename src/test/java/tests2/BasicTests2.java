package tests2;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTests2 {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }


    @AfterClass
    public void tearDownClass(){
        System.out.println("Cleanup once after everything is executed in this class");
    }


    @BeforeMethod
     public void setupMethod(){
         driver =  new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.manage().window().maximize();
     }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }







    @Test
    public void testLoginWithValidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }


    @Test
    public void testLoginWithInValidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Heloo", Keys.TAB, "bdcnbsgh", Keys.ENTER);


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        Assert.assertTrue(errorMessage.isDisplayed());

    }






}
