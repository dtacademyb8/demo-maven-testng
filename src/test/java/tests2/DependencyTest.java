package tests2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DependencyTest  {

    public WebDriver driver;


    @BeforeClass
    public void setupClass(){
        WebDriverManager.edgedriver().setup();
        driver =  new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }





    @AfterClass
    public void tearDownClass(){
        driver.quit();
    }

    @Test
    public void testLoginWithValidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "tester", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Order");

    }


    @Test (dependsOnMethods = {"testLoginWithValidCredentials"})
    public void testDeleteSelected(){


        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.name("ctl00$MainContent$btnDelete")).click();

        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_orderMessage")).isDisplayed());

    }

}
