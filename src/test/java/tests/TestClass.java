package tests;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {


    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver =  new ChromeDriver();
//        driver.get("https://www.duotech.io/");

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver =  new FirefoxDriver();
//        driver.get("https://www.duotech.io/");


        Faker faker =  new Faker();


        System.out.println(faker.address().streetAddress());

        System.out.println(faker.address().lastName());

        System.out.println(faker.business().creditCardNumber());

        System.out.println(faker.chuckNorris().fact());




    }
}
