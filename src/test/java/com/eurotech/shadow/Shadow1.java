package com.eurotech.shadow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shadow1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");

        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "#userName";
        Thread.sleep(1000);
       SearchContext shadow1 = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
        Thread.sleep(1000);
        shadow1.findElement(By.cssSelector("#kils")).sendKeys("slm");
    }
}
