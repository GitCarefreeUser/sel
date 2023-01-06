package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators8 {
    /*
    xpath'te
    contains ve text()

    contains'te value'nun bir kismini yazabiliriz
    bastan sondan ortadan farketmez

    //tagname[contains(@attribute,'value-nun bir kismi')]     @attribute sonrasi = yok , var-->onemli, = ile calismaz
    ayni starts-with gibi


    text( ) 'te textin tamamini aliriz------tagname sonrasi [ ] icinde @ kullanmayiz
    //tagname[text()='value']
    //button[text()='Reset Login']        text( ) yerine nokta da koysak olur, soyle:
    //button[.='Reset Login']

    usttekini containsle yazsaydik:
    //button[contains(.,'Reset Login')]    ya da sondan biraz silelim, sonucta contains
    //button[contains(.,'Reset L')]
    //button[contains(text(),'Reset Login')]

    ornek:
    <button class="go-to-login-btn" xpath="1">Go to Login</button>

    //button[contains(.,'Go to Login')]
    //button[contains(text(),'Go to Login')]
    //button[contains(@class,'go-to-login-btn')]

    bunlarda '  ' icine yazdigimiz value'larin bir kismini da yazabilirdik tamami yerine
    //button[contains(@class,'go-to-login')] mesela , -btn kismini sildik
    contains varsa value'nun bir kismi yeterli, attribute veya text () farketmez

    starts-with'i hatirlayalim
    //button[starts-with(text(),'Go to Login')]
    bunda da bas kisim lazim, sondan silebiliriz
    //button[starts-with(text(),'Go to ')]
    ya da
    //button[starts-with(@class,'go-to')]
//button[starts-with(.,'Go to Login')]

    starts-with'de onemli olan @attribute sonrasi = yok , var


     */

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//input[contains(@id,'inputU')]")).sendKeys("john");  //value bir kismi
        driver.findElement(By.xpath("//input[contains(@placeholder,'serna')]")).sendKeys("white"); //value bir kismi
        driver.findElement(By.xpath("//button[contains(@class,'bmit')]")).click();    //value bir kismi
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Reset Login']")).click();
        System.out.println(driver.findElement(By.xpath("//p[contains(.,'Please')]")).getText());
    }
}
