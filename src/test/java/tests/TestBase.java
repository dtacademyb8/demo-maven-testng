package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;



//    @BeforeClass
//    public void setupClass(){
//        WebDriverManager.edgedriver().setup();
//        System.out.println("Test Base BeforeClass method");
//    }


//    @BeforeGroups (groups = "flaky", alwaysRun = true)
//    public void setupBeforeGroups(){
//        System.out.println("Flaky tests");
//    }

    @BeforeMethod (alwaysRun = true)
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }


    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){

        driver.quit();

    }

}
