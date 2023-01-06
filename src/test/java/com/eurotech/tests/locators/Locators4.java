package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators4 {
    /*
     ile baslayan anlaminda
    xpath'te
    //tagname[starts-with(@attribute,'value')]     -------@attribute sonrasi , var     =koyarsak calismaz
    css'te
    tagname[attribute^='value-bir kismi']

    css'te asagidaki ise , * li olan---> xpath'in contains'i gibi
    tagname[attribute*='value-bir kismi']
     */

    @Test
    public void testName() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.cssSelector("input[placeholder*='Username']")).sendKeys("john");
        driver.findElement(By.xpath("//input[starts-with(@name,'inputPassword')]")).sendKeys("white");
        driver.findElement(By.cssSelector("button.submit.submit.signInBtn")).click();
    /*
        css'te class yazilirken
        tagname.value    ya da       .value
        bu value 2 parca ise mesela ,   arada bosluk varsa kapatilir ve o bos kisma nokta konur-->27.satir
        developer tools'ta class value'su arasinda bosluklar varsa  2 ayri class var demektir
        27.satir soyle de yazilabilirdi:
                driver.findElement(By.cssSelector("button.submit")).click();
                driver.findElement(By.cssSelector("button.signInBtn")).click();
                driver.findElement(By.cssSelector(".signInBtn")).click();
         o iki parcanin ikisini de aradaki bosluklari kapatip nokta koyarak azabiliriz
         sadece istedigimiz birini de kullanabiliriz
         tagname yazmadan nokta ile de yazmaya baslayabiliriz
         css'te nokta , class yerine kullanilabilir
         css'tkine benzer durum By.className'de de var
         bosluk birlestirme degil de parcalardan birini kullanma

        By.className ile locate ediyorsak iki class value'sundan birini yazabiliriz
        By.classname(  )  diyoruz
         direk developer toolstan value'yu alip yapistiriyoruz
         By.name veya By.id gibi--value'yu al yapistir:
                                "signInBtn"


        xpath'te boyle 2 value'dan ayirip birini alma yok, o zaman locate etmiyor

     */
    }

    /*
    and ile or

    xpath icin
    //tagname[@attribute='value'][@attribute='value']
    ya da
    //tagname[@attribute='value' and @attribute='value']
    or icin-->>      //tagname[@attribute='value' or @attribute='value']

    css icin or yok-and yazma yok
    tagname[attribute='value']
     */

    @Test
    public void test2() {
        /*
        and -or
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.xpath("//input[@type='text'][@id='inputUsername']")).sendKeys("john");
        driver.findElement(By.cssSelector("input[type='password'][placeholder='Password']")).sendKeys("white");
        //ust code alttaki gibi and ile de yazilabilir:
       // driver.findElement(By.xpath("//button[@type='submit' and @class='submit signInBtn']")).click();
        // ya da uyuyorsa , is gorecekse or ile de yazilabilir:
       // driver.findElement(By.xpath("//button[@type='submit' or @class='submit signInBtn']")).click();
        driver.findElement(By.className("submit")).click();
        //ust satirda @class value'su iki parca  ve bosluklu
        // By.className ile yazarsak birini kullansak da olur
        // bu value'da  2 class var demek
        // ama xpath'te  birini yazma yok--By,className'de var ve de css'te var  33-34. satirlara bak!!!
       //tagname[@class='...']  ile yazacaksak  tum value'yu yazmaliyiz
    }
}
