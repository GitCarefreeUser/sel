package com.eurotech.alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tree {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));

        //sag click icin contextClick metodu lazim
        //onun icin de actions classi
        Actions actions = new Actions(driver);


        actions.moveToElement(element)
                .contextClick().keyDown(Keys.ARROW_DOWN).perform();
        System.out.println(driver.switchTo().alert().getText());

        //alert icin switchTo().alert lazim
        driver.switchTo().alert().accept();
    }
}
