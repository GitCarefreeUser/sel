package com.eurotech.ui_techniques.dropdown.static_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Bir {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/elements");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='header-wrapper']"));
        int expectedSize=6;    //bunu onceden verdiler
        System.out.println(elements.size());

        //assert'te sout yok cikti vermez, sadece fail olursa hata yazar
        //sayfadaki elementlerin 6 tane oldugunu verify ediyoruz
        Assert.assertEquals(elements.size(),expectedSize,"verify that size is 6");

        //sayfadaki elementler gorunuyor mu verify et
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

        //elementlerin textini yazdiralim
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void test2() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> li = driver.findElements(By.tagName("li"));
        /*
        burda locaterda 'li' yerine mesela 'aaa' yazsaydik
        size 0 gelirdi ama no such element hatasi vermez
        list of elements yani list olarak 1 den fazla aldigimizda
        ocater hataliysa hata vermez
        bu hataya dusmemek icin size'ini bir tur yazdirmakta fayda var
        ama tekli element locatinde -findelement- hata yapsaydik no such element derdi
        coklularda -findelements-  hatayi gostermiyor

        driver.findElement(By.xpath("eee"));  bu kod'ta hata verir, nosuch element der
        driver.findElements(By.xpath("eee"));   bunda locater hatali oldugu halde hata gostermez,
         */


        int expectedSize=44;
        int actualSize= li.size();

        System.out.println(li.size());
        Assert.assertEquals(actualSize,expectedSize,"verify that size is 44");

        for (WebElement element : li) {
            Assert.assertTrue(element.isDisplayed());

        }
        for (WebElement element : li) {
            System.out.println(element.getText());

        }
        li.get(0).click();  //0 dan baslar
        //li.get(44).click();  array gibi outofboundexception hatasi verir
        System.out.println(li.get(0).getText());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
}
