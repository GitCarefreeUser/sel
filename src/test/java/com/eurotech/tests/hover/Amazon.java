package com.eurotech.tests.hover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Amazon {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testName() {
        driver.get("https://www.amazon.nl/gp/buyagain?ref_=nav_cs_buy_again");
        driver.findElement(By.id("ap_email")).sendKeys("aydinserbest34@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Sa21342134");
        driver.findElement(By.id("signInSubmit")).click();
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='nav-al-your-account']/a[@class='nav-link nav-item']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());

        }


    }
}
