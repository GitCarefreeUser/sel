package com.eurotech.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/google.com/");

        driver.navigate().to("https://amazon.nl");
        //navigate sayfanin elementlerinin tam gelmesini beklemez
        //bu yuzden get ( ) tercih edilir
        driver.navigate().back();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.get("https://amazon.nl");
    }
}
