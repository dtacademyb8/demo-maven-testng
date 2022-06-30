package tests2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

public class TimeOutTest extends TestBase {



//    @Test (timeOut = 5000)
@Test (priority = 1)
public void testLoginWithValidCredentials1() throws InterruptedException {
    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


    driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);




    Assert.assertEquals(driver.getTitle(), "Web Orders");

}




    @Test (priority = 2)
    public void testLoginWithValidCredentials2() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        Thread.sleep(7000);

        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }

    @Test (priority = 3)
    public void testLoginWithValidCredentials3() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);




        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }

}
