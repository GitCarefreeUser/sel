package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinkText {
    /*
    By.linkText kullanmak icin developer toolsta htm code satirinin tag'i a olmali
    yoksa bu locator calismaz

    newTab folder'i RahulLogin classinda da var
     */

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys("john");
        driver.findElement(By.xpath("//form[@class='form']/input[2]")).sendKeys("White");
        driver.findElement(By.xpath("//form[@class='form']/button")).click();
        System.out.println(driver.findElement(By.xpath("//form[@class='form']/p")).getText());

        //alttaki locator'in html hali su:
        //<a href="#" xpath="1">Forgot your password?</a>
        //tagname a ve By.linkText kullanabiliriz
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        //ama bu satirda bu locator no such element der, bulamaz
        //<button class="reset-pwd-btn" xpath="1">Reset Login</button>
        //tagname a degil cunku
        //  driver.findElement(By.linkText("Reset Login")).click();

    }
}
