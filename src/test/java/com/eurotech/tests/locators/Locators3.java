package com.eurotech.tests.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators3 {
    /*
    css'te
    id value'dan alma:
    tagname#value ya da sadece #value
    hash value ile mesela 2 match filan cikarsa tagname hash value kullanilabilir
    ornek:
    input#inputUsername
    ya da
    #inputUsername

    class'tan alma:
    tagname.value  ya da   dot value-->   .value
    dot value ile mesela 2 match filan cikarsa tagname dot value kullanilabilir
     */
    /*
    xpath icin normalde
    //tagname[@attribute='value']  -->bu tagname'de attribute'u bu olan value ara  demek
    burda tagname yerine * koyabiliriz-->any tagname'de bu value'yu ara demek
     */

    @Test
    public void testName() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("john");
        driver.findElement(By.xpath("//*[@name='inputPassword']")).sendKeys("white");
        System.out.println(driver.findElement(By.xpath("//*[@name='inputPassword']")).getText());//password bos doner

    }
}
