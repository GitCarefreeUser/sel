package com.eurotech.dataProvıder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
        TestNG Parameterization
        Parameterization is an execution strategy that runs a test case
        automatically multiple times with various input values.
        The test design provides the provision to read data
        from a file or database rather than hard-coded values.

        In TestNG, there are two ways by which to achieve parameterization:
        1-
        With the help of Parameters annotation and TestNG XML file
        @Parameters({“name”, “searchKey”})
        2-
        With the help of DataProvider annotation
        @DataProvider(name= “searchProvider”)
 */

/*
    ornegin String[][] dataArray = new String[3][2];
    ilk kutu 3--> testin kac tur-defa donecegini gosterir
    ikinci kutu 2-->test kac parametre aliyor
 */

public class Onee {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @DataProvider
    public Object[][]getData(){
        String [][]dataArray={
                {"student","Password123"},
                {"FriendlyBoy","Password123"},
                {"student","123"}

        };
        return dataArray;

    }


    @Test(dataProvider = "getData")
    public void test1(String userName, String password) {

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password")).clear();


    }

}
