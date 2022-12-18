package com.eurotech.ui_techniques.checkboxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsDisplayed {


    /*
    element sayfada gorunuyor mu ona bakmak icin
    isDisplayed metodunu kullaniriz

    */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(6000);
        WebElement text=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());

    }
    /*
    alttaki testte hello world yazisi normalde html'de var
    ama start butonuna tiklanmadan sakli duruyor
    bu haliyle zaten kullanamayiz, interactable hatasi verir
    burdaki ornek text ama , o bir buton da olabilirdi
    mesela once click lazim gibi bir durum aktif olmasi icin
    kullanilabilmesi icin
    gorunur olmasi icin
    UI da yok o an icin
    Alert: This element is not interactable through selenium(automation) as it is not visible in UI.
    UI da yok ulasamaz selenium
     */
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement text=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertFalse(text.isDisplayed());
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(6000);

        String expectedTest=driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
        Assert.assertEquals(expectedTest,"Hello World!");

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }
}
