package com.eurotech.tests.waıts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Explicit {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        // Aşağıdaki satır Selenium 4 versiyonu içindir.
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.tagName("button")).click();

        /*
        once webdriverwait classindan object create ederiz
        bu object uzerinden webdriverwait classinin metodunu kullanicaz

         */

        WebDriverWait wWait = new WebDriverWait(driver,Duration.ofSeconds(20));


        //bu classin cesitli metotlari var:
        //element visible olana kadar
        //clicklable olana kadar vb.--durumua gore kullaniriz

        //.until'li metot ilave edilince return type'i webdriverwait degil webelement oluyor
        //WebElement until = wWait.until(ExpectedConditions.elementToBeClickable(By.id("//xpath")));

        //wWait.until(ExpectedConditions.visibilityOfElementLocated())

//        wWait.until(ExpectedConditions.elementToBeClickable(By.xpath("gjfhgjf")));

        WebElement helloText = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='Hello World!']")));


        System.out.println("helloText.getText() = " + helloText.getText());

    }

    @Test
    public void explicitWait2() {

        driver.get("https://google.com/ncr");
        driver.findElement(By.cssSelector("#L2AGLb")).click();

        driver.findElement(By.name("q")).sendKeys("peynir");
        WebElement googledaAra = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        googledaAra.click();

        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        // Print the first result
        System.out.println("firstResult.getText() = " + firstResult.getText());

    }


}
