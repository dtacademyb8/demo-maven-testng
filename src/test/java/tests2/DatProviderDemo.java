package tests2;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.TestBase;
import utilties.CSVReader;

public class DatProviderDemo extends TestBase {


    @Test (dataProvider = "usernamePassCombo", dataProviderClass = DataProviderCollection.class)

    public void testLoginWithInValidCredentials(String username, String password){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username, Keys.TAB, password, Keys.ENTER);


        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        Assert.assertTrue(errorMessage.isDisplayed());

    }




}
