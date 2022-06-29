package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecutionOrder {

    @Test (priority = 1000, enabled = false )
    public void test1(){
        System.out.println("test1");

    }

    @Test (priority = -4 )
    public void test2(){
        System.out.println("test2");
    }


    @Test (priority = 0 )
    public void a(){
        System.out.println("a");
    }

    @Test (priority = 5 )
    public void b(){
        System.out.println("b");
    }


    @Test
    public void loginTest(){
        System.out.println("loginTest");
    }

    @Test (priority = 5 )
    public void signUpTest(){
        System.out.println("signUpTest");
    }
}
