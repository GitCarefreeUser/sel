package com.eurotech.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class One {

    /*
       pop-up is not html based
       it is not tied up to the web
       when we try yo right click , we can't open html window
       because pop up doesn't come from html
       it is javascript alert
       selenium by default can't handle this
       but they have a mechanism where you can switch your driver
       to alert and you can accept it

       this mechanism is the method alert
       so the context switch from driver(or browser) to alert

       drver.switchTo().alert()
       when selenium see this switchTo.alert , it knows if there is any alert on your web page

       there are two types of alert
       1-one is there is only ok button on popup
       2-the other has two opton on alert popup: ok and cancel button

       for ok , we use accept()
       and dismiss() for cancel option


        */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1() {
        String text="john";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        //alerti tetiklemek icin  page'te -bu ornekte-alert ve confirm isimli iki buton koymuslar
        //onlari locate edip hangisini istiyorsak onu kullaniyoruz
        //bu sayede alert popup aciliyor
        driver.findElement(By.id("alertbtn")).click();
        //alert'teki text'i aalim
        String actual=driver.switchTo().alert().getText();
        //--text alma accept ya da dismiss'ten once olmali ki popup kapanmasin
        System.out.println(actual);

        //alert'in ok tusuna basalim
        driver.switchTo().alert().accept();
        //driver/switchTo.alert().... ile control popup sayfasina geciyor
        // ...yerine accept ya da dismiss yaziyoruz, alertin durumuna gore

        String expected="Hello "+text+", share this practice page and share your knowledge";
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void test2() {
        String text="john";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("confirmbtn")).click();
        //alert'teki text'i alalim
        String actual=driver.switchTo().alert().getText();
        //--text alma accept ya da dismiss'ten once olmali ki popup kapanmasin
        System.out.println(actual);

        //alert'in cancel tusuna basalim
        driver.switchTo().alert().dismiss();
        //driver/switchTo.alert().... ile control popup sayfasina geciyor
        // ...yerine accept ya da dismiss yaziyoruz

        String expected="Hello "+text+", Are you sure you want to confirm?";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test3() {
        String text="john";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        //alttaki confirmbtn  ile alerti tetikliyoruz
        //bu sayede alert popup aciliyor
        driver.findElement(By.id("confirmbtn")).click();
        //alert'teki text'i aalim--text alma accept ya da dismiss'ten once olmali ki popup kapanmasin
        String actual=driver.switchTo().alert().getText();
        System.out.println(actual);

        //alert'in accept tusuna basalim
        //driver/switchTo.alert().... ile control popup sayfasina geciyor
        // ...yerine accept ya da dismiss yaziyoruz
        driver.switchTo().alert().accept();
        //   .accept ya da .dismiss popup'taki ok ve cancel butonlarina basar

        String expected="Hello "+text+", Are you sure you want to confirm?";
        Assert.assertEquals(expected,actual);
    }

    //ornek sayfamizdaki hem alert hem confirm butonlarini arka arkaya
    //basip 2 popup uzerinde islem yapalim
    @Test
    public void test4() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys("john");

        //ilk alertimiz
        driver.findElement(By.id("alertbtn")).click();
        driver.switchTo().alert().accept();

        //sayfada hizli aciliyor-gormek icin thread koyduk
        //yoksa run'da sorun yok, thread'siz de geciyor
        Thread.sleep(3000);
        //ikinci alertimiz
        driver.findElement(By.cssSelector("#confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}
