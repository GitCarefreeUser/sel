package com.eurotech.tests.webtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Rahul1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr/td[4]"));
        for (WebElement element : elements) {
            System.out.println(Integer.parseInt(element.getText()));
            //burda tablodan sutunu aldik ama getTtext string olarak gelir
            //int'a cevrdik parseInt metodu ile

        }
    }
    //sutundaki alt alta olan sayilarin toplamini alalim
    @Test
    public void test2() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='tableFixHead']//tr/td[4]"));

       int sum=0;
        for (WebElement element : elements) {
            sum+=Integer.parseInt(element.getText());

        }
        System.out.println(sum);
        String ar = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String total = ar.split(":")[1].trim();
        int totalLast=Integer.parseInt(total);

        System.out.println(totalLast);

      //  Assert.assertEquals(sum,total);   biri int, digeri string--incompatible type

        Assert.assertEquals(sum,totalLast);

    }
    /*
    SPLIT KONUSU FOLDERSIZ ExampleSplit classinda da VAR
     */
}
