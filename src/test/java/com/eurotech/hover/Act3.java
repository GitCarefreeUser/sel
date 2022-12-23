package com.eurotech.hover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Act3 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void actionsTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

         Actions actions = new Actions(driver);
         actions.moveToElement(img1).perform();

        WebElement view_profile = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile.getText() = " + view_profile.getText());
        Assert.assertTrue(view_profile.isDisplayed());

    }
}
