package com.eurotech.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabled {

    /*
    bazen sayfalarda editboxlar disabled yani kapali gelir
    mesela enable buttonuna tiklamadan orasi acilmaz
    bunu isEnabled() metodu ile test ederiz
    acik , clicklenebilir ise isEnabled true doner
    degilse false doner
    () icinde isEnabled'i true bekliyorsak AssertTrue yazariz
    false bekliyorsak assertFalse deriz
    ( )  ne gore seceriz assert;

     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement element = driver.findElement(By.xpath("//input[@type='text']"));
        //Assert.assertTrue(element.isEnabled());  ( ) ici false bekliyoruz o zaman assert te false secilmeli
        Assert.assertFalse(element.isEnabled());
        //niye ( ) ici false, cunku isEnabled demek tiklanabilir ,acik demek
        //ama sayfada o kisim yani locate ettigimiz yer default olarak kapali disabled geliyor
        //clicklemeden enable olmuyor yani disabled
        //metotta da isEnabled var
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        Thread.sleep(6000);
        System.out.println(element.isEnabled());
        Assert.assertTrue(element.isEnabled());




    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}
