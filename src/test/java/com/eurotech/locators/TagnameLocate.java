package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TagnameLocate {
    /*
    fileUpload folder'inda
    Upload1 classinda Test1 isimli metotta var ornegi
     */
    /*
    By.tagname("") de sadece value yazilir basina // konmaz
     */
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

        WebElement frame1=driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(frame1);

        //TAGNAME DE SADECE VALUE KONUR BASINA // YOK
        driver.findElement(By.tagName("input")).sendKeys("slm");

    }
    /*
    iframe folder'i Frame3 page'inde var bu kod
            WebElement header = driver.findElement(By.xpath("//h3"));

     */

    /*
    addingCart folder'inda CartAdd classinda da var-->test1 de bak
     */
}
