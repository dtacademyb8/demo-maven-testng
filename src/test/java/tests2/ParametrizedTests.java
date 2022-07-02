package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.TestBase;

public class ParametrizedTests  extends TestBase {


    @Test
    @Parameters ({"USER", "PASS"})
    public void testLoginWithInValidCredentials(String username, String password){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, password, Keys.ENTER);


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        Assert.assertTrue(errorMessage.isDisplayed());

    }

    @Test
    @Parameters ({"first", "second", "third"})
    public void testParams(int one, double two, double three){


        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

    }

}
