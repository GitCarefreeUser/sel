package com.eurotech.tests.ui_techniques.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.aspnetawesome.com/");
        Thread.sleep(1000);


        driver.findElement(By.id("msearch")).sendKeys("aja");
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='awe-itc']/a"));

        for (WebElement option : options) {
            System.out.println(option.getText());

        }

    }
}
