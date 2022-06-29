package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BasicTests3 {

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
    public void verifyTitleTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Assert.assertEquals(driver.getTitle(), "Web Orderz Bclsd,dvj");


    }


    @Test
    public void verifyURLTest() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

    }









}
