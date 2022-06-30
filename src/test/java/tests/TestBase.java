package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;


//    @BeforeClass
//    public void setupClass(){
//        WebDriverManager.edgedriver().setup();
//        System.out.println("Test Base BeforeClass method");
//    }


    @BeforeMethod
    public void setupMethod(){

        driver =  new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}
