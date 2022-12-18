package com.eurotech.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frame4 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://demo.automationtesting.in/Frames.html");

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));

        WebElement frame1=driver.findElement(By.id("singleframe"));
        //driver.switchTo().frame(frame1);
        driver.switchTo().frame(frame1);
        driver.findElement(By.tagName("input")).sendKeys("slm");

    }

    /*
    NESTED IFRAME'DE
    LOCATE SONRASI SWITCH
    SONRA DIGER IFRAME LOCATE VE SWITCH GEREKLI

    IKISINI LOCATE EDIP SONRA ALT ALTA 2 SWITCH'TE
    STALE ELEMENT HATASI VERIR
     */

    @Test
    public void test2() {
        //li[.='Iframe with in an Iframe']
        driver.get("https://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("//li[.='Iframe with in an Iframe']")).click();

        WebElement frame1=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));

        driver.switchTo().frame(frame1);

        WebElement frame2=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.tagName("input")).sendKeys("slm");


    }
}
