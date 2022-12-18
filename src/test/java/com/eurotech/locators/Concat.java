package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Concat {
    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String name="John";
        String password="rahulshettyacademy";

        //name ve password ustte tanimlandi, variable send ediyoruz
        //css parent to child

        driver.findElement(By.cssSelector("form[class='form'] input[placeholder='Username']")).sendKeys(name);

        //xpath parent to child
        driver.findElement(By.xpath("//form[@class='form']/input[@placeholder='Password']")).sendKeys(password);

        //xpath text .=''value texti'
        driver.findElement(By.xpath("//button[.='Sign In']")).click();

        //tagname
        //System.out.println(driver.findElement(By.tagName("h2")).getText());

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        //System.out.println(driver.findElement(By.xpath("//h2[.='Hello John,']")).getText());
        //Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+name+",");


        //"Hello "+name+","  ifadesi dynamic oldu
        //name'e bagli olarak degisir
        //code etkilenmez, her isimde degistirmeye gerek yok
    }

    @Test
    public void test2() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String name="John";
        String password="rahulshettyacademy";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //css # id
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        //tagname de ekleyebiliriz
        //input#inputUsername

        //css parent to child --> arada bir bisluk olacak child'a inerken
        driver.findElement(By.cssSelector("form[class='form'] input[type='password']")).sendKeys(password);

        //xpath text
        //*  tagname yerine kullanilir
        driver.findElement(By.xpath("//button[.='Sign In']")).click();
        //soyle de yazilabilir
        //driver.findElement(By.xpath("//*[.='Sign In']")).click();

        //xpath contains
        //  burda onemli olan = yrine , var
        //alt ornekte text()  yerine . yazdik yaninda da , var

        System.out.println(driver.findElement(By.xpath("//p[contains(.,'You are successfully logged in.')]")).getText());

        System.out.println(driver.findElement(By.xpath("//h1[contains(.,'Welcome to')]")).getText());


        Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(.,'Hello')]")).getText(),"Hello "+name+",");
        driver.findElement(By.cssSelector("button[class*='logout-']")).click();
        driver.close();
    }
}
