package com.eurotech.tests.webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EuroT1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.id("ez-accept-all")).click();
    }

    @Test
    public void test1() {

        WebElement element = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(element.getText());

    }
    @Test
    public void test2() {

        WebElement element = driver.findElement(By.xpath("//table[@border='1']//tr[@class='odd'][1]"));
        //WebElement element = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));

        System.out.println(element.getText());
    }

        //ustteki kodu for'da daha generic yazabiliriz


    @Test
    public void test3() {

        List<WebElement> numsRow = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        for (int i = 1; i <= numsRow.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]"));
            System.out.println(row.getText());


        }
    }
    @Test
    public void test4() {
            List<WebElement> elements = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        for (WebElement element : elements) {
            System.out.println(element.getText());

        }

        }



    }

