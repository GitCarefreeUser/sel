package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators6 {

    /*
    css'te ^  ve *
    xpath'teki contains ile value icinden bir kismini kesip alabiliyorduk
    css'te contains benzeri
    tagname[attribute*='value-bir kismi']

    xpath'te starts-with benzeri css icin
    tagname[attribute^='value bas kismi']
     */

    /*
    ikinci conus css'te tagname zorunlu degil
    mesela
    [class*=' form-control']
    input[class*=' form-control']
    ya da *[class*=' form-control']
    ucu de locate eder
     */
    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input[id*='nput']")).sendKeys("john");
        driver.findElement(By.cssSelector("input[name^='input']")).sendKeys("white");
    }
}
