package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators5 {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        /*
        contains
        //tagname[contains(@attribute,'value-nun bir kismi')]
         */
        driver.findElement(By.xpath("//input[contains(@id,'Usern')]")).sendKeys("john");

        /*
        css *
        tagname[attribute*='value-bir kismi']
         */
        driver.findElement(By.cssSelector("input[name*='nputPass']")).sendKeys("white");

        /*
        xpath        starts-with
        //tagname[starts-with(@attribute,'value-bas kismi']
                */
        driver.findElement(By.xpath("//button[starts-with(@class,'submit')]")).click();


        /*
        bunu yani starts-with'li olani css'te soyle yazardik:
         driver.findElement(By.cssSelector("button[class^='submit']")).click();

         */
    }

    @Test
    public void test2() {
        /*
        By.name          By.className       By.id
        direk value'lar yapistirilir
        xpath-css'lik durum yok
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("john");
        driver.findElement(By.name("inputPassword")).sendKeys("white");
        driver.findElement(By.className("submit")).click();
    }

    /*
    css'te    id
    tagname#id-value
    ya da direk #id-value
     */

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("white");
       driver.findElement(By.cssSelector("button.submit.signInBtn")).click();

        /*
        ust kodu alttaki iki sekilde de yazabilirdik
         driver.findElement(By.cssSelector("button.submit")).click();
         driver.findElement(By.cssSelector("button.signInBtn")).click();
         driver.findElement(By.cssSelector(".signInBtn")).click();

         //locators4 classinda da var ayni konu

         */
    }
}
