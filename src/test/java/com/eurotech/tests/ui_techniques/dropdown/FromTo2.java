package com.eurotech.tests.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FromTo2 {
    ////div[@class='css-1dbjc4n r-b5h31w r-95jzfe'] //div[text()='Ajmer']
        /*
        parent to child 'da eger direk child'i degilse
        araya tek / koyunca bulmuyor
        // lazim
        tek / direk child'i ise olur
        bu sekilde parent'tan child'a gidince
        bu ornekte mesela
        div[text()='Ajmer'] 'yi butun html page'inde degil bu parent icerisinde ara getir diyoruz
        o zaman tek match cikiyor
        ve hardcoding olmuyor
         */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[text()='From']")).click();

        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe'] //div[text()='Ajmer']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='Bengaluru']")).click();
    }
}
