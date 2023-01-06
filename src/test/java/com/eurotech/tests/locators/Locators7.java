package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators7 {
    /*
    parent to child
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
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);




    }
}

