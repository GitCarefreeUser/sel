package com.eurotech.tests.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Two {
    /*
    alert, page'te sag click yapinca inspect edemedigimiz popup'lardir

    testte once ilk is alerti tetikleyen element locate edilir

       */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    /*eurotech'te
    sadece driver.switchTo().alert().accept(); yazmiyor
    ilavesi var Alert variable'ina assign ediyor:
    Alert alert= driver.switchTo().alert();
    alert.accept();
     */

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();  //sag clickte return type zaten Alert veriyor
        //devaminda 2-3 alert daha tiklicaz
        //ama her seferinde switchto.alert yazmaya gerek kalmadi burda bir kere yazinca
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        System.out.println(alert.getText());
        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());

        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("john");
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.findElement(By.id("promptResult")).getText());


    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}
