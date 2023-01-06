package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class
Locators9 {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("aydin");
        driver.findElement(By.name("inputPassword")).sendKeys("12345");
        driver.findElement(By.xpath("//button[contains(@class,'submit signI')]")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        //text()=  ya da .=
        driver.findElement(By.xpath("//button[.='Reset Login']")).click();

        //tagname ile locate
        System.out.println(driver.findElement(By.tagName("p")).getText());
        String password=driver.findElement(By.tagName("p")).getText();

        String[] newPassword=password.split("\'");
        System.out.println(newPassword.length);
        for (String s : newPassword) { }
        password=newPassword[1];


        //css *  (xpath starts-with gibi)  locators4 classinda da var
        driver.findElement(By.cssSelector("button[class*='go-to-login-']")).click();
        Thread.sleep(1000);


        //locators4 classinda da var, and-or
        driver.findElement(By.cssSelector("input[type='text'][placeholder='Username']")).sendKeys("aydin");

        //30.satir password'u kullaniyoruz
        driver.findElement(By.xpath("//input[@placeholder='password' or @name='inputPassword']")).sendKeys(password);

        //starts-with  locators8

        driver.findElement(By.xpath("//button[starts-with(.,'Sign In')]")).click();
        //soyle de yazabilirdik
        //driver.findElement(By.xpath("//button[starts-with(@class,'submit')]")).click();

        //starts-with ve contains'te attribute sonrasi = yok , var

        System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());

        //ASSERTION

        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText(),"You are successfully logged in.");

        //actual--> page'te olan
        //expected-->olmasini istedigimiz, bekledigimiz cikti

        //assert'te bir sout yok, birsey yazmaz
        //pass ya da fail'den anlariz
    }
}
