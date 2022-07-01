package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.TestBase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SoftAssertionsDemo extends TestBase {




    @Test
    public void createOrderEndToEndScenario(){
        int rand = (int) (Math.random() * 3);
        List<String> states = Arrays.asList("VA", "MD", "FL", "DC", "NY", "CA");//states list
        List<String> city = Arrays.asList("Fairfax", "Arlington", "Georgetown", "Alexandria");//city list
        List<String> name = Arrays.asList("Majd fisher", "lara mark", "asif john", "nora fisher");//name list
        int cardtype = utilty.randNumber(0, 2);//to use for visa,master,amex
        String cardnum = "";
        String mm = "";
        String yy = "" + utilty.randNumber(22, 32);
        int foruse = utilty.randNumber(1, 12);
        if (foruse < 10) {
            mm += "0" + foruse;
        }else {mm+=foruse;}



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.linkText("Order")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.chord(Keys.BACK_SPACE
                +"" + rand));
//        driver.findElement(By.xpath())
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
//        Thread.sleep(2000);
        String total = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");
//        Thread.sleep(500);
        int total1 = Integer.parseInt(total);
        softAssert.assertTrue(rand >= 10 && total1 == rand * 92 , "quantity is NOT over 10 and price is NOT matching") ;

        softAssert.assertTrue(rand < 10 && total1 == rand * 100, "quantity is NOT less than 10 and price is NOT matching ");

//        Thread.sleep(500);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name.get(utilty.randNumber(0, name.size())));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("Main" + utilty.generateRandNumberWithLength(4));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city.get(utilty.randNumber(0, city.size())));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(states.get(utilty.randNumber(0, states.size())));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("22" + utilty.generateRandNumberWithLength(3));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + cardtype)).click();

//        Thread.sleep(500);
        if (cardtype == 0) {
            cardnum = "4" + utilty.generateRandNumberWithLength(15);
        } else if (cardtype == 1) {
            cardnum = "5" + utilty.generateRandNumberWithLength(15);
        } else if (cardtype == 2) {
            cardnum = "3" + utilty.generateRandNumberWithLength(14);
        }

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardnum);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(mm + "/" + yy);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        softAssert.assertTrue(driver.getPageSource().contains("New order has been successfully added."));
//        Thread.sleep(500);
        driver.findElement(By.xpath("//a[.='Logout']")).click();
    }



    @Test
    public void softAssertDemo(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Heloo", Keys.TAB, "bdcnbsgh", Keys.ENTER);


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));



        softAssert.assertEquals(driver.getTitle(), "cdhgvsg", "Title is not equal to expected cdhgvsg");

        System.out.println("Second assertion");

        softAssert.assertTrue(!errorMessage.isDisplayed(), "Error message is not displyed");




    }
}
