package tests;

import org.testng.annotations.*;

public class BeforeAndAfterAnnotations {





    @BeforeSuite ()
    public void beforeSuite(){
        System.out.println("Before Suite");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("After Test");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }


    @Test (groups = "flaky")
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }




}
