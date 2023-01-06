package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators1 {
    public static void main(String[] args) throws InterruptedException {

        //FARKLI LOCATORLAR ILE findByelement denedik



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //chrome'u acar, bos olarak,,,,url kismi bos gelir, orda data yazar sadece ve page bos
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //webdriver interface'ine gider, get metodunu ordan kullaniyor, bosysiz orda cunku interface
        //chromedriver classi onu implement ediyor
        //it will invoke browser

    driver.findElement(By.id("inputUsername")).sendKeys("john");
    driver.findElement(By.name("inputPassword")).sendKeys("white");
    driver.findElement(By.linkText("Forgot your password?")).click();
    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("johnny");
    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("bravo");
    driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("12345");
    Thread.sleep(1000);
    driver.findElement(By.className("reset-pwd-btn")).click();
    System.out.println(driver.findElement(By.cssSelector("form p")).getText());  //parent to child css
        // parent to child ile css te yazdik aynisini xpath ile yazalim
        //System.out.println(driver.findElement(By.cssSelector("//form/p")).getText());
        //css'te parent ve child arasinda bir bosluk birakiriz ve basta cift // yok
        //xpath ise // ile baslar ve parent ile child arasi tek / var


        //selenium knows where it has to go
        //By....() parantez icine  " " koyup ve adresi yapistririz

    }
}
